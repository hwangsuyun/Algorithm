package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

// 문자 리스트를 문자열로 변환하기
public class Solution213 {
    public static void main(String[] args) {
        String[] arr = {"a","b","c"}; // "abc"

        if (arr.length < 1 || arr.length > 200) return;

        System.out.println(solution(arr));
    }

    public static String solution(String[] arr) {
        return Arrays.stream(arr).collect(Collectors.joining());
    }

    public static String solution2(String[] arr) {
        return String.join("", arr);
    }
}