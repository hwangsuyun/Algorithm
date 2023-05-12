package programmers.level0;

import java.util.Arrays;

// 피자 나눠 먹기 (3)
public class Solution84 {
    public static void main(String[] args) {
        //int slice = 7;
        //int n = 10;
        // 2
        int slice = 4;
        int n = 12;
        // 3

        if (slice < 2 || slice > 10) return;
        if (n < 1 || n > 100) return;

        System.out.println(solution(slice, n));
    }

    public static int solution(int slice, int n) {
        return n % slice == 0 ? n / slice : n / slice  + 1;
    }
}