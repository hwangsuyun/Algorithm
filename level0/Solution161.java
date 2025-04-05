package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

// n 번째 원소까지
public class Solution161 {
    public static void main(String[] args) {
        int[] num_list = {2, 1, 6};
        int n = 1;
        // [2]
        //int[] num_list = {5, 2, 1, 7, 5};
        //int n = 3;
	    // [5, 2, 1]

        if (num_list.length < 2 || num_list.length > 30) return;
        for (int num : num_list) {
            if (num < 1 || num > 9) return;
        }
        if (n < 1 || n > num_list.length) return;

        int[] result = solution(num_list, n);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] num_list, int n) {
        return IntStream.range(0, num_list.length).filter(i -> i < n).map(i -> num_list[i]).toArray();
    }

    public static int[] solution2(int[] num_list, int n) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            answer[i] = num_list[i];
        }
        return answer;
    }

    public static int[] solution3(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list,0,n);
    }
}