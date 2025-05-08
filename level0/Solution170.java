package com.example.algorithm.level0;

import java.util.stream.IntStream;

// 리스트 자르기
public class Solution170 {
    public static void main(String[] args) {
        //int[] arr = {0, 0, 0, 1};
        //int idx = 1;
        // 3
        //int[] arr = {1, 0, 0, 1, 0, 0};
        //int idx = 4;
        // -1
        int[] arr = {1, 1, 1, 1, 0};
        int idx = 3;
        // 3

        if (arr.length < 3 || arr.length > 100000) return;
        for (int i : arr) {
            if (i != 0 && i != 1) return;
        }

        System.out.println(solution2(arr, idx));
    }

    public static int solution(int[] arr, int idx) {
        for (int i = 0; i < arr.length; i++) {
            if (i >= idx && arr[i] == 1) return i;
        }
        return -1;
    }

    public static int solution2(int[] arr, int idx) {
        return IntStream.range(idx, arr.length).filter(i -> arr[i] == 1).findFirst().orElse(-1);
    }
}