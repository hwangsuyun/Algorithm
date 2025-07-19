package com.example.algorithm.level0;

// 공배수
public class Solution208 {
    public static void main(String[] args) {
        int number = 60;
        int n = 2;
        int m = 3;
        // 1
        //int number = 55;
        //int n = 10;
        //int m = 5;
        // 0

        System.out.println(solution(number, n, m));
    }

    public static int solution(int number, int n, int m) {
        return number % n == 0 && number % m == 0 ? 1 : 0;
    }
}