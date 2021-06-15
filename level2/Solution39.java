package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// 문자열 압축
public class Solution39 {
	public static void main(String[] args) {
		//String s = "aabbaccc"; // 2a2ba3c => 7
		//String s = "ababcdcdababcdcd"; // 2ababcdcd => 9
		//String s = "abcabcdede"; // 2abcdede => 8
		//String s = "abcabcabcabcdededededede"; // 2abcabc2dedede => 14
		String s = "xababcdcdababcdcd"; // xababcdcdababcdcd => 17
		if (s.length() < 1 || s.length() > 1000) return;
		
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		int stepResult = 0;
		int answer = s.length();
		int change = 0;
		for (int length = 1; length <= s.length(); length++) {
			String temp = s;
			if (temp.length() % length != 0) {
				change = length - temp.length() % length;
				for (int i = 0; i < change; i++) temp += " ";
			}
			
			stepResult = compress(length, temp);
			if (answer > stepResult) answer = stepResult;
		}
		
        return answer;
    }
	
	private static int compress(int length, String temp) {
 		int index = 0;
		String[] strArray = new String[temp.length()];
		String result = "";
		
		for (int i = 0; i < temp.length(); i += length) {
			if (length + i > temp.length()) break;
			strArray[index] = temp.substring(i, length + i);
			index++;
		}
		
		Queue<String> queue = new LinkedList<>();
		for (String str : strArray) {
			if (str == null) break;
			queue.add(str);
		}
		
		int count = 1;
		temp = queue.poll();
		while (!queue.isEmpty()) {
			if (temp.equals(queue.peek())) {
				queue.poll();
				count++;
			} else {
				if (count > 1) {
					result += count + temp;
				}
				else {
					result += temp;
				}
				temp = queue.poll();
				count = 1;
			}
		}
		if (count > 1) result += count + temp;
		else result += temp;
		
		result = result.trim();
		System.out.println("result : " + result);
		
		return result.length();
	}
}
