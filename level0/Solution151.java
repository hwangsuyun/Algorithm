package com.example.algorithm.level0;

import java.util.Arrays;

// 길이에 따른 연산
public class Solution151 {
    public static void main(String[] args) {
        //int[] num_list = {3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1}; // 51
        int[] num_list = {2, 3, 4, 5}; // 120

        if (num_list.length < 2 || num_list.length > 20) return;
        for (int num : num_list) {
            if (num < 1 || num > 9) return;
        }

        System.out.println(solution(num_list));
    }

    public static int solution(int[] num_list) {
        return num_list.length >= 11 ? Arrays.stream(num_list).sum() : Arrays.stream(num_list).reduce((x, y) -> x * y).orElse(-1);
    }

    public static int solution2(int[] num_list) {
        int answer = 0;
        if (num_list.length >= 11) {
            for (int i : num_list) {
                answer += i;
            }
        } else {
            answer = 1;
            for (int i : num_list) {
                answer *= i;
            }
        }
        return answer;
    }
}