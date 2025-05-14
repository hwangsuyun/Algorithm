package com.example.algorithm.level0;

import java.util.stream.IntStream;

// 배열 만들기 1
public class Solution173 {
    public static void main(String[] args) {
        int n = 10;
        int k = 3;
        // [3, 6, 9]
        //int n = 15;
        //int k = 5;
        // [5, 10, 15]

        if (n < 1 || n > 1000000) return;
        if (k < 1 || k > Math.min(1000, n)) return;

        int[] result = solution(n, k);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int n, int k) {
        return IntStream.rangeClosed(1, n).filter(i -> i % k == 0).toArray();
    }

    public static int[] solution2(int n, int k) {
        int count = n / k;
        int[] answer = new int[count];

        for (int i = 1; i <= count; i++) {
            answer[i - 1] = k * i;
        }

        return answer;
    }
}