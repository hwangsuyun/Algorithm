package programmers.level1;

// 신규 아이디 추천
public class Solution43_1 {
	public static void main(String[] args) {
		//String new_id = "...!@BaT#*..y.abcdefghijklm"; // bat.y.abcdefghi
		//String new_id = "z-+.^."; // z--
		//String new_id = "=.="; // aaa
		//String new_id = "123_.def"; // 123_.def
		String new_id = "abcdefghijklmn.p"; // abcdefghijklmn 
		
		if (new_id.length() < 1 || new_id.length() > 1000) return;
		
		System.out.println(solution(new_id));
	}
	
	public static String solution(String new_id) {
		String answer = "";
		
		answer = step1(new_id);
		new_id = answer;
		System.out.println("step1 : " + answer);
		
		answer = step2(new_id);
		new_id = answer;
		System.out.println("step2 : " + answer);
		
		answer = step3(new_id);
		new_id = answer;
		System.out.println("step3 : " + answer);
		
		answer = step4(new_id);
		new_id = answer;
		System.out.println("step4 : " + answer);
		
		answer = step5(new_id);
		new_id = answer;
		System.out.println("step5 : " + answer);
		
		answer = step6(new_id);
		new_id = answer;
		System.out.println("step6 : " + answer);
		
		answer = step7(new_id);
		System.out.println("step7 : " + answer);
		
        return answer;
	}
	
	public static String step1(String new_id) {
		return new_id.toLowerCase();
	}
	
	public static String step2(String new_id) {
		String answer = "";
		for (char ch : new_id.toCharArray()) {
			if (ch >= '0' && ch <= '9') {
				answer += ch;
			} else if (ch >= 97 && ch <= 122) {
				answer += ch;
			} else if (ch == '-') {
				answer += ch;
			} else if (ch == '_') {
				answer += ch;
			} else if (ch == '.') {
				answer += ch;
			}
		}
		return answer;
	}
	
	public static String step3(String new_id) {
		String answer = "";
		for (int i = 0; i < new_id.length(); i++) {
			if (new_id.charAt(i) == '.') {
				if (i + 1 < new_id.length() && new_id.charAt(i + 1) == '.') {
					continue;
				} else {
					answer += new_id.charAt(i);
				}
			} else {
				answer += new_id.charAt(i);
			}
		}
		return answer;
	}
	
	public static String step4(String new_id) {
		String answer = "";
		for (int i = 0; i < new_id.length(); i++) {
			if (i == 0 && new_id.charAt(i) == '.') {
				continue;
			} else if (i == new_id.length() - 1 && new_id.charAt(i) == '.') {
				continue;
			} else {
				answer += new_id.charAt(i);
			}
		}
		return answer;
	}
	
	public static String step5(String new_id) {
		String answer = "";
		if (new_id.equals("")) {
			answer = "a";
		} else {
			answer = new_id;
		}
		return answer;
	}
	
	public static String step6(String new_id) {
		String answer = "";
		if (new_id.length() >= 16) {
			answer = new_id.substring(0, 15);
			
			while (true) {
				if (answer.charAt(answer.length() - 1) == '.') {
					answer = answer.substring(0, answer.length() - 1);
				} else {
					break;
				}
			}
		}
		else {
			answer = new_id;
		}
		return answer;
	}
	
	public static String step7(String new_id) {
		String answer = "";
		if (new_id.length() <= 2) {
			while (true) {
				if (new_id.length() == 3) {
					break;
				} else {
					new_id += new_id.charAt(new_id.length() - 1);
				}
			}
			answer = new_id;
		}
		else {
			answer = new_id;
		}
		return answer;
	}
}
