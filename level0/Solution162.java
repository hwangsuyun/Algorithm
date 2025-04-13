package com.example.algorithm.level0;

import java.util.Arrays;

// 왼쪽 오른쪽
public class Solution162 {
    public static void main(String[] args) {
        //String[] str_list = {"u", "u", "l", "r"}; // ["u", "u"]
        //String[] str_list = {"l"}; // []
        //String[] str_list = {"r", "l"}; // ["l"]
        String[] str_list = {"a", "b"}; // [""]

        if (str_list.length < 1 || str_list.length > 20) return;

        String[] result = solution(str_list);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String[] solution(String[] str_list) {
        String str = String.join("", str_list);
        int left = str.contains("l") ? str.indexOf("l") : str_list.length;
        int right = str.contains("r") ? str.indexOf("r") : str_list.length;

        if (left < right) {
            return Arrays.copyOfRange(str_list, 0, left);
        } else if (left > right) {
            return Arrays.copyOfRange(str_list, right + 1, str_list.length);
        } else {
            return new String[]{};
        }
    }

    public static String[] solution2(String[] str_list) {
        for (int i = 0; i < str_list.length; i++) {
            if ("l".equals(str_list[i])) {
                return Arrays.copyOfRange(str_list, 0, i);
            } else if ("r".equals(str_list[i])) {
                return Arrays.copyOfRange(str_list, i + 1, str_list.length);
            }
        }
        return new String[0];
    }
}