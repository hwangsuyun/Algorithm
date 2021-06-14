package programmers.level2;

// 
public class Solution38 {
	public static void main(String[] args) {
		//int n = 8;
		//int a = 4;
		//int b = 7;
		int n = 8;
		int a = 2;
		int b = 3;
		if (n < 2 || n > 588288) return;
		if (a < 1 || a > n) return;
		if (b < 1 || b > n) return;
		if (a == b) return;
		solution(n, a, b);
	}
	public static int solution(int n, int a, int b) {
		int result = 0;
		while (true) {
			result++;
			if (a > b) {
				if (a % 2 == 0) {
					if (a + 1 == b || a == b + 1) break;
				}
			} else {
				if (b % 2 == 0) {
					if (a + 1 == b || a == b + 1) break;
				}
			}
			if (a % 2 == 0) a /= 2;
			else a = a / 2 + 1;
			if (b % 2 == 0) b /= 2;
			else b = b / 2 + 1;
		}
		System.out.println(result);
		return result;
	}
}
