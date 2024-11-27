package com.example.algorithm.level0;

import java.util.Arrays;

// 문자열 정수의 합
public class Solution122 {
    public static void main(String[] args) {
        //String num_str = "123456789"; // 45
        String num_str = "1000000"; // 1

        if (num_str.length() < 3 || num_str.length() > 100) return;

        System.out.println(solution(num_str));
    }

    public static int solution(String num_str) {
        return Arrays.stream(num_str.split("")).mapToInt(Integer::parseInt).sum();
    }

    public static int solution2(String num_str) {
        return num_str.chars().map(c -> c - 48).sum();
    }
}