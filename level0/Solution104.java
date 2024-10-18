package com.example.algorithm.level0;

import java.util.stream.IntStream;

// 특별한 이차원 배열 2
public class Solution104 {
    public static void main(String[] args) {
        //int[][] arr = {{5, 192, 33}, {192, 72, 95}, {33, 95, 999}}; // 1
        int[][] arr = {{19, 498, 258, 587}, {63, 93, 7, 754},
                {258, 7, 1000, 723}, {587, 754, 723, 81}}; // 0

        if (arr.length < 1 || arr.length > 100) return;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length < 1 || arr[i].length > 100) return;
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] < 1 || arr[i][j] > 1000) return;
            }
        }

        System.out.println(solution2(arr));
    }

    public static int solution(int[][] arr) {
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == arr[j][i]) answer++;
            }
        }
        return answer == arr.length * arr[0].length ? 1 : 0;
    }

    public static int solution2(int[][] arr) {
        return IntStream.range(0, arr.length)
                .allMatch(i -> IntStream.range(0, arr[0].length)
                        .allMatch(j -> arr[i][j] == arr[j][i])) ? 1 : 0;
    }
}