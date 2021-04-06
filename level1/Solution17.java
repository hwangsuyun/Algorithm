package programmers.level1;

// 수박수박수박수박수박수?
public class Solution17 {
	public static void main(String[] args) {
		int n = 5;
		if (n < 1 || n > 10000) return;
		solution(n);
	}
	
	public static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			// 조건문
			if (i % 2 == 0) sb.append("수");
			else sb.append("박");
			// 삼항 연산자
			// sb.append(i % 2 == 0 ? "수" : "박"); 
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
