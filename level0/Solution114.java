package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

// 꼬리 문자열
public class Solution114 {
    public static void main(String[] args) {
        String[] str_list = {"abc", "def", "ghi"};
        String ex = "ef";
        // "abcghi"
        //String[] str_list = {"abc", "bbc", "cbc"};
        //String ex = "c";
        // ""

        if (str_list.length < 2 || str_list.length > 10) return;
        for (String s : str_list) {
            if (s.length() < 1 || s.length() > 10) return;
        }
        if (ex.length() < 1 || ex.length() > 5) return;

        System.out.println(solution(str_list, ex));
    }

    public static String solution(String[] str_list, String ex) {
        return Arrays.stream(str_list).map(s -> s.contains(ex) ? "" : s).collect(Collectors.joining());
    }

    public static String solution2(String[] str_list, String ex) {
        return Arrays.stream(str_list).filter(s -> !s.contains(ex)).collect(Collectors.joining());
    }
}