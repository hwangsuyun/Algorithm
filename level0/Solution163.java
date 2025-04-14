package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

// 순서 바꾸기
public class Solution163 {
    public static void main(String[] args) {
        int[] num_list = {2, 1, 6};
        int n = 1;
        // [1, 6, 2]
        //int[] num_list = {5, 2, 1, 7, 5};
        //int n = 3;
        // [7, 5, 5, 2, 1]

        if (num_list.length < 2 || num_list.length > 30) return;
        for (int num : num_list) {
            if (num < 1 || num > 9) return;
        }
        if (n < 1 || n > num_list.length) return;

        int[] result = solution(num_list, n);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] num_list, int n) {
        int[] a = IntStream.range(0, num_list.length).filter(i -> i >= n).map(i -> num_list[i]).toArray();
        int[] b = IntStream.range(0, num_list.length).filter(i -> i < n).map(i -> num_list[i]).toArray();
        return IntStream.concat(Arrays.stream(a), Arrays.stream(b)).toArray();
    }

    public static int[] solution2(int[] num_list, int n) {
        return IntStream.range(0, num_list.length).map(i -> num_list[(i + n) % num_list.length]).toArray();
    }
}