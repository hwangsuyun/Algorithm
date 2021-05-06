package programmers.level2;

import java.util.Stack;

// ž
public class Solution1 {
	public static void main(String[] args) {
		//int[] height = {6, 9, 5, 7, 4};
		//int[] height = {3, 9, 9, 3, 5, 7, 2};
		int[] height = {1, 5, 3, 6, 7, 6, 5};
		if (height.length < 2 || height.length > 100) return;
		for (int i = 0; i < height.length; i++) {
			if (height[i] < 1 || height[i] > 100) return;
		}
		solution(height);
	}
	
	public static int[] solution(int[] heights) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[heights.length];
		for (int i = 0; i < heights.length; i++) {
			stack.push(heights[i]);
		}
		
		for (int i = heights.length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				if (stack.get(i) < stack.get(j)) {
					//result[i] = stack.get(j);
					result[i] = j + 1;
					break;
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		
		return result;
	}
}
