package com.example.algorithm.level0;

import java.util.stream.IntStream;

// 배열의 길이에 따라 다른 연산하기
public class Solution127 {
    public static void main(String[] args) {
        int[] arr = {49, 12, 100, 276, 33};
        int n = 27;
        // [76, 12, 127, 276, 60]
        //int[] arr = {444, 555, 666, 777};
        //int n = 100;
        // [444, 655, 666, 877]

        if (arr.length < 1 || arr.length > 1000) return;
        for (int i : arr) {
            if (i < 1 || i > 1000) return;
        }
        if (n < 1 || n > 1000) return;

        int[] result = solution(arr, n);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr, int n) {
        return arr.length % 2 != 0
                ? IntStream.range(0, arr.length).map(i -> i % 2 == 0 ? arr[i] + n : arr[i]).toArray()
                : IntStream.range(0, arr.length).map(i -> i % 2 != 0 ? arr[i] + n : arr[i]).toArray();
    }

    public static int[] solution2(int[] arr, int n) {
        return IntStream.range(0, arr.length).map(i -> arr[i] + (i % 2 == (arr.length % 2 == 0 ? 1 : 0) ? n : 0)).toArray();
    }

    public static int[] solution3(int[] arr, int n) {
        for (int idx = arr.length % 2 == 0 ? 1 : 0; idx < arr.length; idx += 2) {
            arr[idx] += n;
        }
        return arr;
    }
}