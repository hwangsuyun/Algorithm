package com.example.algorithm.level2;

// [PCCP 기출문제] 2번 / 퍼즐 게임 챌린지
public class Solution79_1 {
    public static void main(String[] args) {
        int[] diffs = {1, 5, 3};
        int[] times = {2, 4, 7};
        long limit = 30;
        // 3
        //int[] diffs = {1, 4, 4, 2};
        //int[] times = {6, 3, 8, 2};
        //long limit = 59;
        // 2
        //int[] diffs = {1, 328, 467, 209, 54};
        //int[] times = {2, 7, 1, 4, 3};
        //long limit = 1723;
        // 294
        //int[] diffs = {1, 99999, 100000, 99995};
        //int[] times = {9999, 9001, 9999, 9001};
        //long limit = 3456789012L;
        // 39354

        System.out.println(solution(diffs, times, limit));
    }

    public static int solution(int[] diffs, int[] times, long limit) {
        int low = 1;
        int high = 100000;

        while(low < high) {
            int mid = low + (high - low) / 2;

            boolean pass = pass(diffs, times, limit, mid);
            if(pass) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean pass(int[] diffs, int[] times, long limit, int level) {
        long spent = 0;
        int time_prev = -1;

        for(int i = 0; i < diffs.length; i++) {
            if(spent > limit) return false;
            int diff = diffs[i];
            int time_cur = times[i];

            if(diff <= level) {
                spent += time_cur;
            } else {
                spent += (time_cur + time_prev) * (diff - level) + time_cur;
            }

            time_prev = time_cur;
        }

        return spent <= limit;
    }
}