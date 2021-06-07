package programmers.level2;

// JadenCase 문자열 만들기
public class Solution32 {
	public static void main(String[] args) {
		String s = "3people unFollowed me";
		//String s = "for the last week";
		if (s.length() < 1) return;
		solution(s);
	}
	
	public static String solution(String s) {
		s = s.toLowerCase();
		String result = "";
		boolean flag = true;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
				flag = false;
				result += s.charAt(i);
			} else if ((s.charAt(i) < '0' || s.charAt(i) > '9') && s.charAt(i) != ' '){
				if (flag) {
					flag = false;
					result += (char) (s.charAt(i) - 32);
				}
				else result += s.charAt(i);
			} else if (s.charAt(i) == ' ') {
				flag = true;
				result += s.charAt(i);
			}
		}
		System.out.println(result);
		return result;
	}
}
