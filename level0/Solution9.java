package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

// 세균 증식
public class Solution9 {
    public static void main(String[] args) {
        //int n = 2, t = 10; // 2048
        int n = 7, t = 15; // 229,376

        if (n < 1 || n > 10) return;
        if (t < 1 || t > 15) return;

        System.out.println(solution(n, t));
    }

    public static int solution(int n, int t) {
        for (int i = 0; i < t; i++) {
            n *= 2;
        }
        return n;
    }
}
