package com.example.algorithm.level0;

// 주사위 게임 1
public class Solution112 {
    public static void main(String[] args) {
        int a = 3;
        int b = 5;
        // 34
        //int a = 6;
        //int b = 1;
        // 14
        //int a = 2;
        //int b = 4;
        // 2

        System.out.println(solution(a, b));
    }

    public static int solution(int a, int b) {
        if (a % 2 == 1 && b % 2 == 1) return (int) (Math.pow(a, 2) + Math.pow(b, 2));
        if (a % 2 == 1 || b % 2 == 1) return 2 * (a + b);
        return Math.abs(a - b);
    }

    public static int solution2(int a, int b) {
        return (a % 2 == 1 && b % 2 == 1
                ? a * a + b * b
                : (a % 2 == 1 || b % 2 == 1
                    ? 2 * (a + b)
                    : (a > b
                        ? a - b
                        : b - a)));
    }
}