package com.example.algorithm.level0;

import java.util.Arrays;

// 1로 만들기
public class Solution152 {
    public static void main(String[] args) {
        int[] num_list = {12, 4, 15, 1, 14}; // 11

        if (num_list.length < 3 || num_list.length > 15) return;
        for (int num : num_list) {
            if (num < 1 || num > 30) return;
        }

        System.out.println(solution(num_list));
    }

    public static int solution(int[] num_list) {
        int answer = 0;
        for (int num : num_list) {
            while (num > 1) {
                if (num % 2 == 0) {
                    num /= 2;
                } else {
                    num = (num - 1) / 2;
                }
                answer++;
            }
        }
        return answer;
    }

    public static int solution2(int[] num_list) {
        return Arrays.stream(num_list).map(i -> Integer.toBinaryString(i).length() - 1).sum();
    }
}