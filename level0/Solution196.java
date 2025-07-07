package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// 수열과 구간 쿼리 3
public class Solution196 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4};
        int[][] queries = {{0, 3}, {1, 2}, {1, 4}};
        // [3, 4, 1, 0, 2]

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
            int temp = arr[query[0]];
            arr[query[0]] = arr[query[1]];
            arr[query[1]] = temp;
        }
        return arr;
    }

    public static int[] solution2(int[] arr, int[][] queries) {
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());

        for (int[] query : queries) {
            Collections.swap(list, query[0], query[1]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}