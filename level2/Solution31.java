package programmers.level2;

// Çà·ÄÀÇ °ö¼À
public class Solution31 {
	public static void main(String[] args) {
		//int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
		//int[][] arr2 = {{3, 3}, {3, 3}};
		int[][] arr1 = {{2, 3, 2}, {4, 2, 4}, {3, 1, 4}};
		int[][] arr2 = {{5, 4, 3}, {2, 4, 1}, {3, 1, 1}};
		if (arr1.length < 2 || arr1.length > 100) return;
		if (arr2.length < 2 || arr2.length > 100) return;
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				if (arr1[i][j] < -10 || arr1[i][j] > 20) return;
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				if (arr2[i][j] < -10 || arr2[i][j] > 20) return;
			}
		}
		solution(arr1, arr2);
	}
	
	public static int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] result = new int[arr1.length][arr2[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				for (int k = 0; k < arr1[0].length; k++) {
					result[i][j] += arr1[i][k] * arr2[k][j];
				}
			}
		}
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + ", ");
			}
			System.out.println();
		}
		return result;
	}
}
