package com.example.algorithm.level2;

import java.math.BigDecimal;

// 2 x n 타일링
public class Solution96 {
    public static void main(String[] args) {
        //int n = 1; // 1
        //int n = 2; // 2
        //int n = 3; // 3
        //int n = 4; // 5
        //int n = 5; // 8
        //int n = 6; // 13
        //int n = 7; // 21
        //int n = 8; // 34
        //int n = 9; // 55
        //int n = 10; // 89
        //int n = 20; // 10946
        int n = 50000; // 441423758

        System.out.println(solution2(n));
    }

    public static int solution(int n) {
        long start = System.currentTimeMillis();
        System.out.println("start : " + start);
        int a = 1, b = 2;
        int answer = 0;
        for (int i = 3; i <= n; i++) {
            answer = (a + b) % 1000000007;
            a = b;
            b = answer;
        }
        long end = System.currentTimeMillis();
        System.out.println("end : " + end);
        System.out.println("result : " + (end - start));
        return answer;
    }

    public static int solution2(int n) {
        long start = System.currentTimeMillis();
        System.out.println("start : " + start);
        BigDecimal a = new BigDecimal(1);
        BigDecimal b = new BigDecimal(2);
        BigDecimal answer = new BigDecimal(0);
        for (int i = 3; i <= n; i++) {
            answer = a.add(b);
            a = b;
            b = answer;
        }
        long end = System.currentTimeMillis();
        System.out.println("end : " + end);
        System.out.println("result : " + (end - start));
        return answer.remainder(new BigDecimal(1000000007)).intValue();
    }
}