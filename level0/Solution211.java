package com.example.algorithm.level0;

// 더 크게 합치기
public class Solution211 {
    public static void main(String[] args) {
        int a = 2;
        int b = 91;
        // 364
        //int a = 91;
        //int b = 2;
        // 912

        if (a < 1 || a > 10000) return;
        if (b < 1 || b > 10000) return;

        System.out.println(solution(a, b));
    }

    public static int solution(int a, int b) {
        return Math.max(Integer.parseInt("" + a + b), Integer.parseInt("" + b + a));
    }
}