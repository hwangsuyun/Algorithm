package com.example.algorithm.level0;

import java.util.*;
import java.util.stream.IntStream;

// 콜라츠 수열 만들기
public class Solution191 {
    public static void main(String[] args) {
        int n = 10; // [10, 5, 16, 8, 4, 2, 1]

        if (n < 1 || n > 1000) return;

        int[] result = solution(n);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            list.add(n);
            if (n == 1) break;
            if (n % 2 == 0) n /= 2;
            else n = 3 * n + 1;
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] solution2(int n) {
        return IntStream.concat(
                        IntStream.iterate(n, i -> i > 1, i -> i % 2 == 0 ? i / 2 : i * 3 + 1),
                        IntStream.of(1))
                .toArray();
    }
}