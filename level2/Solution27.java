package programmers.level2;

// 숫자의 표현
public class Solution27 {
	public static void main(String[] args) {
		int n = 15;
		if (n < 1 || n > 10000) return;
		solution(n);
	}
	
	public static int solution(int n) {
		int result = 1;
		for (int i = 1; i <= n / 2; i++) {
			result += sum(n, i);
		}
		System.out.println(result);
		return result;
	}
	
	public static int sum(int n, int begin) {
		int total = n, result = 0;
		while (begin < n) {
			total -= begin;
			if (total == 0) {
				result++;
				break;
			} else if (total < 0) break;
			begin++;
		}
		return result;
	}
}
