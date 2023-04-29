package programmers.level0;

import java.util.stream.IntStream;

// 짝수의 합
public class Solution71 {
    public static void main(String[] args) {
        int n = 10; // 30
        //int n = 4; // 6

        if (n <= 0 || n > 1000) return;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> i % 2 == 0).sum();
    }
}