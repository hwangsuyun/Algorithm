package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.Scanner;

// 문자열 반복해서 출력하기
public class Solution222 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = sc.nextInt();

        if (str.length() < 1 || str.length() > 10) return;
        if (n < 1 || n > 5) return;

        System.out.println(str.repeat(n));
    }
}