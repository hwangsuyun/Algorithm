package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

// 카운트 다운
public class Solution171 {
    public static void main(String[] args) {
        int start_num = 10;
        int end_num = 3;
        // [10, 9, 8, 7, 6, 5, 4, 3]

        int[] result = solution(start_num, end_num);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int start_num, int end_num) {
        int[] answer = new int[start_num - end_num + 1];
        for (int i = start_num, j = 0; i >= end_num; i--) {
            answer[j++] = i;
        }
        return answer;
    }

    public static int[] solution2(int start_num, int end_num) {
        int[] answer = new int[start_num - end_num + 1];
        for (int i = 0; i <= start_num - end_num; i++) {
            answer[i] = start_num - i;
        }
        return answer;
    }

    public static int[] solution3(int start_num, int end_num) {
        return IntStream.rangeClosed(-start_num, -end_num).map(i -> -i).toArray();
    }
}