package com.example.algorithm.level0;

// 부분 문자열
public class Solution115 {
    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "aabcc";
        // 1
        //String str1 = "tbt";
        //String str2 = "tbbttb";
        // 0
        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        return str2.contains(str1) ? 1 : 0;
    }
}