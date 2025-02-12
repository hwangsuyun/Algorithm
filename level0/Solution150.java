package com.example.algorithm.level0;

// 원하는 문자열 찾기
public class Solution150 {
    public static void main(String[] args) {
        //String myString = "AbCdEfG";
        //String pat = "aBc";
        // 1
        String myString = "aaAA";
        String pat = "aaaaa";
        // 0

        if (myString.length() < 1 || myString.length() > 100000) return;
        if (pat.length() < 1 || pat.length() > 300) return;

        System.out.println(solution(myString, pat));
    }

    public static int solution(String myString, String pat) {
        return myString.toUpperCase().contains(pat.toUpperCase()) ? 1 : 0;
    }

    public static int solution2(String myString, String pat) {
        String str = myString.toLowerCase();
        String str2 = pat.toLowerCase();

        if (str.indexOf(str2) != -1) {
            return 1;
        }
        return 0;
    }
}