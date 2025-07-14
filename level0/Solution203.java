package com.example.algorithm.level0;

import java.util.stream.IntStream;

// 등차수열의 특정한 항만 더하기
public class Solution203 {
    public static void main(String[] args) {
        int a = 3;
        int d = 4;
        boolean[] included = {true, false, false, true, true};
        // 37
        //int a = 7;
        //int d = 1;
        //boolean[] included = {false, false, false, true, false, false, false};
        // 10

        if (a < 1 || a > 100) return;
        if (d < 1 || d > 100) return;
        if (included.length < 1 || included.length > 100) return;

        System.out.println(solution(a, d, included));
    }

    public static int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for (boolean flag : included) {
            if (flag) {
                answer += a;
            }
            a += d;
        }
        return answer;
    }

    public static int solution2(int a, int d, boolean[] included) {
        return IntStream.range(0, included.length).map(i -> included[i] ? a + (i * d) : 0).sum();
    }
}