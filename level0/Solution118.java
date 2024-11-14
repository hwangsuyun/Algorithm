package com.example.algorithm.level0;

// 문자열로 변환
public class Solution118 {
    public static void main(String[] args) {
        int n = 123; // "123"
        //int n = 2573; // "2573"

        if (n < 1 || n > 10000) return;

        System.out.println(solution(n));
    }

    public static String solution(int n) {
        return n + "";
    }
}