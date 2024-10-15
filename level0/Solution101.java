package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 이차원 배열 대각선 순회하기
public class Solution101 {
    public static void main(String[] args) {
        int[][] board = {{0, 1, 2}, {1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
        int k = 2;
        // 8

        if (board.length < 1 || board.length > 100) return;
        for (int i = 0; i < board.length; i++) {
            if (board[i].length < 1 || board[i].length > 100) return;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] < 0 || board[i][j] > 10000) return;
            }
        }

        System.out.println(solution2(board, k));
    }

    public static int solution(int[][] board, int k) {
        int answer = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i + j <= k) answer += board[i][j];
                else break;
            }
        }
        return answer;
    }

    public static int solution2(int[][] board, int k) {
        return IntStream.range(0, board.length)
                .filter(i -> i <= k)
                .map(i -> IntStream.range(0, board[i].length)
                        .filter(j -> j <= k - i)
                        .map(j -> board[i][j])
                        .sum())
                .sum();
    }
}