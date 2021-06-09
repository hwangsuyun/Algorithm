package programmers.level2;

import java.util.ArrayList;

// 짝지어 제거하기
public class Solution34 {
	public static void main(String[] args) {
		String s = "baabaa";
		//String s = "cdcd";
		if (s.length() < 1 || s.length() > 1000000) return;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < 'a' || s.charAt(i) > 'z') return;
		}
		System.out.println(solution(s));
	}
	public static int solution(String s) {
		char[] cArray = s.toCharArray();
		ArrayList<Character> list = new ArrayList<>();
		for (Character character : cArray) {
			add(list, character);
		}
		return list.isEmpty() ? 1 : 0;
	}
	public static void add(ArrayList<Character> list, char c) {
		list.add(c);
		if (list.size() > 1 && list.get(list.size() - 2) == list.get(list.size() - 1)) {
			list.remove(list.size() -1);
			list.remove(list.size() -1);
		}
	}
}
