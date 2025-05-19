package com.example.algorithm.level0;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 세로 읽기
public class Solution176 {
    public static void main(String[] args) {
        String my_string = "ihrhbakrfpndopljhygc";
        int m = 4;
        int c = 2;
        // "happy"
        //String my_string = "programmers";
        //int m = 1;
        //int c = 1;
        // "programmers"

        if (m < 1 || m > my_string.length()) return;
        if (my_string.length() < m || my_string.length() > 1000) return;
        if (c < 1 || c > m) return;

        System.out.println(solution(my_string, m, c));
    }

    public static String solution(String my_string, int m, int c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i += m) {
            sb.append(my_string.substring(i, i + m).charAt(c - 1));
        }
        return sb.toString();
    }

    public static String solution2(String my_string, int m, int c) {
        String answer = "";
        for (int i = c - 1; i < my_string.length(); i += m) {
            answer += my_string.charAt(i);
        }
        return answer;
    }

    public static String solution3(String my_string, int m, int c) {
        return IntStream.range(0, my_string.length())
                .filter(i -> i % m == c - 1)
                .mapToObj(i -> String.valueOf(my_string.charAt(i)))
                .collect(Collectors.joining());
    }
}