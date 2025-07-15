package com.example.algorithm.level0;

// 코드 처리하기
public class Solution204 {
    public static void main(String[] args) {
        String code = "abc1abc1abc"; // "acbac"

        if (code.length() < 1 || code.length() > 100000) return;

        System.out.println(solution(code));
    }

    public static String solution(String code) {
        StringBuilder sb = new StringBuilder();
        int mode = 0;

        for (int i = 0; i < code.length(); i++) {
            if (mode == 0) {
                if (code.charAt(i) != '1') {
                    if (i % 2 == 0) {
                        sb.append(code.charAt(i));
                    }
                } else {
                    mode = 1;
                }
            } else {
                if (code.charAt(i) != '1') {
                    if (i % 2 != 0) {
                        sb.append(code.charAt(i));
                    }
                } else {
                    mode = 0;
                }
            }
        }
        return sb.toString().length() == 0 ? "EMPTY" : sb.toString();
    }

    public static String solution2(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;
        for (int i = 0; i < code.length(); i++) {
            char current = code.charAt(i);
            if (current == '1') {
                mode = mode == 0 ? 1 : 0;
                continue;
            }

            if (i % 2 == mode) {
                answer.append(current);
            }
        }
        return answer.length() == 0 ? "EMPTY" : answer.toString();
    }
}