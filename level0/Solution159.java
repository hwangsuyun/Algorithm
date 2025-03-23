package com.example.algorithm.level0;

// 홀수 vs 짝수
public class Solution159 {
    public static void main(String[] args) {
        int[] num_list = {4, 2, 6, 1, 7, 6}; // 17
        //int[] num_list = {-1, 2, 5, 6, 3}; // 8

        if (num_list.length < 5 || num_list.length > 50) return;
        for (int num : num_list) {
            if (num < -9 || num > 9) return;
        }

        System.out.println(solution(num_list));
    }

    public static int solution(int[] num_list) {
        int a = 0, b = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (i % 2 == 0) b += num_list[i];
            else a += num_list[i];
        }
        return Math.max(a, b);
    }
}