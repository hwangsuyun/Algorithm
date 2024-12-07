package com.example.algorithm.level0;

import java.util.*;
import java.util.stream.Collectors;

// 문자열 묶기
public class Solution128 {
    public static void main(String[] args) {
        String[] strArr = {"a","bc","d","efg","hi"}; // 2

        if (strArr.length < 1 || strArr.length > 100000) return;
        for (String str : strArr) {
            if (str.length() < 1 || str.length() > 30) return;
        }

        System.out.println(solution3(strArr));
    }

    public static int solution(String[] strArr) {
        int answer = 0;
        int[] array = new int[strArr.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < strArr.length; i++) {
            array[i] = strArr[i].length();
        }

        Arrays.sort(array);

        for (int i : array) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int value : map.values()) {
            if (answer < value) {
                answer = value;
            }
        }

        return answer;
    }

    public static int solution2(String[] strArr) {
        return Arrays.stream(strArr)
                .collect(Collectors.groupingBy(String::length))
                .values().stream()
                .max(Comparator.comparingInt(List::size))
                .orElse(Collections.emptyList())
                .size();
    }

    public static int solution3(String[] strArr) {
        int answer = 0;
        int[] lengArr = new int[31];

        for (int i = 0; i < strArr.length; i++) {
            lengArr[strArr[i].length()]++;
        }

        for (int i = 0; i <= 30; i++) {
            answer = Math.max(answer, lengArr[i]);
        }

        return answer;
    }
}