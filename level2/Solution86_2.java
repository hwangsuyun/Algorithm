package com.example.algorithm.level2;

import java.util.stream.LongStream;

// n^2 배열 자르기
public class Solution86_2 {
    public static void main(String[] args) {
        //int n = 3;
        //long left = 2;
        //long right = 5;
        // [3,2,2,3]
        int n = 4;
        long left = 7;
        long right = 14;
        // [4,3,3,3,4,4,4,4]

        int[] result = solution(n, left, right);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int n, long left, long right) {
        return LongStream.rangeClosed(left, right).mapToInt(value -> (int) Math.max(value / n, value % n) + 1).toArray();
    }
}