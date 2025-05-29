package com.example.algorithm.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 배열 만들기 5
public class Solution184 {
    public static void main(String[] args) {
        String[] intStrs = {"0123456789","9876543210","9999999999999"};
        int k = 50000;
        int s = 5;
        int l = 5;
        // [56789, 99999]

        if (s < 0 || s > 100) return;
        if (l < 1 || l > 8) return;
        if (intStrs.length < 1 || intStrs.length > 10000) return;
        for (String str : intStrs) {
            if (str.length() < s + l || str.length() > 120) return;
        }

        int[] result = solution(intStrs, k, s, l);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> list = new ArrayList<>();
        for (String str : intStrs) {
            int temp = Integer.parseInt(str.substring(s, s + l));
            if (temp > k) {
                list.add(temp);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static int[] solution2(String[] intStrs, int k, int s, int l) {
        return Arrays.stream(intStrs)
                     .mapToInt(str -> Integer.parseInt(str.substring(s, s + l)))
                     .filter(i -> i > k)
                     .toArray();
    }
}