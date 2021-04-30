package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

// [두 개 뽑아서 더하기]
public class Solution42 {
	public static void main(String[] args) {
		//int[] numbers = {2, 1, 3, 4, 1}; // 2, 3, 4, 5, 6, 7
		//int[] numbers = {5, 0, 2, 7}; // 2, 5, 7, 9, 12
		int[] numbers = {1, 2, 4, 8, 16, 32, 64}; // 3, 5, 6, 9, 10, 12, 17, 18, 24, 33, 34, 36, 40, 48, 65, 66, 68, 72, 80, 96
		if (numbers.length < 2 || numbers.length > 100) return;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0 || numbers[i] > 100) return;
		}
		solution(numbers);
	}
	
	public static int[] solution(int[] numbers) {
		HashSet<Integer> hashSet = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		int index = 0;
		
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j <= numbers.length - 1; j++) {
				hashSet.add(numbers[i] + numbers[j]);
			}
		}

		for (Integer i : hashSet) {
			list.add(i);
		}
		Collections.sort(list);
		
		int[] answer = new int[list.size()];
		for (int i : list) {
			answer[index] = i;
			index++;
		}
		
		for (int i : answer) {
			System.out.print(i + ", ");
		}
		
        return answer;
	}
}
