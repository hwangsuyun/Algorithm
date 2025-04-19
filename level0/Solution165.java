package com.example.algorithm.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 배열 조각하기
public class Solution165 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 3, 4, 5};
        int[] query = {4, 1, 2};
        // [1, 2, 3]

        if (arr.length < 5 || arr.length > 100000) return;
        for (int i : arr) {
            if (i < 0 || i > 100) return;
        }
        if (query.length < 1 || query.length > Math.min(50, arr.length / 2)) return;

        int[] result = solution(arr, query);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr, int[] query) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }

        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                list = list.subList(0, query[i] + 1);
            } else {
                list = list.subList(query[i], list.size());
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static int[] solution2(int[] arr, int[] query) {
        int start = 0;
        int end = arr.length - 1;
        for (int i = 0; i < query.length; i++) {
            if (i % 2 == 0) {
                end = start + query[i] - 1;
            } else {
                start += query[i];
            }
        }

        return Arrays.copyOfRange(arr, start, end + 2);
    }
}