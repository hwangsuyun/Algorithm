package programmers.level1;

// ���ڿ� �ٷ�� �⺻
public class Solution14 {
	public static void main(String[] args) {
		String s = "1234";
		if (s.length() < 1 || s.length() > 8) return;
		solution(s);
	}
	
	public static boolean solution(String s) {
		// ver1 (for �� ���)
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
	
		// ver2 (stream, ���ٽ� ���)
		if (s.length() != 4 && s.length() != 6) return false;
		long cnt = s.chars().filter(i -> i < '0' || i > '9').count();
		return  cnt > 0 ? false : true;
	}
}
