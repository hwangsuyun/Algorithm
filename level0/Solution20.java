package programmers.level0;

import java.util.stream.IntStream;

// 약수 구하기
public class Solution20 {
    public static void main(String[] args) {
        //int n = 24; // [1, 2, 3, 4, 6, 8, 12, 24]
        int n = 29; // [1, 29]

        if (n < 1 || n > 10000) return;

        solution(n);
    }

    public static int[] solution(int n) {
        return IntStream.range(0, n + 1).filter(i -> i != 0 && n % i == 0).toArray();
    }
}
