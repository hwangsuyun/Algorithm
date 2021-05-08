package programmers.level2;

// 124 나라의 숫자
public class Solution3 {
	public static void main(String[] args) {
		int n = 38;
		if (n < 1 || n > 500000000) return;
		solution(n);
	}
	// 1, 2, 4, 11, 12, 14, 21, 22, 24, 41, 42, 44, 111, 112, 114, 121, 122, 124, 
	// 141, 142, 144, 211, 212, 214, 221, 222, 224, 241, 242, 244, 
	// 411, 412, 414, 421, 422, 424, 441, 442, 444
	public static String solution(int n) {
		String temp = "", result = "";
		int share = 0, reminder = 0;
		
		while (true) {
			share = (n - 1) / 3;
			reminder = n % 3;
			if (reminder == 0) reminder = 4;
			n = (n - 1) / 3;
			temp += reminder + "";
			if (share == 0) break;
		}
		
		for (int i = temp.length() - 1; i >= 0; i--) {
			result += temp.charAt(i);
		}
		
		System.out.println("result : " + result);
		return result;
	}
}
