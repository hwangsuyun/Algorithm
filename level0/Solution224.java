package com.example.algorithm.level0;

import java.util.Scanner;

// 문자열 출력하기
public class Solution224 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        if (a.length() < 1 || a.length() > 1000000) return;
        System.out.println(a);
    }
}