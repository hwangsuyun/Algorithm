package com.example.algorithm.level2;

import java.util.*;

// 모음사전
public class Solution93_2 {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        //String word = "AAAAE"; // 6
        //String word = "AAAE"; // 10
        //String word = "I"; // 1563
        String word = "EIO"; // 1189

        System.out.println(solution(word));
    }

    public static int solution(String word) {
        dfs("", 0);
        return list.indexOf(word);
    }

    private static void dfs(String str, int len) {
        if(len > 5) return;
        list.add(str);
        for(int i = 0; i < 5; i++) dfs(str + "AEIOU".charAt(i), len + 1);
    }
}