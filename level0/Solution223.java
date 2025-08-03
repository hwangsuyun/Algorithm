package com.example.algorithm.level0;

import java.util.Scanner;

// a와 b 출력하기
public class Solution223 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a < -100000 || a > 100000) return;
        if (b < -100000 || b > 100000) return;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}