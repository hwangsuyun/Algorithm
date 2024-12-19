package com.example.algorithm.level0;

import java.util.ArrayList;
import java.util.List;

// 배열 만들기 6
public class Solution132 {
    public static void main(String[] args) {
        //int[] arr = {0, 1, 1, 1, 0}; // [0, 1, 0]
        //int[] arr = {0, 1, 0, 1, 0}; // [0, 1, 0, 1, 0]
        int[] arr = {0, 1, 1, 0}; // [-1]

        if (arr.length < 1 || arr.length > 1000000) return;
        for (int i : arr) {
            if (i != 0 && i != 1) return;
        }

        int[] result = solution(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr) {
        List<Integer> stk = new ArrayList<>();

        for (int i : arr) {
            int size = stk.size();
            if (size == 0) {
                stk.add(i);
            } else if (stk.get(size - 1) == i) {
                stk.remove(size - 1);
            } else if (stk.get(size - 1) != i) {
                stk.add(i);
            }
        }

        if (stk.size() == 0) stk.add(-1);
        return stk.stream().mapToInt(i -> i).toArray();
    }
}