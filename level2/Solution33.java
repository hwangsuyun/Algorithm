package programmers.level2;

// N개의 최소 공배수
public class Solution33 {
	public static void main(String[] args) {
		//int[] arr = {2, 6, 8, 14};
		int[] arr = {1, 2, 3};
		if (arr.length < 1 || arr.length > 15) return;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0 || arr[i] > 100) return;
		}
		solution(arr);
	}
	
	public static int solution(int[] arr) {
		int cnt = 0, result = 0;
		for (int i = 1; i < 1000000000; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i < arr[j]) break;
				if (i % arr[j] == 0) cnt++;
			}
			if (cnt == arr.length) {
				result = i;
				break;
			}
			cnt = 0;
		}
		System.out.println(result);
		return result;
	}
}
