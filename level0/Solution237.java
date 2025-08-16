package com.example.algorithm.level0;

// [PCCE 기출문제] 5번 / 심폐소생술
public class Solution237 {
    public static void main(String[] args) {
        String[] cpr = {"call", "respiration", "repeat", "check", "pressure"}; // [2, 4, 5, 1, 3]
        //String[] cpr = {"respiration", "repeat", "check", "pressure", "call"}; // [4, 5, 1, 3, 2]

        solution(new String[]{""});
    }

    public static int[] solution(String[] cpr) {
        int[] answer = {0, 0, 0, 0, 0};
        String[] basic_order = {"check", "call", "pressure", "respiration", "repeat"};

        for (int i = 0; i < cpr.length; i++) {
            for (int j = 0; j < basic_order.length; j++) {
                if(cpr[i].equals(basic_order[j])){
                    answer[i] = j + 1;
                    break;
                }
            }
        }
        return answer;
    }
}