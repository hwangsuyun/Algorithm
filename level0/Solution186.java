package com.example.algorithm.level0;

import java.util.Arrays;

// 9로 나눈 나머지
public class Solution186 {
    public static void main(String[] args) {
        //String number = "123"; // 6
        String number = "78720646226947352489"; // 2

        if (number.length() < 1 || number.length() > 100000) return;

        System.out.println(solution(number));
    }

    public static int solution(String number) {
        int answer = 0;
        for (char ch : number.toCharArray()) {
            answer += (ch - 48);
        }
        return answer % 9;
    }

    public static int solution2(String number) {
        return Arrays.stream(number.split("")).mapToInt(Integer::parseInt).sum() % 9;
    }

    public static int solution3(String number) {
        return number.chars().map(c -> (c - '0') % 9).sum() % 9;
    }
}