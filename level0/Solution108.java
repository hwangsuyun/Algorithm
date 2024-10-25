package com.example.algorithm.level0;

import java.util.Arrays;

// 조건에 맞게 수열 변환하기 3
public class Solution108 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 100, 99, 98};
        int k = 3;
        // [3, 6, 9, 300, 297, 294]
        //int[] arr = {1, 2, 3, 100, 99, 98};
        //int k = 2;
        // [3, 4, 5, 102, 101, 100]

        if (arr.length < 1 || arr.length > 1000000) return;
        for (int i : arr) {
            if (i < 1 || i > 100) return;
        }
        if (k < 1 || k > 100) return;

        int[] result = solution2(arr, k);
        for (int r : result) {
            System.out.println(r);
        }
    }

    public static int[] solution(int[] arr, int k) {
        int[] answer = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (k % 2 == 0) {
                answer[i] = arr[i] + k;
            } else {
                answer[i] = arr[i] * k;
            }
        }
        return answer;
    }

    public static int[] solution2(int[] arr, int k) {
        return Arrays.stream(arr).map(i -> k % 2 == 0 ? i + k : i * k).toArray();
    }
}