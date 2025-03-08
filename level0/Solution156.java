package com.example.algorithm.level0;

import java.util.Arrays;

// n보다 커질 때까지 더하기
public class Solution156 {
    public static void main(String[] args) {
        int[] numbers = {34, 5, 71, 29, 100, 34};
        int n = 123;
        // 139
        //int[] numbers = {58, 44, 27, 10, 100};
        //int n = 139;
        // 239

        if (numbers.length < 1 || numbers.length > 100) return;

        System.out.println(solution(numbers, n));
    }

    public static int solution(int[] numbers, int n) {
        int answer = 0, i = 0;
        while (answer <= n) {
            answer += numbers[i++];
        }
        return answer;
    }

    public static int solution2(int[] numbers, int n) {
        return Arrays.stream(numbers).reduce(0, (acc, i) -> n >= acc ? acc + i : acc);
    }
}