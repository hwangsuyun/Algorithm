package programmers.level1;

import java.util.Arrays;

// ���ڿ� ������������ ��ġ�ϱ�
public class Solution13 {
	public static void main(String[] args) {
		String s = "Zbcdefg";
		//String s = "ASKDsdfkiDkDd";
		if (s.length() < 1) return;
		solution(s);
	}
	
	public static String solution(String s) {
		int[] array = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			array[i] = s.charAt(i);
		}
		Arrays.sort(array);;
		s = "";
		char[] cArray = new char[array.length];
		for (int i = array.length - 1; i >= 0; i--) {
			cArray[i] = (char) array[i];
			s += cArray[i];
		}
		System.out.println(s);
		return s;
	}
}
