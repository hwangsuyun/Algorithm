package programmers.level1;

// 시저 암호
public class Solution19 {
	public static void main(String[] args) {
		String s = "a B z";
		int n = 25;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != ' ' && 
					(s.toUpperCase().charAt(i) < 'A' || s.toUpperCase().charAt(i) > 'Z')) return;
		}
		if (s.length() < 1 || s.length() > 8000) return;
		if (n < 1 || n > 25) return;
		solution(s, n);
	}
	
	public static String solution(String s, int n) {
		char[] array = new char[s.length()];
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			array[i] = s.charAt(i);
			if (array[i] == ' ') {
				str += array[i];
				continue;
			}
			if ((array[i] >= 'A' && array[i] <= 'Z')) {
				array[i] += n;
				if (array[i] > 'Z') array[i] -= 26;
			} else if (array[i] >= 'a' && array[i] <= 'z') {
				array[i] += n;
				if (array[i] > 'z') array[i] -= 26;
			}
			str += array[i];
		}
		
		System.out.println(str);
		return str;
	}
}
