package com.example.algorithm.level0;

// n의 배수
public class Solution209 {
    public static void main(String[] args) {
        int num = 98;
        int n = 2;
        // 1
        //int num = 34;
        //int n = 3;
        // 0

        if (num < 2 || num > 100) return;
        if (n < 2 || n > 9) return;

        System.out.println(solution(num, n));
    }

    public static int solution(int num, int n) {
        return num % n == 0 ? 1 : 0;
    }
}