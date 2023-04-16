package programmers.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

// 합성수 찾기
public class Solution57 {
    public static void main(String[] args) {
        //int n = 10; // 5
        int n = 15; // 8

        if (n < 1 || n > 100) return;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int count = 0;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) count++;
                if (count == 3) break;
            }
            if (count == 3) answer++;
            count = 0;
        }
        return answer;
    }
}