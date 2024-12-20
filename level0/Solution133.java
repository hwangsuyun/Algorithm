package com.example.algorithm.level0;

import java.util.ArrayList;
import java.util.List;

// 빈 배열에 추가, 삭제하기
public class Solution133 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 4, 1, 3};
        boolean[] flag = {true, false, true, false, false};
        // [3, 3, 3, 3, 4, 4, 4, 4]

        if (arr.length < 1 || arr.length > 100) return;
        if (flag.length < 1 || flag.length > 100) return;
        for (int i : arr) {
            if (i < 1 || i > 9) return;
        }

        int[] result = solution(arr, flag);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr, boolean[] flag) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (flag[i]) {
                for (int j = 0; j < arr[i] * 2; j++) {
                    list.add(arr[i]);
                }
            } else {
                for (int j = 0; j < arr[i]; j++) {
                    list.remove(list.size() - 1);
                }
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}