package programmers.level0;

import java.util.Arrays;

// 나머지 구하기
public class Solution90 {
    public static void main(String[] args) {
        //int num1 = 3;
        //int num2 = 2;
        // 1
        int num1 = 10;
        int num2 = 5;
        // 0

        if (num1 <= 0 || num1 > 100) return;
        if (num2 <= 0 || num2 > 100) return;

        System.out.println(solution(num1, num2));
    }

    public static int solution(int num1, int num2) {
        return num1 % num2;
    }
}