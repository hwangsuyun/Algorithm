package programmers.level2;

import java.util.ArrayList;

// °ýÈ£ º¯È¯
public class Solution47 {
	public static void main(String[] args) {
		//String p = "(()())()"; // (()())()
		//String p = ")("; // ()
		String p = "()))((()"; // ()(())()
		
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) != '(' && p.charAt(i) != ')') return;
		}
		if (p.length() < 2 || p.length() > 1000) return;
		
		System.out.println(solution(p));
	}
	
	public static String solution(String p) {
		if (checkRightString(p)) {
			return p;
		}
		
		String answer = "";
        answer = recursive(p);
		
		return answer;
	}
	
	private static boolean checkRightString(String p) {
		int leftParenthesis = 0, rightParenthesis = 0;
		
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') leftParenthesis++;
			else rightParenthesis++;
			
			if (rightParenthesis > leftParenthesis) return false;
		}
		
		if (leftParenthesis == rightParenthesis) return true;
		
		return false;
	}
	
	private static String recursive(String p) {
		// step1
		if (p.equals("")) return "";
		
		String u = "";
		String v = "";
		ArrayList<String> list = new ArrayList<>();
		
		// step2
		list = divideBalanceString(p);
		u = list.get(0);
		v = list.get(1);
		
		System.out.println("u : " + u);
		System.out.println("v : " + v);
		
		// step3
		if (checkRightString(u)) {
			// step3-1
			u += recursive(v);
		} else {
			// step4
			// step4-1
			String temp = "(";
			// step4-2
			temp += recursive(v);
			// step4-3
			temp += ")";
			// step4-4
			u = u.substring(1, u.length() - 1);
			String reverseU = "";
			for (char ch : u.toCharArray()) {
				if (ch == '(') reverseU += ')';
				else if (ch == ')') reverseU += '(';
			}
			temp += reverseU;
			u = temp;
		}
		
		return u;
	}
	
	private static ArrayList<String> divideBalanceString(String p) {
		ArrayList<String> list = new ArrayList<>();
		int leftParenthesis = 0, rightParenthesis = 0;
		
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '(') leftParenthesis++;
			else rightParenthesis++;
			
			if (leftParenthesis == rightParenthesis) break;
		}
		
		list.add(p.substring(0, leftParenthesis + rightParenthesis));
		list.add(p.substring(leftParenthesis + rightParenthesis));
		
		return list;
	}
}
