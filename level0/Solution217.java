package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.Scanner;

// 문자열 돌리기
public class Solution217 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        Arrays.stream(a.split("")).forEach(System.out::println);
    }
}