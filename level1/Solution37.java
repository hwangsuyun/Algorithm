package programmers.level1;

import java.util.ArrayList;
import java.util.List;

// 크레인 인형뽑기 게임
public class Solution37 {
	public static void main(String[] args) {
		int[][] board = { 
				
							{0, 0, 0, 0, 0}, 
							{0, 0, 1, 0, 3},
							{0, 2, 5, 0, 1}, 
							{4, 2, 4, 4, 2},
							{3, 5, 1, 3, 1},
				/*
				{0, 0, 1, 0, 0}, 
				{0, 0, 1, 0, 0},
				{0, 2, 1, 0, 0}, 
				{0, 2, 1, 0, 0},
				{0, 2, 1, 0, 0},
				*/
						};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		//int[] moves = {1, 2, 3, 3, 2, 3, 1};
		if (board.length < 5 || board.length > 30) return;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] < 0 || board[i][j] > 100) return;	
			}
		}
		if (moves.length < 1 || moves.length > 1000) return;
		System.out.println(solution(board, moves));
	}
	
	public static int solution(int[][] board, int[] moves) {
		List<Integer> list = new ArrayList<>();
		int k = 0;
		for (int i = 0; i < moves.length; i++) {
			k = moves[i] - 1;
			for (int j = 0; j < board.length; j++) {
				if (board[j][k] != 0) {
					//temp[i] = board[j][k];
					list.add(list.size(), board[j][k]);
					board[j][k] = 0;
					break;
				}
			}
		}
		
		int result = 0;
		k = 0;
		for (int i = 0; i < list.size() - 1; i++) {
			if (list.get(i) == list.get(i + 1)) {
				list.remove(i + 1);
				list.remove(i);
				result++;
				i = -1;
			}
		}
		
		return result * 2;
	}
}
