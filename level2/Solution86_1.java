package com.example.algorithm.level2;

import java.util.*;

// n^2 배열 자르기
public class Solution86_1 {
    public static void main(String[] args) {
        //int n = 3;
        //long left = 2;
        //long right = 5;
        // [3,2,2,3]
        int n = 4;
        long left = 7;
        long right = 14;
        // [4,3,3,3,4,4,4,4]

        int[] result = solution(n, left, right);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int n, long left, long right) {
        List<Integer> ansList = new ArrayList<>();

        for(long i = left; i <= right; i++){
            if(i / n <= i % n)
                ansList.add((int)(i % n) + 1);
            else
                ansList.add((int)(i / n) + 1);
        }

        int[] answer = new int[ansList.size()];

        for(int i = 0; i < answer.length; i++)
            answer[i] = ansList.get(i);

        return answer;
    }
}