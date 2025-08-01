package com.example.algorithm.level0;

import java.util.Scanner;

// 대소문자 바꿔서 출력하기
public class Solution221 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        StringBuilder sb = new StringBuilder();
        for (char ch : a.toCharArray()) {
            if (ch >= 'a' && ch <= 'z') {
                sb.append(("" + ch).toUpperCase());
            } else {
                sb.append(("" + ch).toLowerCase());
            }
        }
        System.out.println(sb);
    }
}