package com.example.algorithm.level0;

// 수열과 구간 쿼리 4
public class Solution194 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 1}, {0, 3, 2}, {0, 3, 3}};
        // [3, 2, 4, 6, 4]

        if (arr.length < 1 || arr.length > 1000) return;
        for (int i : arr) {
            if (i < 0 || i > 1000000) return;
        }
        if (queries.length < 1 || queries.length > 1000) return;

        int[] result = solution(arr, queries);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr, int[][] queries) {
        for (int i = 0; i < arr.length; i++) {
            for (int[] query : queries) {
                if (i >= query[0] && i <= query[1] && i % query[2] == 0) {
                    arr[i]++;
                }
            }
        }
        return arr;
    }
}