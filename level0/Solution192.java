package com.example.algorithm.level0;

import java.util.stream.IntStream;

// 카운트 업
public class Solution192 {
    public static void main(String[] args) {
        int start_num = 3;
        int end_num = 10;
        // [3, 4, 5, 6, 7, 8, 9, 10]

        if (start_num < 0 || start_num > end_num) return;
        if (end_num < start_num || end_num > 50) return;

        int[] result = solution(start_num, end_num);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int start_num, int end_num) {
        return IntStream.rangeClosed(start_num, end_num).toArray();
    }
}