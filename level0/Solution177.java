package com.example.algorithm.level0;

// 문자열 뒤집기
public class Solution177 {
    public static void main(String[] args) {
        String my_string = "Progra21Sremm3";
        int s = 6;
        int e = 12;
        // "ProgrammerS123"
        //String my_string = "Stanley1yelnatS";
        //int s = 4;
        //int e = 10;
        // "Stanley1yelnatS"

        if (my_string.length() < 1 || my_string.length() > 1000) return;
        if (s < 0 || s > e) return;
        if (e < s || e > my_string.length()) return;

        System.out.println(solution(my_string, s, e));
    }

    public static String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        return my_string.substring(0, s) + sb.append(my_string, s, e + 1).reverse() + my_string.substring(e + 1);
    }
}