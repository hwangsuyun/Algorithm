package programmers.level1;

// 이상한 문자 만들기
public class Solution21 {
	public static void main(String[] args) {
		//String s = "try hello world";
		//String s = "AAAAAAAAAAA A A A A AAAAA AAA";
		//String s = "AaAaAaAaAaA A A A A AaAaA AaA";
		String s = "A  ";
		solution(s);
	}
	
	public static String solution(String s) {		
		StringBuilder sb = new StringBuilder();
		int index = 0;
		char[] array = new char[s.length()];
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				array[i] = ' ';
				index = 0;
			} else {
				if (index % 2 == 0) {
					if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
						array[i] = s.charAt(i);
					} else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
						array[i] = (char) (s.charAt(i) - 32);
					}
				} else {
					if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
						array[i] = (char) (s.charAt(i) + 32);
					} else if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
						array[i] = s.charAt(i);
					}
				}
				index++;
			}
		}
		for (char c : array) {
			sb.append(c);
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
