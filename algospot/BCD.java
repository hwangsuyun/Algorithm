package algospot.lowestquestion;

import java.math.BigInteger;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;

/**
 * CBD 변환 클래스
 */
public class BCD
{
	private final byte CR = 0x0D;
	
	/**
	 * 숫자를 BCD byte배열로 변환하는 메소드
	 * @param number 변환 대상 숫자
	 * @param digitCount 숫자 개수
	 * @return BCD byte array
	 */
	private byte[] DecToBCDArray(BigInteger number, int digitCount) {

		byte tmp, foo;
		int idx = 0;
		int byteLen = digitCount % 2 == 0 ? digitCount / 2 : (digitCount + 1) / 2;

		byte bcd[] = new byte[byteLen];
		
		for (int i = 0; i < digitCount; i++) {
			//tmp = (byte) (number % 10);
			tmp = (byte) number.mod(BigInteger.valueOf(10)).intValue();
			idx = i / 2;

			if (i % 2 == 0)
				bcd[idx] = tmp;
			else {
				foo = (byte) (tmp << 4);	//왼쪽으로 shift
				bcd[idx] |= foo;			//xor로 4bit set
			}

			//number /= 10;
			number = number.divide(BigInteger.valueOf(10));
		}

		for (int i = 0; i < byteLen / 2; i++) {
			tmp = bcd[i];
			bcd[i] = bcd[byteLen - i - 1];
			bcd[byteLen - i - 1] = tmp;
		}

		return bcd;
	}
	
	/**
	 * 숫자를 BCD byte배열로 변환하는 메소드
	 * @param number 변환 대상 숫자
	 * @return BCD byte array
	 */
	public byte[] DecToBCDArray(long number) {
		
		BigInteger bi = new BigInteger( String.format("%d", number) );

		return DecToBCDArray(bi, bi.toString().length());
	}
	
	/**
	 * 숫자를 BCD byte 배열로 변환하는 메소드
	 * @param number 변환 대상 숫자
	 * @return BCD byte array
	 */
	public byte[] DecToBCDArray(int number) {
		return DecToBCDArray( (long)number );
	}

	/**
	 * 문자열로 된 숫자를 BCD byte 배열로 변환하는 메소드
	 * @param number 변환 대상 숫자
	 * @return BCD byte array
	 */
	public byte[] DecStringToBCDArray(String numberString) {
		String numStr = numberString.replace(" ", "");	//공백제거
		BigInteger bi;
		
		try {

			bi = new BigInteger( numStr );
		} catch(Exception e) {
			return null;
		}
		
		return DecToBCDArray( bi, numStr.length() );
	}

	/**
	 * BCD byte를  숫자 문자열로 변환
	 * @param bcd  
	 * @return 문자열 숫자
	 */
	public String BCDtoString(byte bcd) {
		StringBuffer sb = new StringBuffer();

		byte high = (byte) (bcd & 0xf0);
		high >>>= (byte) 4; 
		high = (byte) (high & 0x0f);
		byte low = (byte) (bcd & 0x0f);

		sb.append(high);
		sb.append(low);

		return sb.toString();
	}

	/**
	 * BCD byte 배열을  숫자 문자열로 변환
	 * @param bcd 배열
	 * @return 문자열 숫자
	 */
	public String BCDtoString(byte[] bcd) {
		StringBuffer sb = new StringBuffer();
		
		try {
			for (int i = 0; i < bcd.length; i++) {
				sb.append(BCDtoString(bcd[i]));
			}
		}catch( Exception e) {
			return "";
		}

		return sb.toString();
	}
	
	/**
	 * BCD byte 배열을  숫자 문자열로 변환
	 * @param bcd 배열
	 * @return 문자열 숫자
	 */
	public int getBCDLen(int digitCount) {
		
		return digitCount % 2 == 0 ? digitCount / 2 : (digitCount + 1) / 2;
	}
	
	/**
	 * 문자열로 된 숫자를 BCD byte 배열로 변환하는 메소드
	 * @param number 변환 대상 숫자
	 * @return BCD byte array
	 */
	public byte[] Track2ToBCDArray(String track2String) {
		
		String track2 = track2String.replace(" ", "");	//공백제거

		String[] tmp = track2.split("=");
		byte[] firstData = null;
		byte secondData;
		byte[] thirdData = null;
		int cardLen = tmp[0].length();
		
		byte[] result = null;
		
		if( tmp.length == 1 || tmp.length == 2 ) {
			int resultSize = 0;

			BigInteger firstNum = new BigInteger( tmp[0].substring(0, (cardLen-1)) );

			//1. 카드번호의 마지막 자리는 잘라냄.
			int secondNum = Integer.parseInt( tmp[0].substring((cardLen-1)) );
			BigInteger thirdNum = null;

			/*
			 * 2. 카드번호 마지막 한자리를 제외하고 BCD 처리(잘라낸 카드번호가 홀수이면 앞에 0x0 padding)
			 *  - 1자리 잘라낸 카드번호가 123456789012345 -> 0x 01 23 45 67 89 01 23 45
			 *  - 1자리 잘라낸 카드번호가 12345678901234  -> 0x 12 34 56 78 90 12 34
			 */
			firstData = DecToBCDArray( firstNum, (cardLen-1) );

			/*
			 * 3. 카드번호 한자리와 '=' 기호는 0x0D로 하여 카드번호 한자리를 4bit shift한 후 xor로 1byte 표현
			 *  - ex) "6=" -> 0x6D, "7=" -> 0x7D, "0=" -> 0x0D  
			 */
			secondData = (byte)(secondNum << 4);	//왼쪽으로 shift
			secondData |= CR;						//xor로 4bit set
			
			resultSize = firstData.length + 1;
			
			if( tmp.length == 2) {				// = 과 유효기간이 있는 경우
				//4. 유효기간과 TRACK2 데이터 BCD 표현
				if( tmp[1].length() % 2 == 0 ) {		//짝수인 경우
					thirdNum = new BigInteger( tmp[1] );
					thirdData = DecToBCDArray( thirdNum, tmp[1].length() );
				} else {								//홀수인 경우
					int size = tmp[1].length() - 1;
					
					thirdNum = new BigInteger( tmp[1].substring(0, size) );
					int endData = Integer.parseInt( tmp[1].substring(size) );
					
					byte[] temp = DecToBCDArray( thirdNum, size );
				
					thirdData = new byte[temp.length + 1];
					System.arraycopy(temp, 0, thirdData, 0, temp.length);
	
					thirdData[temp.length] = (byte)(endData << 4);	//왼쪽으로 shift
				}
				
				resultSize += thirdData.length; 
			}
			
			result = new byte[resultSize];
			
			System.arraycopy(firstData, 0, result, 0, firstData.length);
			result[ firstData.length ] = secondData;
			if( thirdData != null) {
				System.arraycopy(thirdData, 0, result, firstData.length + 1, thirdData.length);
			}

		} else if( tmp.length == 1 ) {			//카드번호만 있는경우
			BigInteger firstNum = new BigInteger( track2 );
			result = DecToBCDArray( firstNum, track2.length() );		
		}

		return result;
	}
	
	/**
	 * BCD track2 데이터를 문자열로 변환하는 메소드
	 * @param track2bcd BCD byte array
	 * @return track2 string
	 */
	public String Track2BCDToString(byte[] track2bcd) {
		StringBuffer sb = new StringBuffer();
		byte high, low;
		
		for (int i = 0; i < track2bcd.length; i++) {
			high = (byte) (track2bcd[i] & 0xf0);
			high >>>= (byte) 4; 
			high = (byte) (high & 0x0f);
			low = (byte) (track2bcd[i] & 0x0f);

			if( high < 10 )
				sb.append(high);
			else 
				sb.append("=");
			
			if( low < 10 )
				sb.append(low);
			else 
				sb.append("=");
		}
		
		return sb.toString();
	}
	
	/**
	 * BCD 카드 번호를 문자열로 변환하는 메소드
	 * @param cardNoLen 카드번호 길이 정보
	 * @param cardNoBcd BCD byte array
	 * @return cardno string
	 */
	public String CardNoBCDToString(int cardNoLen, byte[] cardNoBcd) {
		StringBuffer sb = new StringBuffer();
		byte high, low;
		
		for (int i = 0; i < cardNoBcd.length; i++) {
			high = (byte) (cardNoBcd[i] & 0xf0);
			high >>>= (byte) 4; 
			high = (byte) (high & 0x0f);
			low = (byte) (cardNoBcd[i] & 0x0f);

			sb.append(high);
			sb.append(low);
		}
		
		if( cardNoLen %2 == 0 )
			return sb.toString();
		
		return sb.deleteCharAt(0).toString();
	}
	
	public static void main(String[] args) {
		
		BCD bcd = new BCD();
		String str = "1234567890";
		String track2Str;
		//track2Str = "1234567890123450=20120000000000000001";
		track2Str = "1234567890123450 = 1234";
		track2Str = "1234567890123450";
		int num = 2017022;
		
		
		byte []temp2 = bcd.DecStringToBCDArray("123456   ");
		for(int i = 0; i < temp2.length; i++ )
			System.out.print(String.format("%02X", temp2[i]));
		System.out.println();
		
		
		byte []temp = bcd.Track2ToBCDArray(track2Str);
		System.out.print("Track2ToBCDArray DATA[" + track2Str + "] => ");
		for(int i = 0; i < temp.length; i++ )
			System.out.print(String.format("%02X", temp[i]));
		System.out.println();
		
		HexBinaryAdapter hexAdapter = new HexBinaryAdapter();
		
		System.out.println( "BCDCardNoToString DATA  => " + bcd.CardNoBCDToString(16, hexAdapter.unmarshal("0123456789012345")));
		
		System.out.println();
		
		temp = bcd.DecToBCDArray(num);
		System.out.println(bcd.BCDtoString(temp));
		System.out.print(String.format("SIZE:%02d, DATA:", temp.length));
		for(int i = 0; i < temp.length; i++ )
			System.out.print(String.format("%02X", temp[i]));

		System.out.println();
		System.out.println();

		temp = bcd.DecToBCDArray(1234567890);
		System.out.println(bcd.BCDtoString(temp));
		System.out.print(String.format("SIZE:%02d, DATA:", temp.length));
		for(int i = 0; i < temp.length; i++ )
			System.out.print(String.format("%02X", temp[i]));
		
	}
}
