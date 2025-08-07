package com.example.algorithm.level0;

// [PCCE 기출문제] 6번 / 가채점
public class Solution227 {
    public static void main(String[] args) {
        //int[] numbers = {1};
        //int[] our_score = {100};
        //int[] score_list = {100, 80, 90, 84, 20};
        // ["Same"]
        int[] numbers = {3, 4};
        int[] our_score = {85, 93};
        int[] score_list = {85, 92, 38, 93, 48, 85, 92, 56};
        // ["Different", "Same"]

        if (numbers.length < 1 || numbers.length > 10) return;
        if (our_score.length < 1 || our_score.length > 10) return;
        for (int i : numbers) {
            if (i < 1 || i > 31) return;
        }
        for (int i : our_score) {
            if (i < 0 || i > 100) return;
        }
        if (score_list.length < 2 || score_list.length > 31) return;
        for (int i : score_list) {
            if (i < 0 || i > 100) return;
        }

        for (String str : solution(numbers, our_score, score_list)) {
            System.out.println(str);
        }
    }

    public static String[] solution(int[] numbers, int[] our_score, int[] score_list) {
        int num_student = numbers.length;
        String[] answer = new String[num_student];

        for (int i = 0; i < num_student; i++) {
            if (our_score[i] == score_list[numbers[i] - 1]) {
                answer[i] = "Same";
            }
            else {
                answer[i] = "Different";
            }
        }

        return answer;
    }
}