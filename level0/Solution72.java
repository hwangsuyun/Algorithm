package programmers.level0;

import java.util.Arrays;

// 양꼬치
public class Solution72 {
    public static void main(String[] args) {
        //int n = 10;
        //int k = 3;
        // 124,000
        int n = 64;
        int k = 6;
        // 768,000

        if (n <= 0 || n >= 1000) return;
        if (k < n / 10 || k > 1000) return;

        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        return (n * 12000 + k * 2000) - (n / 10 * 2000);
    }
}