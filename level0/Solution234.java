package com.example.algorithm.level0;

import java.util.Scanner;

// [PCCE 기출문제] 2번 / 각도 합치기
public class Solution234 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int angle1 = sc.nextInt();
        int angle2 = sc.nextInt();

        if (angle1 < 0 || angle1 > 5000) return;
        if (angle2 < 0 || angle2 > 5000) return;

        int sum_angle = (angle1 + angle2) % 360;
        System.out.println(sum_angle);
    }
}