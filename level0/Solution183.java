package com.example.algorithm.level0;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 부분 문자열 이어 붙여 문자열 만들기
public class Solution183 {
    public static void main(String[] args) {
        String[] my_strings = {"progressive", "hamburger", "hammer", "ahocorasick"};
        int[][] parts = {{0, 4}, {1, 2}, {3, 5}, {7, 7}};
        // "programmers"

        if (my_strings.length < 1 || my_strings.length > 100) return;
        for (String str : my_strings) {
            if (str.length() < 1 || str.length() > 100) return;
        }

        System.out.println(solution(my_strings, parts));
    }

    public static String solution(String[] my_strings, int[][] parts) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_strings.length; i++) {
            sb.append(my_strings[i], parts[i][0], parts[i][1] + 1);
        }
        return sb.toString();
    }

    public static String solution2(String[] my_strings, int[][] parts) {
        return IntStream.range(0, my_strings.length).mapToObj(i -> my_strings[i].substring(parts[i][0], parts[i][1] + 1)).collect(Collectors.joining());
    }
}