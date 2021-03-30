package programmers.level1;

public class Solution10 {
	public static void main(String[] args) {
		int a = 5;
		int b = 3;
		solution(a, b);
	}
	
	public static long solution(int a, int b) {
		if (a < -10000000 || a > 10000000) return -1;
		if (b < -10000000 || b > 10000000) return -1;
		
		long answer = 0L;
		if (a == b) answer = a;
		else if (a > b) {
			for (int i = b; b <= a; b++) {
				answer += b;
			}
		} else {
			for (int i = a; a <= b; a++) {
				answer += a;
			}
		}
		System.out.println(answer);
		return answer;
	}
}
