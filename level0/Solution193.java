package com.example.algorithm.level0;

import java.util.*;

// 배열 만들기 2
public class Solution193 {
    public static void main(String[] args) {
        int l = 5;
        int r = 555;
        // [5, 50, 55, 500, 505, 550, 555]
        //int l = 10;
        //int r = 20;
        // [-1]

        if (l < 1 || l > r) return;
        if (r < l || r > 1000000) return;

        int[] result = solution(l, r);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int l, int r) {
        int before, after;
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            before = ("" + i).length();
            after = ("" + i).replaceAll("[1-4]|[6-9]", "").length();
            if (before == after) {
                list.add(Integer.parseInt("" + i));
            }
        }
        return list.size() == 0 ? new int[]{-1} : list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] solution2(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < 64; i++) {
            int num = Integer.parseInt(Integer.toBinaryString(i)) * 5;
            if (l <= num && num <= r)
                list.add(num);
        }
        return list.isEmpty() ? new int[] { -1 } : list.stream().mapToInt(i -> i).toArray();
    }
}