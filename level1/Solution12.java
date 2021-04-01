package programmers.level1;

// 문자열 내 p와 y의 개수
public class Solution12 {
	public static void main(String[] args) {
		String s = "pPoooyY";
		solution(s);
	}
	
	public static boolean solution(String s) {
		if (s.length() < 1 || s.length() > 50) return true;
		String temp = s.toUpperCase();
		boolean answer = true;
		int pCnt = 0, yCnt = 0;
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) < 65 || temp.charAt(i) > 90) return true;
			if (temp.charAt(i) == 'P') pCnt++;
			else if (temp.charAt(i) == 'Y') yCnt++;
		}
		if (pCnt == yCnt) answer = true;
		else if (pCnt != yCnt) answer = false;
		System.out.println("pCnt : " + pCnt);
		System.out.println("yCnt : " + yCnt);

		return answer;
	}
}
