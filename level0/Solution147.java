package com.example.algorithm.level0;

import java.util.stream.IntStream;

// 배열에서 문자열 대소문자 변환하기
public class Solution147 {
    public static void main(String[] args) {
        String[] strArr = {"AAA","BBB","CCC","DDD"}; // ["aaa","BBB","ccc","DDD"]
        //String[] strArr = {"aBc","AbC"}; // ["abc","ABC"]

        if (strArr.length < 1 || strArr.length > 20) return;
        for (String str : strArr) {
            if (str.length() < 1 || str.length() > 20) return;
        }

        String[] result = solution(strArr);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String[] solution(String[] strArr) {
        return IntStream.range(0, strArr.length)
                .mapToObj(i -> i % 2 != 0 ? strArr[i].toUpperCase() : strArr[i].toLowerCase())
                .toArray(String[]::new);
    }

    public static String[] solution2(String[] strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (i % 2 != 0) strArr[i] = strArr[i].toUpperCase();
            else strArr[i] = strArr[i].toLowerCase();
        }
        return strArr;
    }
}