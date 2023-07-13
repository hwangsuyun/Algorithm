package programmers.level1;

import java.util.stream.IntStream;

// 나머지가 1이 되는 수 찾기
public class Solution71 {
    public static void main(String[] args) {
        //int n = 10; // 3
        int n = 12; // 11

        if (n < 3 || n > 1000000) return;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        return IntStream.range(1, n).filter(i -> n % i == 1).min().orElse(1);
    }
}