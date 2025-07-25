package com.example.algorithm.level0;

// 문자열 섞기
public class Solution214 {
    public static void main(String[] args) {
        String str1 = "aaaaa";
        String str2 = "bbbbb";
        // "ababababab"

        if (str1.length() < 1 || str1.length() > 10) return;
        if (str2.length() < 1 || str2.length() > 10) return;

        System.out.println(solution(str1, str2));
    }

    public static String solution(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            sb.append(str1.charAt(i)).append(str2.charAt(i));
        }
        return sb.toString();
    }
}