package com.example.algorithm.level0;

import java.util.Arrays;

// 원소들의 곱과 합
public class Solution201 {
    public static void main(String[] args) {
        int[] num_list = {3, 4, 5, 2, 1}; // 1
        // int[] num_ist = {5, 7, 8, 3}; //	0

        if (num_list.length < 2 || num_list.length > 10) return;
        for (int i : num_list) {
            if (i < 1 || i > 9) return;
        }

        System.out.println(solution(num_list));
    }

    public static int solution(int[] num_list) {
        int multiplication = 1, sumSquare = 0;
        for (int num : num_list) {
            multiplication *= num;
            sumSquare += num;
        }
        return multiplication < Math.pow(sumSquare, 2) ? 1 : 0;
    }

    public static int solution2(int[] num_list) {
        return (Arrays.stream(num_list).reduce((acc, i) -> acc * i).getAsInt() < Math.pow(Arrays.stream(num_list).sum(), 2)) ? 1 : 0;
    }
}