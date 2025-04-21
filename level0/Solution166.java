package com.example.algorithm.level0;

import java.util.*;
import java.util.stream.IntStream;

// 2의 영역
public class Solution166 {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 1, 4, 5, 2, 9};
        // [2, 1, 4, 5, 2]
        //int[] arr = {1, 2, 1};
        // [2]
        //int[] arr = {1, 1, 1};
        // [-1]
        int[] arr = {1, 2, 1, 2, 1, 10, 2, 1};
        // [2, 1, 2, 1, 10, 2]

        if (arr.length < 1 || arr.length > 100000) return;
        for (int i : arr) {
            if (i < 1 || i > 10) return;
        }

        int[] result = solution(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                list.add(i);
            }
        }
        if (list.isEmpty()) return new int[]{-1};
        if (list.size() == 1) return new int[]{2};
        return Arrays.copyOfRange(arr, list.get(0), list.get(list.size() - 1) + 1);
    }

    public static int[] solution2(int[] arr) {
        int[] idx = IntStream.range(0, arr.length).filter(i -> arr[i] == 2).toArray();
        if (idx.length == 0) return new int[]{-1};
        return IntStream.rangeClosed(idx[0], idx[idx.length - 1]).map(i -> arr[i]).toArray();
    }
}