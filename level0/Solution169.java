package com.example.algorithm.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// 리스트 자르기
public class Solution169 {
    public static void main(String[] args) {
        //int n = 3;
        //int[] slicer = {1, 5, 2};
        //int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // [2, 3, 4, 5, 6]
        //int n = 4;
        //int[] slicer = {1, 5, 2};
        //int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // [2, 4, 6]
        int n = 4;
        int[] slicer = {2, 7, 3};
        int[] num_list = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        //  [2, 5]

        if (slicer.length != 3) return;
        if (num_list.length < 5 || num_list.length > 30) return;
        for (int num : num_list) {
            if (num < 0 || num > 100) return;
        }

        int[] result = solution(n, slicer, num_list);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int n, int[] slicer, int[] num_list) {
        return switch (n) {
            case 1 -> Arrays.copyOfRange(num_list, 0, slicer[1] + 1);
            case 2 -> Arrays.copyOfRange(num_list, slicer[0], num_list.length);
            case 3 -> Arrays.copyOfRange(num_list, slicer[0], slicer[1] + 1);
            default -> splitArray(slicer, num_list);
        };
    }

    private static int[] splitArray(int[] slicer, int[] num_list) {
        List<Integer> list = new ArrayList<>();
        int[] answer = IntStream.range(0, num_list.length)
                .filter(i -> i >= slicer[0])
                .filter(i -> i <= slicer[1])
                .map(i -> num_list[i])
                .toArray();
        for (int i = 0; i < answer.length; i++) {
            if (i % slicer[2] == 0) {
                list.add(answer[i]);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] solution2(int n, int[] slicer, int[] num_list) {
        int start = n == 1 ? 0 : slicer[0];
        int end = n == 2 ? num_list.length - 1 : slicer[1];
        int step = n == 4 ? slicer[2] : 1;
        int[] answer = new int[(end - start + step) / step];
        for (int i = start, j = 0; i <= end; i += step) {
            answer[j++] = num_list[i];
        }
        return answer;
    }

    public static int[] solution3(int n, int[] slicer, int[] num_list) {
        int[] answer = null;
        int a = slicer[0], b = slicer[1], c = slicer[2];

        switch (n) {
            case 1:
                answer = Arrays.copyOf(num_list, b + 1);
                break;
            case 2:
                answer = Arrays.copyOfRange(num_list, a, num_list.length);
                break;
            case 3:
                answer = Arrays.copyOfRange(num_list, a, b + 1);
                break;
            case 4:
                answer = IntStream.range(0, (b - a) / c + 1).map(i -> num_list[a + i * c]).toArray();
                break;
        }

        return answer;
    }
}