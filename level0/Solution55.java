package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

// 팩토리얼
public class Solution55 {
    public static void main(String[] args) {
        //int n = 3628800; // 10
        //int n = 7; // 3
        int n = 1; //

        if (n < 0 || n > 3628800) return;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 1;
        for (int i = 1; i <= n; i++) {
            answer *= i;
            if (answer == n) return i;
            else if (answer > n) return i - 1;
        }
        return answer;
    }
}