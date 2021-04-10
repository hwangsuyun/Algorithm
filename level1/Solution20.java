package programmers.level1;

// 약수의 합
public class Solution20 {
	public static void main(String[] args) {
		int n = 12;
		if (n < 0 || n > 3000) return;
		solution(n);
	}
	
	public static int solution(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (n % i == 0) result += i;
		}
		System.out.println(result);
		return result;
	}
}
