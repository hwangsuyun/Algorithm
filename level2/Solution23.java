package programmers.level2;

// ¿Ã¹Ù¸¥ °ýÈ£
public class Solution23 {
	public static void main(String[] args) {
		//String s = "()()";
		//String s = "(())()";
		//String s = ")()(";
		String s = "(()(";
		if (s.length() < 1 || s.length() > 100000) return;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '(' && s.charAt(i) != ')') return;
		}
		solution(s);
	}
	
	public static boolean solution(String s) {
		boolean flag = false;
		int cnt = 0;
		if (s.charAt(0) == '(') {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(') cnt++;
				else cnt--;
				if (cnt < 0) break;
			}
			if (cnt == 0) flag = true;
		}
		System.out.println(flag);
		return flag;
	}
}
