package com.example.algorithm.level2;

import java.util.ArrayList;
import java.util.List;

// [3차] n진수 게임
public class Solution90 {
    public static void main(String[] args) {
        //int n = 2, t = 4, m = 2, p = 1; // "0111"
        int n = 16, t = 16, m = 2, p = 1; // "02468ACE11111111"
        //int n = 16, t = 16, m = 2, p = 2; // "13579BDF01234567"

        System.out.println(solution(n, t, m, p));
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int number = 1;

        // 1. 진수 변환하여 list 에 담기
        for (int i = 0; i < t * m; i++) {
            convert(list, Integer.toString(i, n));
        }

        // 2. 말해야 하는 차례가 오면 list 에서 값 빼서 더하기
        for (String str : list) {
            if (t == 0) break;
            if (number == p) {
                sb.append(str);
                t--;
            }

            number %= m;
            number += 1;
        }

        return sb.toString().toUpperCase();
    }

    private static void convert(List<String> list, String str) {
        if (str.length() > 1) {
            for (int j = 0; j < str.length(); j++) {
                list.add(str.charAt(j) + "");
            }
        } else {
            list.add(str);
        }
    }
}