package com.example.algorithm.level0;

import java.util.Arrays;

// 정사각형으로 만들기
public class Solution103 {
    public static void main(String[] args) {
        //int[][] arr = {{572, 22, 37}, {287, 726, 384}, {85, 137, 292}, {487, 13, 876}};
        // [[572, 22, 37, 0], [287, 726, 384, 0], [85, 137, 292, 0], [487, 13, 876, 0]]
        //int[][] arr = {{57, 192, 534, 2}, {9, 345, 192, 999}};
        // [[57, 192, 534, 2], [9, 345, 192, 999], [0, 0, 0, 0], [0, 0, 0, 0]]
        int[][] arr = {{1, 2}, {3, 4}};
        // [[1, 2], [3, 4]]

        if (arr.length < 1 || arr.length > 100) return;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length < 1 || arr[i].length > 100) return;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < 1 || arr[i][j] > 1000) return;
            }
        }

        int[][] result = solution2(arr);
        for (int[] r : result) {
            for (int i : r) {
                System.out.println(i);
            }
        }
    }

    public static int[][] solution(int[][] arr) {
        int row = arr.length;
        int column = 0;
        int max;
        for (int[] a : arr) {
            if (a.length > column) column = a.length;
        }

        max = Math.max(row, column);
        int[][] answer = new int[max][max];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                answer[i][j] = arr[i][j];
            }
        }

        return answer;
    }

    public static int[][] solution2(int[][] arr) {
        int row = arr.length;
        int column = Arrays.stream(arr).mapToInt(subArray -> subArray.length).max().orElse(0);
        int max = Math.max(row, column);
        int[][] answer = new int[max][max];
        for (int i = 0; i < arr.length; i++) {
            System.arraycopy(arr[i], 0, answer[i], 0, arr[0].length);
        }
        return answer;
    }
}