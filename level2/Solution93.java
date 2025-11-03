package com.example.algorithm.level2;

import java.util.*;

// 모음사전
public class Solution93 {
    public static void main(String[] args) {
        //String word = "AAAAE"; // 6
        //String word = "AAAE"; // 10
        //String word = "I"; // 1563
        String word = "EIO"; // 1189

        System.out.println(solution(word));
    }

    public static int solution(String word) {
        String[] array = {"A", "A", "A", "A", "A", "E", "E", "E", "E", "E",
                "I", "I", "I", "I", "I", "O", "O", "O", "O", "O", "U", "U", "U", "U", "U"};
        Set<String> set = new HashSet<>();

        // 1. array 배열을 돌면서 길이가 1부터 5까지 permutation 구하기
        // 1.1 중복 제거를 위해 set 에 담기
        for (int i = 1; i <= 5; i++) {
            permutation(array, 0, i, array.length, set);
        }

        // 2. set 을 list 에 담고 오름차순 정렬하기
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);

        // 3. 반복문 돌면서 word 위치 찾기
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(word)) return i + 1;
        }

        return 0;
    }

    private static void permutation(String[] array, int depth, int length, int n, Set<String> set) {
        if (depth == length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                sb.append(array[i]);
            }
            set.add(sb.toString());
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(array, depth, i);
            permutation(array, depth + 1, length, n, set);
            swap(array, depth, i);
        }
    }

    private static void swap(String[] array, int depth, int i) {
        String temp = array[depth];
        array[depth] = array[i];
        array[i] = temp;
    }
}