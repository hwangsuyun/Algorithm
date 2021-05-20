package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;

// H-Index
public class Solution14 {
	public static void main(String[] args) {
		//int[] citations = {3, 0, 6, 1, 5};
		//int[] citations = {1, 2, 3, 3, 3, 3, 4, 4, 5, 6, 7, 7, 8, 8, 9, 9, 10, 10, 10};
		//int[] citations = {0, 0, 0, 0};
		int[] citations = {22, 42};
		if (citations.length < 1 || citations.length > 1000) return;
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] < 0 || citations[i] > 10000) return;
		}
		solution(citations);
	}
	
	public static int solution(int[] citations) {
		int index = 0;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < citations.length; i++) {
			list.add(citations[i]);
		}
		Collections.sort(list, Collections.reverseOrder());
		for (Integer i : list) {
			if (i <= index) break;
			index++;
		}
		System.out.println(index);
		return index;
	}
}
