package programmers.level0;

import java.util.stream.IntStream;

// 순서쌍의 개수
public class Solution67 {
    public static void main(String[] args) {
        int n = 20; // 6
        //int n = 100; // 9

        if ( n < 1 || n > 1000000) return;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        return (int) IntStream.rangeClosed(1, n).filter(i -> n % i == 0).count();
    }
}