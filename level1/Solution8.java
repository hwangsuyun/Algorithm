package programmers.level1;

public class Solution8 {
	public static void main(String[] args) {
		int[] arr = {4, 4, 4, 3, 3};
		solution(arr);
	}
	
	public static int[] solution(int[] arr) {
		if (arr.length < 0 || arr.length > 1000000) return null;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0 || arr[i] > 9) return null;
		}
		
		int count = 0, index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == arr.length - 1) break;
			if (arr[i] == arr[i + 1]) {
				arr[i] = -1;
				count++;
			}
		}
		int[] answer = new int[arr.length - count];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1) {
				answer[index] = arr[i];
				index++;
			}
		}
		return answer;
	}
}
