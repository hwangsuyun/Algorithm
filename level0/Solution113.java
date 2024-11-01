package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

// 정수 찾기
public class Solution113 {
    public static void main(String[] args) {
        int[] num_list = {1, 2, 3, 4, 5};
        int n = 3;
        // 1
        //int[] num_list = {15, 98, 23, 2, 15};
        //int n = 20;
        // 0

        if (num_list.length < 3 || num_list.length > 100) return;
        for (int i : num_list) {
            if (i < 1 || i > 100) return;
        }
        if (n < 1 || n > 100) return;

        System.out.println(solution2(num_list, n));
    }

    public static int solution(int[] num_list, int n) {
        return Arrays.stream(num_list).anyMatch(i -> i == n) ? 1 : 0;
    }

    public static int solution2(int[] num_list, int n) {
        return IntStream.of(num_list).anyMatch(i -> i == n) ? 1 : 0;
    }
}