package programmers.level1;

public class Solution7 {
	public static void main(String[] args) {
		String s = "abcde";
		solution(s);
	}
	
	public static String solution(String s) {
		if (s.length() < 1 || s.length() > 100) return null;
		
		String answer = "";
		if (s.length() % 2 == 1) {
			//answer = s.substring(s.length() / 2, s.length() / 2 + 1);
		} else {
			answer = s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
		}
		
		System.out.println(answer);
		return answer;
	}
}
