package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

// 뒤에서 5등까지
public class Solution126 {
    public static void main(String[] args) {
        int[] num_list = {12, 4, 15, 46, 38, 1, 14}; // [1, 4, 12, 14, 15]

        if (num_list.length < 6 || num_list.length > 30) return;
        for (int i : num_list) {
            if (i < 1 || i > 100) return;
        }

        int[] result = solution(num_list);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] num_list) {
        return Arrays.stream(num_list).sorted().limit(5).toArray();
    }

    public static int[] solution2(int[] num_list) {
        return IntStream.of(num_list).sorted().limit(5).toArray();
    }
}