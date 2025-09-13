package com.example.algorithm.level2;

// 멀리 뛰기
public class Solution84 {
    public static void main(String[] args) {
        int n = 4; // 5
        //int n = 3; // 3
        //int n = 2; // 2
        //int n = 1; // 1
        //int n = 30;

        System.out.println(solution(n));
    }

    public static long solution(int n) {
        /*
        (1칸, 1칸, 1칸, 1칸)
        (1칸, 1칸, 2칸)
        (1칸, 2칸, 1칸)
        (2칸, 1칸, 1칸)
        (2칸, 2칸)
         */
        int[] dp = new int[n + 1];
        return fibonacci(n, dp);
    }

    public static int fibonacci(int n, int[] dp) {
        int num = 1234567;
        if (n <= 1) dp[n] = 1;
        else {
            if (dp[n] == 0) dp[n] = (fibonacci(n - 1, dp) + fibonacci(n - 2, dp));
        }
        return dp[n] % num;
    }
}