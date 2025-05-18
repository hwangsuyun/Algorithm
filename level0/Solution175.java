package com.example.algorithm.level0;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

// qr code
public class Solution175 {
    public static void main(String[] args) {
        int q = 3;
        int r = 1;
        String code = "qjnwezgrpirldywt";
        // "jerry"
        //int q = 1;
        //int r = 0;
        //String code = "programmers";
        // "programmers"

        if (r < 0 || r > q) return;
        if (q < r || q > 20) return;
        if (code.length() < r || code.length() > 1000) return;

        System.out.println(solution2(q, r, code));
    }

    public static String solution(int q, int r, String code) {
        return IntStream.range(0, code.length()).filter(i -> i % q == r).mapToObj(i -> code.charAt(i) + "").collect(Collectors.joining());
    }

    public static String solution2(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < code.length(); i++) {
            if (i % q == r) {
                sb.append(code.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String solution3(int q, int r, String code) {
        StringBuilder sb = new StringBuilder();
        for (int i = r; i < code.length(); i += q) {
            sb.append(code.charAt(i));
        }
        return sb.toString();
    }
}