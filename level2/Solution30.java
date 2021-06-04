package programmers.level2;

// 피보나치 수
// top-down
public class Solution30 {
	public static void main(String[] args) {
		//int n = 3;
		int n = 5;
		if (n < 1 || n > 100000) return;
		solution(n);
	}
	
	public static int solution(int n) {
		int result = 0;
		int[] dp = new int[n + 1];
		result = fibonacci(n, dp);
		System.out.println(result);
		return result;
	}
	
	public static int fibonacci(int n, int[] dp) {
		int num = 1234567;
		if (n <= 2) dp[n] = 1;
		else {
			if (dp[n] == 0) dp[n] = (fibonacci(n - 1, dp) % num + fibonacci(n - 2, dp) % num) % num;
		}
		return dp[n] % num;
	}
}
