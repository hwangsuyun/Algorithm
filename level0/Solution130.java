package com.example.algorithm.level0;

import java.util.Arrays;

// 배열의 길이를 2의 거듭제곱으로 만들기
public class Solution130 {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4, 5, 6}; // [1, 2, 3, 4, 5, 6, 0, 0]
        int[] arr = {58, 172, 746, 89}; // [58, 172, 746, 89]

        if (arr.length < 1 || arr.length > 1000) return;
        for (int i : arr) {
            if (1 < 1 || i > 1000) return;
        }

        int[] result = solution(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr) {
        int length = 0;
        for (int i = 0; i < arr.length; i++) {
            int pow = (int) Math.pow(2, i);
            if (arr.length <= pow) {
                length = pow;
                break;
            }
        }

        int[] answer = new int[length];
        System.arraycopy(arr, 0, answer, 0, arr.length);

        return answer;
    }

    public static int[] solution2(int[] arr) {
        int length = 1;

        while (length < arr.length) {
            length *= 2;
        }

        return Arrays.copyOf(arr, length);
    }

    public static int[] solution3(int[] arr) {
        return Arrays.copyOf(arr, (int) Math.pow(2, Math.ceil(Math.log(arr.length) / Math.log(2))));
    }
}