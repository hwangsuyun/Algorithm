package com.example.algorithm.level0;

import java.util.*;
import java.util.stream.IntStream;

// 배열의 원소 삭제하기
public class Solution117 {
    public static void main(String[] args) {
        int[] arr = {293, 1000, 395, 678, 94};
        int[] delete_list = {94, 777, 104, 1000, 1, 12};
        // [293, 395, 678]
        //int[] arr = {110, 66, 439, 785, 1};
        //int[] delete_list = {377, 823, 119, 43};
        // [110, 66, 439, 785, 1]

        if (arr.length < 1 || arr.length > 100) return;
        for (int i : arr) {
            if (i < 1 || i > 1000) return;
        }
        if (delete_list.length < 1 || delete_list.length > 100) return;
        for (int i : delete_list) {
            if (i < 1 || i > 1000) return;
        }

        int[] result = solution2(arr, delete_list);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr, int[] delete_list) {
        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
            boolean flag = false;
            for (int d : delete_list) {
                if (a == d) {
                    flag = true;
                    break;
                }
            }
            if (!flag) list.add(a);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] solution2(int[] arr, int[] delete_list) {
        return Arrays.stream(arr).filter(i -> Arrays.stream(delete_list).allMatch(j -> i != j)).toArray();
    }

    public static int[] solution3(int[] arr, int[] delete_list) {
        return IntStream.of(arr).filter(i -> !IntStream.of(delete_list).anyMatch(j -> j == i)).toArray();
    }
}