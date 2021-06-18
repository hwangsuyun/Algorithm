package programmers.level2;

// Ä«Ä«¿ÀÇÁ·»Áî ÄÃ·¯¸µºÏ
public class Solution42 {
	static int count = 0;
	public static void main(String[] args) {
		// 4, 5
		//int m = 6;
		//int n = 4;
		//int[][] picture = { {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3} };
		// 1, 3
		//int m = 2;
		//int n = 2;
		//int[][] picture = { {1, 1}, {0, 1} };
		// 1, 14
		//int m = 6;
		//int n = 4;
		//int[][] picture = { {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 1}, {1, 1, 1, 1} };
		// 0, 0
		//int m = 1;
		//int n = 1;
		//int[][] picture = { {0} };
		//4, 13
		int m = 4;
		int n = 4;
		int[][] picture = { {1, 1, 1, 1}, {1, 4, 1, 1}, {1, 3, 2, 1}, {1, 1, 1, 1 }};
		
		if (m < 1 || n > 100) return;
		
		solution(m, n, picture);
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
		count = 0;
		int[][] temp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				temp[i][j] = picture[i][j];
			}
		}
		
		int sum = 0;
		int max = 0;
		int start = 0;
		int[] result = new int[2];
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (temp[i][j] != 0) {
					count++;
					start = temp[i][j];
					temp[i][j] = 0;
					search(start, i, j, temp);
					
					sum = count > 0 ? sum += 1 : 0;
					max = count > max ? count : max;
					count = 0;
				}
				
			}
		}
		System.out.println("sum : " + sum);
		System.out.println("max : " + max);
		result[0] = sum;
		result[1] = max;
		return result;
    }
	
	private static void search(int start, int i, int j, int[][] temp) {
		if (j + 1 < temp[i].length && start == temp[i][j + 1]) {
			count++;
			temp[i][j + 1] = 0;
			search(start, i, j + 1, temp);
		}
		if (j - 1 >= 0 && start == temp[i][j - 1]) {
			count++;
			temp[i][j - 1] = 0;
			search(start, i, j - 1, temp);
		} 
		if (i + 1 < temp.length && start == temp[i + 1][j]) {
			count++;
			temp[i + 1][j] = 0;
			search(start, i + 1, j, temp);
		}
		if (i - 1 >= 0 && start == temp[i - 1][j]) {
			count++;
			temp[i - 1][j] = 0;
			search(start, i - 1, j, temp);
		}
	}
	
}
