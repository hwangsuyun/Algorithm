package com.example.algorithm.level0;

// 특정한 문자를 대문자로 바꾸기
public class Solution145 {
    public static void main(String[] args) {
        //String my_string = "programmers";
        //String alp = "p";
        // "Programmers"
        String my_string = "lowercase";
        String alp = "x";
        // "lowercase"

        if (my_string.length() < 1 || my_string.length() > 1000) return;

        System.out.println(solution(my_string, alp));
    }

    public static String solution(String my_string, String alp) {
        return my_string.replace(alp, alp.toUpperCase());
    }
}