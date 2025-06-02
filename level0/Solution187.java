package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

// 글자 이어 붙여 문자열 만들기
public class Solution187 {
    public static void main(String[] args) {
        String my_string = "cvsgiorszzzmrpaqpe";
        int[] index_list = {16, 6, 5, 3, 12, 14, 11, 11, 17, 12, 7};
        // "programmers"
        //String my_string = "zpiaz";
        //int[] index_list = {1, 2, 0, 0, 3};
        // "pizza"

        if (my_string.length() < 1 || my_string.length() > 1000) return;
        if (index_list.length < 1 || index_list.length > 1000) return;
        for (int index : index_list) {
            if (index < 0 || index > my_string.length()) return;
        }

        System.out.println(solution2(my_string, index_list));
    }

    public static String solution(String my_string, int[] index_list) {
        return Arrays.stream(index_list)
                     .mapToObj(i -> my_string.charAt(i) + "")
                     .collect(Collectors.joining());
    }

    public static String solution2(String my_string, int[] index_list) {
        StringBuilder sb = new StringBuilder();
        for (int index : index_list) {
            sb.append(my_string, index, index + 1);
        }
        return sb.toString();
    }
}