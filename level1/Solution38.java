package programmers.level1;

// 키패드 누르기
public class Solution38 {
	public static void main(String[] args) {
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}; // LRLLLRLLRRL
		String hand = "right";
		//int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}; // LRLLRRLLLRR
		//String hand = "left";
		//int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}; // LLRLLRLLRL
		//String hand = "right";
		if (numbers.length < 1 || numbers.length > 1000) return;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0 || numbers[i] > 9) return;
		}
		System.out.println(solution(numbers, hand));
	}
	
	public static String solution(int[] numbers, String hand) {
		String result = "";
		int left = 10;
		int right = 12;
		int leftMove = 0;
		int rightMove = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				result += "L";
				left = numbers[i];
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				result += "R";
				right = numbers[i];
			} else {
				if (numbers[i] == 0) {
					numbers[i] = 11;
				}

				leftMove = Math.abs(numbers[i] - left);
				rightMove = Math.abs(numbers[i] - right);
				leftMove = leftMove / 3 + leftMove % 3;
				rightMove = rightMove / 3 + rightMove % 3;
				if (leftMove < rightMove) {
					result += "L";
					left = numbers[i];
				} else if (leftMove > rightMove) {
					result += "R";
					right = numbers[i];
				} else if (leftMove == rightMove) {
					if (hand.equals("left")) {
						result += "L";
						left = numbers[i];
					} else if (hand.equals("right")) {
						result += "R";
						right = numbers[i];
					}
				}
			}
		}
		return result;
	}
	
}
