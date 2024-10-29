package com.example.algorithm.level0;

import java.time.LocalDate;
import java.util.Arrays;

// 날짜 비교하기
public class Solution111 {
    public static void main(String[] args) {
        //int[] date1 = {2021, 12, 28};
        //int[] date2 = {2021, 12, 29};
        // 1
        int[] date1 = {1024, 10, 24};
        int[] date2 = {1024, 10, 24};
        // 0

        if (date1.length != 3) return;
        if (date2.length != 3) return;
        if (date1[0] < 0 || date1[0] > 10000) return;
        if (date2[0] < 0 || date2[0] > 10000) return;
        if (date1[1] < 1 || date1[1] > 12) return;
        if (date2[1] < 1 || date2[1] > 12) return;

        System.out.println(solution(date1, date2));
    }

    public static int solution(int[] date1, int[] date2) {
        for (int i = 0; i < 3; i++) {
            if (compareDate(date1[i], date2[i]) == 1) return 1;
            else if (compareDate(date1[i],date2[i]) == 0) return 0;
        }
        return 0;
    }

    private static int compareDate(int a, int b) {
        return a < b ? 1 : a > b ? 0 : -1;
    }

    public static int solution2(int[] date1, int[] date2) {
        LocalDate dateA = LocalDate.of(date1[0], date1[1], date1[2]);
        LocalDate dateB = LocalDate.of(date2[0], date2[1], date2[2]);

        if (dateA.isBefore(dateB)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static int solution3(int[] date1, int[] date2) {
        return Arrays.compare(date1, date2) < 0 ? 1 : 0;
    }
}