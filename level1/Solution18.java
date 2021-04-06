package programmers.level1;

// 문자열을 정수로 바꾸기
public class Solution18 {
	public static void main(String[] args) {
		String s = "-1234";
		if (s.length() < 1 || s.length() > 5) return;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(0) < '0' || s.charAt(0) > '9') {
				if (s.charAt(0) != '-' && s.charAt(0) != '+') return;
			}
			if (s.charAt(0) == '0') return;
			if (s.charAt(0) == '-' && s.charAt(1) == '0') return;
			if (s.charAt(i) < '0' && s.charAt(i) > '9') return;
		}
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		return Integer.parseInt(s);
	}
}
