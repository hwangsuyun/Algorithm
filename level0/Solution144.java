package com.example.algorithm.level0;

// 특정 문자열로 끝나는 가장 긴 부분 문자열 찾기
public class Solution144 {
    public static void main(String[] args) {
        String myString = "AbCdEFG";
        String pat = "dE";
        // "AbCdE"
        //String myString = "AAAAaaaa";
        //String pat = "a";
        // "AAAAaaaa"

        if (myString.length() < 5 || myString.length() > 20) return;
        if (pat.length() < 1 || pat.length() > 5) return;

        System.out.println(solution(myString, pat));
    }

    public static String solution(String myString, String pat) {
        return myString.substring(0, myString.lastIndexOf(pat) + pat.length());
    }
}