package com.example.algorithm.level0;

// 정수 부분
public class Solution123 {
    public static void main(String[] args) {
        //double flo = 1.42; // 1
        double flo = 69.32; // 69

        if (flo < 0 || flo > 100) return;

        System.out.println(solution(flo));
    }

    public static int solution(double flo) {
        return (int) flo;
    }
}