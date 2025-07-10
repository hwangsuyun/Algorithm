package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

// 마지막 두 원소
public class Solution199 {
    public static void main(String[] args) {
        int[] num_list = {2, 1, 6}; // [2, 1, 6, 5]
        //int[] num_list = {5, 2, 1, 7, 5}; // [5, 2, 1, 7, 5, 10]

        if (num_list.length < 2 || num_list.length > 10) return;
        for (int i : num_list) {
            if (i < 1 || i > 9) return;
        }

        int[] result = solution(num_list);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] num_list) {
        int index = num_list.length;
        int[] answer = Arrays.copyOfRange(num_list, 0, index + 1);

        if (num_list[index - 1] > num_list[index - 2]) {
            answer[index] = num_list[index - 1] - num_list[index - 2];
        } else {
            answer[index] = num_list[index - 1] * 2;
        }
        return answer;
    }

    public static int[] solution2(int[] num_list) {
        return IntStream.iterate(0, i -> i + 1)
                .limit(num_list.length + 1)
                .map(i -> i == num_list.length ? (num_list[i - 1] > num_list[i - 2] ? num_list[i - 1] - num_list[i - 2] : 2 * num_list[i - 1]) : num_list[i])
                .toArray();
    }
}