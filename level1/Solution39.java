package programmers.level1;

// [1차] 비밀지도
public class Solution39 {
	public static void main(String[] args) {
		//int n = 5;
		//int[] arr1 = {9, 20, 28, 18, 11};
		//int[] arr2 = {30, 1, 21, 17, 28};
		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		if (n < 1 || n > 16) return;
		solution(n, arr1, arr2);
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		String[] strArr1 = changeBinary(n, arr1);
		String[] strArr2 = changeBinary(n, arr2);
		String temp1 = "";
		String temp2 = "";
		for (int i = 0; i < strArr1.length; i++) {
			for (int j = 0; j < strArr1[i].length(); j++) {
				temp1 += Integer.parseInt(strArr1[i].charAt(j) + "") + Integer.parseInt(strArr2[i].charAt(j) + "");
				if (temp1.charAt(j) == '0') {
					temp2 += " ";
				} else if (temp1.charAt(j) >= '1') {
					temp2 += "#";
				}
			}
			System.out.println("\"" + temp2 + "\"");
			answer[i] = temp2;
			temp1 = "";
			temp2 = "";
		}
        return answer;
	}
	
	public static String[] changeBinary(int n, int[] arr) {
		String[] result = new String[n];
		String temp1 = "";
		String temp2 = "";
		int share = 0;
		int remainder = 0;
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i] == 0) {
					temp1 += "0";
					continue;
				}
				share = arr[i] / 2;
				remainder = arr[i] % 2;
				arr[i] = share;
				temp1 += remainder;
			}
			index = temp1.length() - 1;
			for (int k = 0; k < temp1.length(); k++) {
				temp2 += temp1.charAt(index);
				index--;
			}
			result[i] = temp2;
			temp1 = "";
			temp2 = "";
		}
		return result;
	}
}
