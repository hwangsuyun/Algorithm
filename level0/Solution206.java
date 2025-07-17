package com.example.algorithm.level0;

import java.util.Map;
import java.util.function.BiFunction;

// 조건 문자열
public class Solution206 {
    public static void main(String[] args) {
        String ineq = "<";
        String eq = "=";
        int n = 20;
        int m = 50;
        // 1
        //String ineq = ">";
        //String eq = "!";
        //int n = 41;
        //int m = 78;
        // 0

        if (n < 1 || n > 100) return;
        if (m < 1 || m > 100) return;

        System.out.println(solution(ineq, eq, n, m));
    }

    public static int solution(String ineq, String eq, int n, int m) {
        return switch (ineq + eq) {
            case ">=" -> n >= m ? 1 : 0;
            case "<=" -> n <= m ? 1 : 0;
            case ">!" -> n > m ? 1 : 0;
            case "<!" -> n < m ? 1 : 0;
            default -> 0;
        };
    }

    public static int solution2(String ineq, String eq, int n, int m) {
        Map<String, BiFunction<Integer, Integer, Boolean>> functions = Map.of(
                ">=", (a, b) -> a >= b,
                "<=", (a, b) -> a <= b,
                ">!", (a, b) -> a > b,
                "<!", (a, b) -> a < b
        );

        return functions.get(ineq + eq).apply(n, m) ? 1 : 0;
    }
}