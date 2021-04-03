package programmers.level1;

// 문자열 다루기 기본
public class Solution14 {
	public static void main(String[] args) {
		String s = "1234";
		if (s.length() < 1 || s.length() > 8) return;
		solution(s);
	}
	
	public static boolean solution(String s) {
		// ver1 (for 문 사용)
		/* 
		boolean answer = false;
		if (s.length() == 4 || s.length() == 6) answer = true;
		for (int i = 0; i < s.length(); i++) {	
			if (s.charAt(i) < 48 || s.charAt(i) > 57) {
				answer = false;
				break;
			}
		}
		System.out.println(answer);
		return answer;
		*/
	
		// ver2 (stream, 람다식 사용)
		if (s.length() != 4 && s.length() != 6) return false;
		long cnt = s.chars().filter(i -> i < '0' || i > '9').count();
		return  cnt > 0 ? false : true;
	}
}
