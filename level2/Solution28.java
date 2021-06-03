package programmers.level2;

import java.util.Arrays;

// ÃÖ´ñ°ª°ú ÃÖ¼Ú°ª
public class Solution28 {
	public static void main(String[] args) {
		//String s = "1 2 3 4";
		String s = "-1 -2 -3 -4";
		//String s = "-1 -1";
		int cnt = 0;
		boolean blank = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') blank = true;
			else if (s.charAt(i) >= '1' && s.charAt(i) <= '9') cnt++;
		}
		if (!blank && cnt == 0) return;
		System.out.println(solution(s));
	}
	
	public static String solution(String s) {
		String[] sArray = s.split(" ");
		int[] array = new int[sArray.length];
		for (int i = 0; i < sArray.length; i++) {
			array[i] = Integer.parseInt(sArray[i]);
		}
		Arrays.sort(array);
		return array[0] + " " + array[array.length - 1];
	}
}
