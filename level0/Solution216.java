package com.example.algorithm.level0;

import java.util.Scanner;

// 홀짝 구분하기
public class Solution216 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n % 2 == 0 ? n + " is even" : n + " is odd");
    }

    /*
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n  + " is" + (n % 2 == 0 ? "even" : "odd"));
    }
     */
}