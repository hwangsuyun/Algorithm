package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

//이어 붙인 수
public class Solution200 {
    public static void main(String[] args) {
        int[] num_list = {3, 4, 5, 2, 1}; // 393
        //int[] num_list = {5, 7, 8, 3}; // 581

        if (num_list.length < 2 || num_list.length > 10) return;
        for (int i : num_list) {
            if (i < 1 || i > 9) return;
        }

        System.out.println(solution(num_list));
    }

    public static int solution(int[] num_list) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        for (int i : num_list) {
            if (i % 2 == 0) {
                odd.append(i);
            } else {
                even.append(i);
            }
        }
        return Integer.parseInt(odd.toString()) + Integer.parseInt(even.toString());
    }

    public static int solution2(int[] num_list) {
        int answer = 0;

        int even = 0;
        int odd = 0;

        for(int num : num_list) {
            if(num % 2 == 0) {
                even *= 10;
                even += num;
            } else {
                odd *= 10;
                odd += num;
            }
        }
        answer = even + odd;

        return answer;
    }

    public static int solution3(int[] num_list) {
        return Integer.parseInt(Arrays.stream(num_list)
                                      .filter(value -> value % 2 != 0)
                                      .mapToObj(String::valueOf)
                                      .collect(Collectors.joining()))
                + Integer.parseInt(Arrays.stream(num_list)
                                         .filter(value -> value % 2 == 0)
                                         .mapToObj(String::valueOf)
                                         .collect(Collectors.joining()));
    }
}