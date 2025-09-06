package com.example.algorithm.level2;

// [PCCP 기출문제] 2번 / 퍼즐 게임 챌린지
public class Solution79 {
    public static void main(String[] args) {
        //int[] diffs = {1, 5, 3};
        //int[] times = {2, 4, 7};
        //long limit = 30;
        // 3
        //int[] diffs = {1, 4, 4, 2};
        //int[] times = {6, 3, 8, 2};
        //long limit = 59;
        // 2
        //int[] diffs = {1, 328, 467, 209, 54};
        //int[] times = {2, 7, 1, 4, 3};
        //long limit = 1723;
        // 294
        int[] diffs = {1, 99999, 100000, 99995};
        int[] times = {9999, 9001, 9999, 9001};
        long limit = 3456789012L;
        // 39354

        System.out.println(solution(diffs, times, limit));
    }

    public static int solution(int[] diffs, int[] times, long limit) {
        int level = 0;

        do {
            int ret = calculate(level += 10, diffs, times, limit);
            if (ret > 0) {
                for (int i = level - 10; i < level; i++) {
                    ret = calculate(i, diffs, times, limit);
                    if (ret > 0) {
                        return ret;
                    }
                }
            }

        } while (level <= limit);
        return -1;
    }

    private static int calculate(int level, int[] diffs, int[] times, long limit) {
        long totalTime = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= level) {
                totalTime += times[i];
            } else {
                if (i == 0) {
                    totalTime += (long) (times[i] + i) * (diffs[i] - level) + times[i];
                } else {
                    totalTime += (long) (times[i] + times[i - 1]) * (diffs[i] - level) + times[i];
                }
            }

            if (totalTime > limit) {
                return -1;
            }
        }

        return level;
    }
}