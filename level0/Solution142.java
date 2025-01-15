package com.example.algorithm.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// ad 제거하기
public class Solution142 {
    public static void main(String[] args) {
        String[] strArr = {"and","notad","abcd"}; // ["and","abcd"]
        //String[] strArr = {"there","are","no","a","ds"}; // ["there","are","no","a","ds"]

        if (strArr.length < 1 || strArr.length > 1000) return;
        for (String str : strArr) {
            if (str.length() < 1 || str.length() > 20) return;
        }

        String[] result = solution(strArr);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String[] solution(String[] strArr) {
        return Arrays.stream(strArr).filter(str -> !str.contains("ad")).toArray(String[]::new);
    }

    public static String[] solution2(String[] strArr) {
        List<String> list = new ArrayList<>();
        for (String str : strArr) {
            if (!str.contains("ad")) {
                list.add(str);
            }
        }

        String[] result = new String[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}