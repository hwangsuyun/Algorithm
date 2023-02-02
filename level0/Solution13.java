package programmers.level0;

import java.util.Arrays;

// 자릿수 더하기
public class Solution13 {
    public static void main(String[] args) {
        //int n = 1234; // 10
        int n = 930211; // 16

        if (n < 0 || n > 1000000) return;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        return Arrays.stream((n + "").split("")).mapToInt(Integer::parseInt).sum();
    }
}
