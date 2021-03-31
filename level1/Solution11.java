package programmers.level1;

import java.util.Collections;

public class Solution11 {
	public static void main(String[] args) {
		//String[] strings = {"abcd", "cdx", "abc", "abcde"};
		//String[] strings = {"abce", "abcd", "cdx"};
		String[] strings = {"sun", "bed", "car"};
		int n = 1;
		solution(strings, n);
	}
	
	public static String[] solution(String[] strings, int n) {
		if (strings.length < 1 || strings.length > 50) return null;

		String temp = "";
		for (int i = 0; i < strings.length; i++) {
			if ((strings[i].length() < 1 || strings[i].length() > 100) && strings[i].length() < n) return null;
			
			for (int j = i + 1; j < strings.length; j++) {
				// 비교하여 큰 경우
				if (strings[i].charAt(n) > strings[j].charAt(n)) {
					// 값을 비교하여 큰 경우는 큰 값을 뒤로 보내고 작은 값을 앞으로 가져옴
					temp = strings[j];
					strings[j] = strings[i];
					strings[i] = temp;
				// 비교하여 같은 경우
				} else if (strings[i].charAt(n) == strings[j].charAt(n)) {
					int size = 0;
					if (strings[i].length() > strings[j].length()) size = strings[j].length();
					else size = strings[i].length();
					int count = 0;
					// 한 글자씩 다시 비교
					for (int k = 0; k <= size; k++) {
						// 글자가 다 같으나 길이 비교
						if (count == size) {
							if (strings[i].length() > strings[j].length()) {
								temp = strings[j];
								strings[j] = strings[i];
								strings[i] = temp;
								break;
							}
							break;
						}
						// 한 글자씩 비교
						if (strings[i].charAt(k) > strings[j].charAt(k)) {
							temp = strings[j];
							strings[j] = strings[i];
							strings[i] = temp;
							break;
						} else if (strings[i].charAt(k) < strings[j].charAt(k)) {
							break;
						} else {
							count++;
							continue;
						}
					}
				}
			}	
		}
		for (int i = 0; i < strings.length; i++) {
			System.out.println(strings[i]);
		}
		
		return strings;
	}
}
