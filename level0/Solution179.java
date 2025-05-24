package com.example.algorithm.level0;

// 문자열의 앞의 n글자
public class Solution179 {
    public static void main(String[] args) {
        String my_string = "ProgrammerS123";
        int n = 11;
        // "ProgrammerS"
        //String my_string = "He110W0r1d";
        //int n = 5;
        // "He110"

        if (my_string.length() < 1 || my_string.length() > 1000) return;
        if (n < 1 || n > my_string.length()) return;

        System.out.println(solution(my_string, n));
    }

    public static String solution(String my_string, int n) {
        return my_string.substring(0, n);
    }
}