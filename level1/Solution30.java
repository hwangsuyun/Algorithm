package programmers.level1;

// Æò±Õ ±¸ÇÏ±â
public class Solution30 {
	public static void main(String[] args) {
		//int[] arr = {1, 2, 3, 4};
		int[] arr = {5, 5};
		if (arr.length < 1 || arr.length > 100) return;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < -10000 || arr[i] > 10000) return;
		}
		solution(arr);
	}
	
	public static double solution(int[] arr) {
		double result = 0;
		for (int i : arr) {
			result += i;
		}
		System.out.println(result / arr.length);
		return result / arr.length;
	}
}
