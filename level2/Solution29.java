package programmers.level2;

import java.util.Arrays;

// 최솟값 만들기
public class Solution29 {
	public static void main(String[] args) {
		int[] A = {1, 4, 2};
		int[] B = {5, 4, 4};
		//int[] A = {1, 2};
		//int[] B = {3, 4};
		if (A.length < 1 || A.length > 1000) return;
		if (B.length < 1 || B.length > 1000) return;
		for (int i = 0; i < A.length; i++) {
			if (A[i] < 1 || A[i] > 1000) return;
		}
		for (int i = 0; i < B.length; i++) {
			if (B[i] < 1 || B[i] > 1000) return;
		}
		solution(A, B);
	}
	
	public static int solution(int[] A, int[] B) {
		int result = 0;
		Arrays.sort(A);
		Arrays.sort(B);
		for (int i = 0; i < A.length; i++) {
			result += A[i] * B[B.length - i - 1];
		}
		System.out.println(result);
		return result;
	}
}
