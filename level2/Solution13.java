package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

// 가장 큰 수
public class Solution13 {
	static boolean flag = false;
	public static void main(String[] args) {
		int[] numbers = {6, 10, 2}; // -> 6210
		//int[] numbers = { 30, 3, 34, 5, 9 }; // -> 9534330
		//int[] numbers = {40, 403}; // -> 40403
		// int[] numbers = {40, 405}; // -> 40540
		// int[] numbers = {40, 404}; // -> 40440
		// int[] numbers = {12, 121}; // -> 12121
		// int[] numbers = {2, 22, 223}; // -> 223222
		// int[] numbers = {21, 212}; // -> 21221
		// int[] numbers = {41, 415}; // -> 41541
		// int[] numbers = {2, 22}; // -> 222
		// int[] numbers = {70, 0, 0, 0}; // -> 70000
		// int[] numbers = {0, 0, 0, 0}; // -> 0
		// int[] numbers = {0, 0, 0, 1000}; // -> 1000000
		// int[] numbers = {5, 546}; // -> 5546

		if(numbers.length < 1 || numbers.length > 100000) return;
		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] < 0 || numbers[i] > 1000) return;
		}
		solution(numbers);
	}
	public static String solution(int[] numbers) {
		String[] array = new String[numbers.length];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < numbers.length; i++) {
			array[i] = numbers[i] + "";
		}
		
		Arrays.sort(array, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if (!o1.equals(o2)) flag = true;
				return (o2 + o1).compareTo(o1 + o2);
			}
		});

		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
			sb.append(array[i] + "");
			if (!flag) break;
		}
		System.out.println("result : " + sb.toString());
		return sb.toString();
	}
}
