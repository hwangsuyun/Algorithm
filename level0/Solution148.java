package com.example.algorithm.level0;

import java.util.stream.IntStream;

// 소문자로 바꾸기
public class Solution148 {
    public static void main(String[] args) {
        String myString = "aBcDeFg"; // "abcdefg"
        //String myString = "aaa"; // "aaa"

        if (myString.length() < 1 || myString.length() > 100000) return;

        System.out.println(solution(myString));
    }

    public static String solution(String myString) {
        return myString.toLowerCase();
    }
}