package com.example.algorithm.level0;

import java.util.stream.IntStream;

// 특별한 이차원 배열 1
public class Solution106 {
    public static void main(String[] args) {
        int n = 3; // [[1, 0, 0], [0, 1, 0], [0, 0, 1]]
        //int n = 6;
        // [[1, 0, 0, 0, 0, 0], [0, 1, 0, 0, 0, 0], [0, 0, 1, 0, 0, 0], [0, 0, 0, 1, 0, 0], [0, 0, 0, 0, 1, 0], [0, 0, 0, 0, 0, 1]]
        //int n = 1; // [[1]]

        if (n < 1 || n > 1000) return;

        int[][] result = solution3(n);
        for (int [] arr : result) {
            for (int i : arr) {
                System.out.println(i);
            }
        }
    }

    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[i].length; j++) {
                if (i == j) answer[i][j] = 1;
            }
        }
        return answer;
    }

    public static int[][] solution2(int n) {
        int[][] answer = new int[n][n];
        for (int i = 0; i < n; i++) {
            answer[i][i] = 1;
        }
        return answer;
    }

    public static int[][] solution3(int n) {
        return IntStream.range(0, n)
                .mapToObj(i -> IntStream.range(0, n)
                        .map(j -> i == j ? 1 : 0)
                        .toArray())
                .toArray(int[][]::new);
    }
}