package com.example.algorithm.level0;

// 문자열을 정수로 변환하기
public class Solution121 {
    public static void main(String[] args) {
        String n_str = "10"; // 10
        //String n_str = "8542"; //	8542

        if (n_str.length() < 1 || n_str.length() > 5) return;
        for (char ch : n_str.toCharArray()) {
            if (ch < '0' || ch > '9') return;
        }

        System.out.println(solution(n_str));
    }

    public static int solution(String n_str) {
        return Integer.parseInt(n_str);
    }
}