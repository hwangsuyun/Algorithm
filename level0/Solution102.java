package com.example.algorithm.level0;

import java.util.*;
import java.util.stream.Collectors;

// 배열의 원소만큼 추가하기
public class Solution102 {
    public static void main(String[] args) {
        int[] arr = {5, 1, 4}; // [5, 5, 5, 5, 5, 1, 4, 4, 4, 4]
        //int[] arr = {6, 6}; // [6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6]
        //int[] arr = {1}; //[1]

        if (arr.length < 1 || arr.length > 100) return;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 1 || arr[i] > 100) return;
        }

        int[] result = solution(arr);
        for (int r : result) System.out.println(r);

        List<Integer> result2 = solution2(arr);
        for (int r : result2) System.out.println(r);
    }

    public static int[] solution(int[] arr) {
        int[] answer = new int[Arrays.stream(arr).sum()];
        int index = 0;

        for (int i : arr) {
            for (int j = 0; j < i; j++) {
                answer[index] = i;
                index++;
            }
        }

        return answer;
    }

    public static List<Integer> solution2(int[] arr) {
        return Arrays.stream(arr)
                .boxed().flatMap(num -> Collections.nCopies(num, num).stream())
                .collect(Collectors.toList());
    }
}