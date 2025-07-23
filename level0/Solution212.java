package com.example.algorithm.level0;

// 문자열 곱하기
public class Solution212 {
    public static void main(String[] args) {
        String my_string = "string";
        int k = 3;
        // "stringstringstring"
        //String my_string = "love";
        //int k = 10;
        // "lovelovelovelovelovelovelovelovelovelove"

        if (my_string.length() < 1 || my_string.length() > 100) return;
        if (k < 1 || k > 100) return;

        System.out.println(solution(my_string, k));
    }

    public static String solution(String my_string, int k) {
        return my_string.repeat(k);
    }
}