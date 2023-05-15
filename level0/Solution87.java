package programmers.level0;

import java.util.stream.IntStream;

// 짝수는 싫어요
public class Solution87 {
    public static void main(String[] args) {
        //int n = 10; // [1, 3, 5, 7, 9]
        int n = 15; // [1, 3, 5, 7, 9, 11, 13, 15]

        if (n < 1 || n > 100) return;

        int[] result = solution(n);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int n) {
        return IntStream.rangeClosed(1, n).filter(i -> i % 2 != 0).toArray();
    }
}