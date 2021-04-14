package programmers.level1;

// 정수 내림차순으로 배치하기
public class Solution24 {
	public static void main(String[] args) {
		long n = 118372;
		solution(n);
	}
	
	public static long solution(long n) {
		String str = n + "";
		String[] temp = new String[str.length()];
		long[] array = new long[str.length()]; 
		for (int i = 0; i < str.length(); i++) {
			temp[i] = (str.substring(i, i + 1));
			array[i] = Long.parseLong(temp[i]);
		}
		
		n = 0;
		str = "";
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j <= array.length; j++) {
				if (j == array.length) break;
				if (array[i] < array[j]) {
					n = array[j];
					array[j] = array[i];
					array[i] = n;
				}
			}
			str += array[i] + "";
		}
		System.out.println(str);
		return Long.parseLong(str);
	}
}
