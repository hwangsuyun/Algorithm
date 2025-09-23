package com.example.algorithm.level2;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// 튜플
public class Solution88_2 {
    public static void main(String[] args) {
        //String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}"; // [2, 1, 3, 4]
        //String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}"; // [2, 1, 3, 4]
        //String s = "{{20,111},{111}}"; // [111, 20]
        //String s = "{{123}}"; // [123]
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}"; // [3, 2, 4, 1]

        int[] result = solution(s);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            String n = matcher.group();
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int size = map.size();
        int[] answer = new int[size];
        for (String key: map.keySet()) {
            answer[size - map.get(key)] = Integer.parseInt(key);
        }
        return answer;
    }
}