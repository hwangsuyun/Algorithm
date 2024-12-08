package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

// 배열 비교하기
public class Solution129 {
    public static void main(String[] args) {
        int[] arr1 = {49, 13};
        int[] arr2 = {70, 11, 2};
        // -1
        //int[] arr1 = {100, 17, 84, 1};
        //int[] arr2 = {55, 12, 65, 36};
        // 1
        //int[] arr1 = {1, 2, 3, 4, 5};
        //int[] arr2 = {3, 3, 3, 3, 3};
        // 0

        if (arr1.length < 1 || arr1.length > 100) return;
        if (arr2.length < 1 || arr2.length > 100) return;
        for (int i : arr1) {
            if (1 < 1 || i > 100) return;
        }
        for (int i : arr2) {
            if (1 < 1 || i > 100) return;
        }

        System.out.println(solution(arr1, arr2));
    }

    public static int solution(int[] arr1, int[] arr2) {
        if (arr1.length > arr2.length) return 1;
        else if (arr1.length < arr2.length) return -1;
        else {
            int a1 = Arrays.stream(arr1).sum();
            int a2 = Arrays.stream(arr2).sum();
            if (a1 > a2) return 1;
            else if (a1 < a2) return -1;
            return 0;
        }
    }

    public static int solution2(int[] arr1, int[] arr2) {
        int answer = Integer.compare(arr1.length, arr2.length);

        if (answer == 0) {
            answer = Integer.compare(IntStream.of(arr1).sum(), IntStream.of(arr2).sum());
        }

        return answer;
    }
}