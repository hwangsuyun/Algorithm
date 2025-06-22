package com.example.algorithm.level0;

import java.util.stream.IntStream;

// 수열과 구간 쿼리 2
public class Solution195 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 4, 3};
        int[][] queries = {{0, 4, 2}, {0, 3, 2}, {0, 2, 2}};
        // [3, 4, -1]

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
        int[] answer = new int[queries.length];
        int index = 0;

        for (int[] query : queries) {
            int min = Integer.MAX_VALUE;
            boolean flag = false;

            for (int i = query[0]; i <= query[1]; i++) {
                if (arr[i] > query[2] && min > arr[i]) {
                    min = arr[i];
                    flag = true;
                }
            }

            if (flag) answer[index++] = min;
            else answer[index++] = -1;
        }

        return answer;
    }

    public static int[] solution2(int[] arr, int[][] queries) {
        int[] answer = {};
        return IntStream.range(0, queries.length)
                .map(q -> IntStream.rangeClosed(queries[q][0], queries[q][1])
                        .map(i -> arr[i])
                        .filter(i -> i > queries[q][2])
                        .min().orElse(-1)
                ).toArray();
    }
}