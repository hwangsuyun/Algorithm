package programmers.level2;

// 큰 수 만들기
public class Solution10 {
	public static void main(String[] args) {
		//String number = "1924"; // -> 94
		//int k = 2;
		//String number = "1231234"; // -> 3234
		//int k = 3;
		String number = "4177252841"; // -> 775841
		int k = 4;
		//String number = "10000"; // -> 100
		//int k = 2;
		if (number.length() < 1 || number.length() > 1000000) return;
		if (k < 1 || k > number.length()) return;
		solution(number, k);
	}
	public static String solution(String number, int k) {
		StringBuilder temp = new StringBuilder();
		StringBuilder result = new StringBuilder();
		int index = 0, size = 0;
		char ch = ' ';
		size = number.length();
		
		while (k > 0) {
			temp.replace(0, number.length(), number.substring(0, k + 1));
			ch = temp.charAt(0);

			for (int i = 1; i < temp.length(); i++) {
				if (ch < temp.charAt(i)) {
					ch = temp.charAt(i);
					index = i;
				}
			}
			k -= index;
			number = number.substring(index + 1);
			result.append(ch);
			index = 0;
			if (result.length() == size - k) break;
			if (k == 0) result.append(number);
		}
		System.out.println("result : " + result.toString());
		return result.toString();
	}
}

