package com.example.algorithm.level0;

// 대문자로 바꾸기
public class Solution149 {
    public static void main(String[] args) {
        String myString = "aBcDeFg"; // "ABCDEFG"
        //String myString = "AAA"; // "AAA"

        if (myString.length() < 1 || myString.length() > 100000) return;

        System.out.println(solution(myString));
    }

    public static String solution(String myString) {
        return myString.toUpperCase();
    }
}