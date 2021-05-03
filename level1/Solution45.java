package programmers.level1;

import java.util.stream.IntStream;

// 내적
public class Solution45 {
	public static void main(String[] args) {
		// int[] a = {1, 2, 3, 4}, b = {-3, -1, 0, 2}; // 3
		int[] a = {-1, 0, 1}, b = {1, 0, -1}; // -2
		
		if (a.length < 1 || a.length > 1000) return;
		if (b.length < 1 || b.length > 1000) return;
		
		for (int i : a) {
			if (i < -1000 || i > 1000) return;
		}
		
		for (int i : b) {
			if (i < -1000 || i > 1000) return;
		}
		
		//System.out.println(solution(a, b));
		System.out.println(solution2(a, b));
	}
	
	// 일반 반복문 사용
	public static int solution(int[] a, int[] b) {
		int answer = 0;
		
		for (int i = 0; i < a.length; i++) {
			answer += a[i] * b[i];
		}
		
		return answer;
	}
	
	// 람다식 사용
	public static int solution2(int[] a, int[] b) {
		return IntStream.range(0, a.length).map(index -> a[index] * b[index]).sum();
	}
}
