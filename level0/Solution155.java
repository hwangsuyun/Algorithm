package com.example.algorithm.level0;

// 수열과 구간 쿼리 1
public class Solution155 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 1}, {1, 2}, {2, 3}};
        // [1, 3, 4, 4, 4]

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
        for (int[] query : queries) {
            for (int i = 0; i < arr.length; i++) {
                if (i >= query[0] && i <= query[1]) {
                    arr[i]++;
                }
            }
        }
        return arr;
    }
}