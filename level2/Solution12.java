package programmers.level2;

import java.util.LinkedList;

// 소수 찾기
public class Solution12 {
	static LinkedList<Integer> list = new LinkedList<>();
	public static void main(String[] args) {
		String numbers = "17";
		//String numbers = "011";
		//String numbers = "0132";
		if (numbers.length() < 1 || numbers.length() > 7) return;
		for (int i = 0; i < numbers.length(); i++) {
			if (numbers.charAt(i) < 0 && numbers.charAt(i) > 9) return;
		}
		solution(numbers);
	}
	public static int solution(String numbers) {
		int result = 0, cnt = 1;
		int[] array = new int[numbers.length()];
		for (int i = 0; i < numbers.length(); i++) {
			array[i] = Integer.parseInt(numbers.charAt(i) + "");
		}
		while (cnt <= numbers.length()) {
			perm(array, 0, numbers.length(), cnt);
			cnt++;
		}
		for (int i = 0; i < list.size(); i++) {
			result += searchDecimal(list.get(i));
		}
		System.out.println(result);
		return result;
	}
	// 순열(배열 내 모든 경우의 수 구하기)
	public static void perm(int[] arr, int depth, int n, int k) {
		if(depth == k){
			putData(arr, k);
			return;
		}
		for(int i = depth; i < n; i++){
			swap(arr, i, depth);
			perm(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}
	public static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	public static void putData(int[] arr, int n){
		String temp = "";
		boolean flag = true;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + "");
			temp += arr[i];
		}
		// LinkedList에 중복 된 값을 넣지 않기 위해 조건 추가
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) == Integer.parseInt(temp)) {
				flag = false;
				break;
			}
		}
		if (flag) list.add(Integer.parseInt(temp));
		System.out.println();
	}
	// 소수 찾기
	public static int searchDecimal(int numbers) {
		int primeNumber = 0;
		boolean flag = true;
		int temp = numbers;
		if (temp == 0 || temp == 1) return 0;
		if (temp != 2 && temp % 2 == 0) return 0;
		for (int j = 2; j <= Math.sqrt(temp); j++) {
			if (temp != j && temp % j == 0) {
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("소수 : " + temp);
			primeNumber++;
		}
		return primeNumber;
	}
	public static int searchDecimal(String numbers) {
		if (numbers.equals("")) return 0;
		int primeNumber = 0;
		boolean flag = true;
		int temp = Integer.parseInt(numbers);
		if (temp == 1) return 0;
		if (temp != 2 && temp % 2 == 0) return 0;
		for (int j = 2; j <= Math.sqrt(temp); j++) {
			if (temp != j && temp % j == 0) {
				flag = false;
				break;
			}
		}
		if (flag) {
			System.out.println("소수 : " + temp);
			primeNumber++;
		}
		return primeNumber;
	}

}