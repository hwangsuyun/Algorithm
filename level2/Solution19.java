package programmers.level2;

// Å¸°Ù ³Ñ¹ö
public class Solution19 {
	static int result = 0;
	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5};
		int target = 3;
		if (numbers.length < 2 || numbers.length > 20) return;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 1 || numbers[i] > 50) return;
		}
		if (target < 1 || target > 1000) return;
		solution(numbers, target);
	}
	
	public static int solution(int[] numbers, int target) {
		result = recursiveStep(numbers, target, 0, 0);
		
		System.out.println(result);
		return result;
	}
	public static int recursiveStep(int[] numbers, int target, int step, int num) {
		if (step == numbers.length) {
			return num == target ? 1 : 0;
		} else {
			result = recursiveStep(numbers, target, step + 1, num + numbers[step]) 
					+ recursiveStep(numbers, target, step + 1, num - numbers[step]);
		}
		return result;
	}
}
