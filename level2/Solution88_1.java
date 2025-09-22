package com.example.algorithm.level2;

import java.util.*;

// 튜플
public class Solution88_1 {
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
        Set<String> set = new HashSet<>();
        String[] arr = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(arr, (a, b)->{return a.length() - b.length();});
        int[] answer = new int[arr.length];
        int idx = 0;
        for (String s1 : arr) {
            for (String s2 : s1.split(",")) {
                if(set.add(s2)) answer[idx++] = Integer.parseInt(s2);
            }
        }
        return answer;
    }
}