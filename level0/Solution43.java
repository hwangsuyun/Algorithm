package programmers.level0;

import java.util.HashSet;
import java.util.Set;

// 안전지대
public class Solution43 {
    public static void main(String[] args) {
        //int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}}; // 16
        //int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 0}, {0, 0, 0, 0, 0}}; // 13
        int[][] board = {{1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}, {1, 1, 1, 1, 1, 1}}; // 0
        //int[][] board = {{0, 0, 0, 0, 1}, {0, 1, 0, 1, 0}, {0, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 1, 0, 0, 0}}; // 2
        //int[][] board = {{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}; // 5
        //int[][] board = {{1, 0, 0}, {0, 0, 0}, {0, 0, 1}}; // 2
        //int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}}; // 25

        if (board.length < 1 || board.length > 100) return;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j ++) {
                if (board[i][j] != 0 && board[i][j] != 1) return;
            }
        }

        System.out.println(solution(board));
    }

    public static int solution(int[][] board) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    if (i > 0) {
                        if (j > 0) {
                            set.add((i - 1) + "" + (j - 1));
                            set.add((i - 1) + "" + j);
                            set.add(i + "" + (j - 1));
                        }
                        if (j < board[i].length - 1) {
                            set.add((i - 1) + "" + (j + 1));
                            set.add((i - 1) + "" + j);
                            set.add(i + "" + (j + 1));
                        }
                    }
                    if (i < board.length - 1) {
                        if (j > 0) {
                            set.add((i + 1) + "" + (j - 1));
                            set.add((i + 1) + "" + j);
                            set.add(i + "" + (j - 1));
                        }
                        if (j < board[i].length - 1) {
                            set.add((i + 1) + "" + (j + 1));
                            set.add((i + 1) + "" + j);
                            set.add(i + "" + (j + 1));
                        }
                    }
                    set.add(i + "" + j);
                }
            }
        }
        set.stream().sorted().forEach(System.out::println);
        return board.length * board[0].length - set.size();
    }
}