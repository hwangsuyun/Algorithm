package programmers.level1;

// 자릿수 더하기
public class Solution22 {
	public static void main(String[] args) {
		//int n = 123;
		int n = 987;
		if (n < 1 || n > 100000000) return;
		solution(n);
	}
	
	public static int solution(int n) {
		String str = n + "";
		n = 0;
		for (int i = 0; i < str.length(); i++) {
			n += Integer.parseInt(str.substring(i, i + 1));
		}
		System.out.println(n);
		return n;
	}
}
