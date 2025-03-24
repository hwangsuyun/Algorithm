package com.example.algorithm.level0;

import java.util.stream.IntStream;

// n개 간격의 원소들
public class Solution160 {
    public static void main(String[] args) {
        int[] num_list = {4, 2, 6, 1, 7, 6};
        int n = 2;
        // [4, 6, 7]
        //int[] num_list = {4, 2, 6, 1, 7, 6};
        //int n = 4;
	    // [4, 7]

        if (num_list.length < 5 || num_list.length > 20) return;
        for (int num : num_list) {
            if (num < 1 || num > 9) return;
        }
        if (n < 1 || n > 4) return;

        int[] result = solution2(num_list, n);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] num_list, int n) {
        return IntStream.range(0, num_list.length).filter(i -> i % n == 0).map(i -> num_list[i]).toArray();
    }

    public static int[] solution2(int[] num_list, int n) {
        int[] answer = new int[num_list.length % n == 0 ? num_list.length / n : num_list.length / n + 1];
        int index = 0;
        for (int i = 0; i < num_list.length; i++) {
            if (i % n == 0) {
                answer[index++] = num_list[i];
            }
        }
        return answer;
    }
}