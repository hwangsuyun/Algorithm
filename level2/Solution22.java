package programmers.level2;

// 가장 큰 정사각형 찾기
public class Solution22 {
	public static void main(String[] args) {
		//int[][] board = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
		//int[][] board = {{0, 0, 1, 1}, {1, 1, 1, 1}};
		//int[][] board = {{0, 1, 1, 1, 0, 0}, {0, 0, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {0, 0, 0, 1, 1, 0}};
		//int[][] board = {{0, 1, 1, 1, 0, 0}, {1, 0, 0, 0, 0, 0}};
		int[][] board = {{0, 1, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 0}};
		if (board.length < 1 || board.length > 1000) return;
		for (int i = 0; i < board.length; i++) {
			if (board[i].length < 1 || board[i].length > 1000) return;
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] != 0 && board[i][j] != 1) return;
			}
		}
		solution(board);
	}
	
	public static int solution(int[][] board) {
		int max = 0;
		if (board.length < 2 || board[0].length < 2) {
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == 1) max = 1;
				}
			}
		} else {
			for (int i = 1; i < board.length; i++) {
				for (int j = 1; j < board[i].length; j++) {
					if (board[i][j] == 1) {
						board[i][j] = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;
						if (board[i][j] > max) {
							max = board[i][j];
						}
					}
				}
			}	
		}
		System.out.println(max);
		return max * max;
	}
}
