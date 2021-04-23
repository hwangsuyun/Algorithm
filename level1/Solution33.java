package programmers.level1;

// Çà·ÄÀÇ µ¡¼À
public class Solution33 {
	public static void main(String[] args) {
		//int[][] arr1 = {{1, 2}, {2, 3}};
		//int[][] arr2 = {{3, 4}, {5, 6}};
		int[][] arr1 = {{1}, {2}};
		int[][] arr2 = {{3}, {4}};
		for (int i = 0; i < arr1.length; i++) {
			if (arr1.length > 500) return;
			if (arr1[i].length > 500) return;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr2.length > 500) return;
			if (arr2[i].length > 500) return;
		}
		solution(arr1, arr2);
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				arr2[i][j] += arr1[i][j];
				System.out.print(arr2[i][j] + " ");
			}
		}
		return arr2;
	}
}
