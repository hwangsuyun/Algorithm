package programmers.level1;

// 최대공약수와 최소공배수
public class Solution28 {
	public static void main(String[] args) {
		int n = 180;
		int m = 72;
		if (n < 1 || n > 1000000) return;
		if (m < 1 || m > 1000000) return;
		solution(n, m);
	}
	
	public static int[] solution(int n, int m) {
		int[] answer = {0, 0};
		int maxNum = 0;
		int minNum = 0;
		for (int i = n; i <= n; i--) {
			if (i == 0) break;
			if (n % i == 0) {
				if (m % i == 0) {
					maxNum = i;
					break;
				}
			}
		}
		for (int i = 1; i <= n * m; i++) {
			if (i % n == 0 && i % m == 0) {
				minNum = i;
				break;
			}
		}
		answer[0] = maxNum;
		answer[1] = minNum;
		System.out.println(answer[0]);
		System.out.println(answer[1]);
		return answer;
	}
}
