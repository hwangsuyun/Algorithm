package programmers.level2;

// 단체사진 찍기
public class Solution41 {
	static int count = 0;
	public static void main(String[] args) {
		int n = 2;
		String[] data = {"N~F=0", "R~T>2"};
		
		if (n < 1 || n > 100) return;
		
		System.out.println(solution(n, data));
	}
	
	public static int solution(int n, String[] data) {
		count = 0;
		String[] array = {"A", "C", "F", "J", "M", "N", "R", "T"};
		perm(array, 0, array.length, 8, data, n);
		return count;
    }
	
	private static void perm(String[] arr, int depth, int len, int k, String[] data, int n) {
		if (depth == k) {
			check(arr, k, data, n);
			return;
		}
		
		for (int i = depth; i < len; i++) {
			swap(arr, i, depth);
			perm(arr, depth + 1, len, k, data, n);
			swap(arr, i, depth);
		}
	}
	
	private static void swap(String[] list, int i, int j) {
		String temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	private static void check(String[] arr, int k, String[] data, int n){
		String value = "";
		int start = 0, end = 0;
		boolean flag = false;
		for (int i = 0; i < k; i++) {
			value += arr[i];
			//System.out.print(arr[i] + "");
		}
		
		for (int i = 0; i < data.length; i++) {
			start = value.indexOf((data[i].charAt(0) + ""));
			end = value.indexOf((data[i].charAt(2) + ""));
			
			if (data[i].charAt(3) == '=') {
				if (Math.abs(end - start) - 1 == Character.getNumericValue(data[i].charAt(4))) flag = true;
				else {
					flag = false;
					break;
				}
			} else if (data[i].charAt(3) == '>') {
				if (Math.abs(end - start) - 1 > Character.getNumericValue(data[i].charAt(4))) flag = true;
				else {
					flag = false;
					break;
				}
			} else if (data[i].charAt(3) == '<') {
				if (Math.abs(end - start) - 1 < Character.getNumericValue(data[i].charAt(4))) flag = true;
				else {
					flag = false;
					break;
				}
			}
		}
		
		if (flag) count++;
	}
}
