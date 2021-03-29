package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;

public class Solution9 {
	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};
		int divisor = 15;
		
		solution(arr, divisor);
	}
	
	public static int[] solution(int[] arr, int divisor) {
		if (divisor < 1) return null;
		if (arr.length < 1) return null;
		
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 1) return null;
			if (arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}
		if (list.size() == 0) list.add(-1); 
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		return list.stream().mapToInt(i -> i.intValue()).toArray();
	}
}
