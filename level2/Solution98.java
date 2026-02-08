package com.example.algorithm.level2;

import java.util.ArrayList;
import java.util.List;

// [1차] 프렌즈4블록
public class Solution98 {
    public static void main(String[] args) {
        //int m = 4;
        //int n = 5;
        //String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
        // 14
        int m = 6;
        int n = 6;
        String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        // 15

        System.out.println(solution(m, n, board));
    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] chars = new char[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j ++) {
                chars[i][j] = board[i].charAt(j);
            }
        }

        searchFourBlock(chars);

        for (char[] aChar : chars) {
            for (char c : aChar) {
                if (c == ' ') answer++;
            }
        }

        return answer;
    }

    private static void searchFourBlock(char[][] chars) {
        while (true) {
            boolean flag = false;
            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < chars.length - 1; i++) {
                for (int j = 0; j < chars[i].length - 1; j++) {
                    if (chars[i][j] == ' ') continue;
                    if (chars[i][j] == chars[i][j + 1] && chars[i][j] == chars[i + 1][j] && chars[i][j] == chars[i + 1][j + 1]) {
                        list.add(new int[]{i, j});
                        list.add(new int[]{i, j + 1});
                        list.add(new int[]{i + 1, j});
                        list.add(new int[]{i + 1, j + 1});
                        flag = true;
                    }
                }
            }

            if (!flag) break;

            for (int[] array : list) {
                chars[array[0]][array[1]] = ' ';
            }

            for (int i = chars.length - 1; i > 0; i--) {
                for (int j = 0; j < chars[i].length; j++) {
                    if (chars[i][j] == ' ') {
                        for (int k = i - 1; k >= 0; k--) {
                            if (chars[k][j] != ' ') {
                                for (int l = k; l < i; l++) {
                                    chars[l + 1][j] = chars[l][j];
                                    chars[l][j] = ' ';
                                }
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

}