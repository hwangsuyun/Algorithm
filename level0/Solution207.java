package com.example.algorithm.level0;

import java.util.stream.IntStream;

// 홀짝에 따라 다른 값 반환하기
public class Solution207 {
    public static void main(String[] args) {
        int n = 7; // 16
        //int n = 10; // 220

        if (n < 1 || n > 100) return;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        return n % 2 == 0
                ? IntStream.rangeClosed(1, n).filter(i -> i % 2 == 0).map(i -> i * i).sum()
                : IntStream.rangeClosed(1, n).filter(i -> i % 2 != 0).sum();
    }

    public static int solution2(int n) {
        int answer = 0;
        for (int i = n; i >= 0; i -= 2) {
            answer += (n % 2 == 0) ? i * i : i;
        }
        return answer;
    }

    public static int solution3(int n) {
        if (n % 2 == 1) {
            return (n + 1) * (n + 1) / 2 / 2;
        } else {
            return 4 * n/2 * (n/2 + 1) * (2 * n/2 + 1) / 6;
        }
    }
}