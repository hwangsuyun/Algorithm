package com.example.algorithm.level0;

import java.util.Arrays;

// 조건에 맞게 수열 변환하기 1
public class Solution154 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 100, 99, 98}; // [2, 2, 6, 50, 99, 49]};

        if (arr.length < 1 || arr.length > 1000000) return;
        for (int i : arr) {
            if (i < 1 || i > 100) return;
        }

        int[] result = solution(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 50 && arr[i] % 2 == 0) {
                arr[i] /= 2;
            } else if (arr[i] < 50 && arr[i] % 2 != 0) {
                arr[i] *= 2;
            }
        }
        return arr;
    }

    public static int[] solution2(int[] arr) {
        return Arrays.stream(arr).map(i -> i >= 50 && i % 2 == 0 ? i / 2 : i < 50 && i % 2 != 0 ? i * 2 : i).toArray();
    }
}