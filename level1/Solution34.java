package programmers.level1;

// x만큼 간격이 있는 n개의 숫자
public class Solution34 {
	public static void main(String[] args) {
		//int x = 2;
		//int n = 5;
		//int x = 4;
		//int n = 3;
		int x = -4;
		int n = 2;
		if (x < -10000000 || x > 10000000) return;
		if (n < 1 || n > 1000) return;
		solution(x, n);
	}
	
	public static long[] solution(int x, int n) {
		long[] answer = new long[n];
		for (int i = 0; i < n; i++) {
			answer[i] = (Long.valueOf(x) * (i + 1));
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
		return answer;
	}
}
