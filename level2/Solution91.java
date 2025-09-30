package com.example.algorithm.level2;

// k진수에서 소수 개수 구하기
public class Solution91 {
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        // 3
        //int n = 110011;
        //int k = 10;
        // 2

        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        int answer = 0;
        // 1. n 을 k 진수로 변환하고, 0 으로 자른다.
        String[] array = Integer.toString(n, k).split("0");
        for (String str : array) {
            // 2. 소수인지 체크한다.
            if (str.length() > 0 && isPrimeNumber(Long.parseLong(str))) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean isPrimeNumber(long number) {
        for (long i = number; i >= 2; i--) {
            if (i != 2 && i % 2 == 0) continue;
            for (long j = (long) Math.sqrt(i); j >= 2; j--) {
                if (i != j && i % j == 0) {
                    return false;
                }
            }
            if (i == number) {
                return true;
            }
        }
        return false;
    }

    // 소수 구하는 함수 리팩터링
    private static boolean isPrimeNumber2(long number) {
        if (number == 1) return false;
        for (long i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}