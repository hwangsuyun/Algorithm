package programmers.level2;

// 점프와 순간 이동
public class Solution36 {
	public static void main(String[] args) {
		//int n = 5;    // 2
		//int n = 6;    // 2
		int n = 5000; // 5
		if (n < 1 || n > 100000000) return;
		solution(n);
	}
	public static int solution(int n) {
		int jump = 1;
		while (n > 1) {
			if (n % 2 == 1) {
				jump++;
				n -= 1;
				n /= 2;
			}
			else n /= 2;
		}
		System.out.println(jump);
		return jump;
	}
}
