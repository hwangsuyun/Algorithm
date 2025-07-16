package com.example.algorithm.level0;

// flag에 따라 다른 값 반환하기
public class Solution205 {
    public static void main(String[] args) {
        int a = -4;
        int b = 7;
        boolean flag = true;
        // 3
        //int a = -4;
        //int b = 7;
        //boolean flag = false;
        // -11

        if (a < -1000 || a > 1000) return;
        if (b < -1000 || b > 1000) return;

        System.out.println(solution(a, b, flag));
    }

    public static int solution(int a, int b, boolean flag) {
        return flag ? a + b : a - b;
    }
}