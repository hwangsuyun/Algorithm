package com.example.algorithm.level1;

// [PCCP 기출문제] 1번 / 붕대 감기
public class Solution81_1 {
    public static void main(String[] args) {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        // 5
        //int[] bandage = {3, 2, 7};
        //int health = 20;
        //int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};
        // -1
        //int[] bandage = {4, 2, 7};
        //int health = 20;
        //int[][] attacks = {{1, 15}, {5, 16}, {8, 6}};
        // -1
        //int[] bandage = {1, 1, 1};
        //int health = 5;
        //int[][] attacks = {{1, 2}, {3, 2}};
        // 3

        System.out.println(solution(bandage, health, attacks));
    }

    public static int solution(int[] bandage, int health, int[][] attacks) {
        int cnt = bandage[0]; // 추가 체력 기준
        int now = health; // 현재 체력
        int std = 0; // 마지막으로 공격당한 시간

        int v1, v2; // 추가 체력 받을 수 있나?
        for (int[] atk: attacks) {
            if (now <= 0) {
                return -1;
            }

            v1 = atk[0] - std - 1; // 시간 차이
            v2 = v1 / cnt; // 추가 체력 회수

            // 맞기 직전까지의 체력 정산
            std = atk[0];
            now = Math.min(health, now + (v1 * bandage[1]));
            now = Math.min(health, now + (v2 * bandage[2]));

            now -= atk[1];
        }

        return now <= 0 ? -1 : now;
    }
}