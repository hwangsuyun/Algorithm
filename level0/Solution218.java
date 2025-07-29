package com.example.algorithm.level0;

import java.util.Scanner;

// 문자열 붙여서 출력하기
public class Solution218 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        System.out.println((a + b).replace(" ", ""));
    }
}