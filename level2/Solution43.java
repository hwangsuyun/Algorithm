package programmers.level2;

// 멀쩡한 사각형
public class Solution43 {
	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		
		if (w < 1 || w > 100000000) return;
		if (h < 1 || h > 100000000) return;
		
		System.out.println(solution(w, h));
	}
	
	public static long solution(int w, int h) {
		return (long) w * h - ((w + h) - gcd(w, h));
    }
	
	private static int gcd(int n, int m) {
		if (m == 0) return n;
		return gcd(m, n % m);
	}
	
}
