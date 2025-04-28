package com.example.algorithm.level0;

import java.util.stream.IntStream;

// 첫 번째로 나오는 음수
public class Solution168 {
    public static void main(String[] args) {
        int[] num_list = {12, 4, 15, 46, 38, -2, 15};
        // 5
        //int[] num_list = {13, 22, 53, 24, 15, 6};
        // -1

        if (num_list.length < 5 || num_list.length > 100) return;
        for (int num : num_list) {
            if (num < -10 || num > 100) return;
        }

        System.out.println(solution(num_list));
    }

    public static int solution(int[] num_list) {
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] < 0) return i;
        }
        return -1;
    }

    public static int solution2(int[] num_list) {
        return IntStream.range(0, num_list.length).filter(i -> num_list[i] < 0).min().orElse(-1);
    }

    public static int solution3(int[] num_list) {
        return IntStream.range(0, num_list.length).filter(i -> num_list[i] < 0).findFirst().orElse(-1);
    }
}