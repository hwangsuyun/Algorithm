package com.example.algorithm.level1;

// [PCCP 기출문제] 1번 / 붕대 감기
public class Solution81 {
    public static void main(String[] args) {
        //int[] bandage = {5, 1, 5};
        //int health = 30;
        //int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        // 5
        //int[] bandage = {3, 2, 7};
        //int health = 20;
        //int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};
        // -1
        //int[] bandage = {4, 2, 7};
        //int health = 20;
        //int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};
        // -1
        int[] bandage = {1, 1, 1};
        int health = 5;
        int[][] attacks = {{1, 2}, {3, 2}};
        // 3

        System.out.println(solution(bandage, health, attacks));
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int duration = 0;

        for (int i = 0, j = 0; i <= attacks[attacks.length - 1][0]; i++) {
            if (i < attacks[j][0]) {
                if (duration == bandage[0]) {
                    answer += bandage[2];
                    duration = 0;
                }
                answer += bandage[1];
            } else if (i == attacks[j][0]) {
                answer -= attacks[j][1];
                j++;
                duration = 0;
            }

            if (answer <= 0) {
                return -1;
            } else if (answer > health) {
                answer = health;
            }

            duration++;
        }

        return answer;
    }
}