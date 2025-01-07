package com.example.algorithm.level0;

import java.util.Arrays;

// 문자열 잘라서 정렬하기
public class Solution138 {
    public static void main(String[] args) {
        //String myString = "axbxcxdx"; // ["a","b","c","d"]
        String myString = "axxbxcxdx"; // ["a","b","c","d"]
        //String myString = "dxccxbbbxaaaa"; // ["aaaa","bbb","cc","d"]

        if (myString.length() < 1 || myString.length() > 100000) return;

        String[] result = solution(myString);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String[] solution(String myString) {
        return Arrays.stream(myString.split("x")).filter(str -> str.length() != 0).sorted().toArray(String[]::new);
    }

    public static String[] solution2(String myString) {
        return Arrays.stream(myString.split("x")).filter(s -> !s.isEmpty()).sorted().toArray(String[]::new);
    }
}