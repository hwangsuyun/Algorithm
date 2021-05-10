package programmers.level2;

import java.util.Stack;

// 기능개발
public class Solution5 {
	public static void main(String[] args) {
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		//int[] progresses = { 40, 93, 30, 55, 60, 65 };
		//int[] speeds = { 60, 1, 30, 5, 10, 7 };
		//int[] progresses = {93, 30, 55, 60, 40, 65};
		//int[] speeds = {1, 30, 5 , 10, 60, 7};
		if (progresses.length < 1 || progresses.length > 100) return;
		if (speeds.length < 1 || speeds.length > 100) return;
		for (int i = 0; i < progresses.length; i++) {
			if (progresses[i] > 99) return;
		}
		for (int i = 0; i < speeds.length; i++) {
			if (speeds[i] > 100) return;
		}
		solution(progresses, speeds);
	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int sum = 0, count = 0, index = 0, size = 0;
		int[] temp = new int[progresses.length];
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < progresses.length; i++) {
			sum = progresses[i];
			while (sum < 100) {
				sum += speeds[i];
				count++;
			}
			stack.push(count);
			count = 0;
		}
		// 7, 3, 9
		// 1 7 3 9 4 5
		count = 1;
		while (!stack.isEmpty()) {
			sum = stack.get(index);
			if (stack.size() == 1) {
				temp[size] = count;
				stack.remove(index);
				size++;
				break;
			}
			if (sum < stack.get(index + 1)) {
				stack.remove(index);
				temp[size] = count;
				size++;
				count = 1;
			} else {
				stack.remove(index + 1);
				count++;
			}
		}
		
		int[] result = new int[size];
		for (int i = 0; i < result.length; i++) {
			result[i] = temp[i];
			System.out.println(result[i]);
		}
		return result;
	}
}
