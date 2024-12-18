package com.example.algorithm.level0;

import java.util.*;
import java.util.stream.IntStream;

// 무작위로 K개의 수 뽑기
public class Solution131 {
    public static void main(String[] args) {
        //int[] arr = {0, 1, 1, 2, 2, 3};
        //int k = 3;
        // [0, 1, 2]
        int[] arr = {0, 1, 1, 1, 1};
        int k = 4;
        //[0, 1, -1, -1]

        if (arr.length < 1 || arr.length > 100000) return;
        for (int i : arr) {
            if (1 < 0 || i > 100000) return;
        }
        if (k < 1 || k > 1000) return;

        int[] result = solution2(arr, k);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i : Arrays.stream(arr).distinct().toArray()) {
            if (list.size() < k) {
                list.add(i);
            }
        }
        while (list.size() < k) {
            list.add(-1);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] solution2(int[] arr, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1) continue;
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[i] == arr[j]) {
                    arr[j] = -1;
                }
            }
        }

        for (int i : arr) {
            if (i != -1 && list.size() < k) list.add(i);
        }

        while (list.size() < k) {
            list.add(-1);
        }

        int[] answer = new int[list.size()];
        int index = 0;
        for (int i : list) {
            answer[index++] = i;
        }

        return answer;
    }

    public static int[] solution3(int[] arr, int k) {
        return IntStream.concat(Arrays.stream(arr).distinct(), IntStream.range(0, k).map(i -> - 1)).limit(k).toArray();
    }
}