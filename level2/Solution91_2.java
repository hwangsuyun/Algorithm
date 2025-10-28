package com.example.algorithm.level2;

import java.math.BigInteger;
import java.util.*;

// k진수에서 소수 개수 구하기
public class Solution91_2 {
    public static void main(String[] args) {
        //int n = 437674;
        //int k = 3;
        // 3
        int n = 110011;
        int k = 10;
        // 2

        System.out.println(solution(n, k));
    }

    public static int solution(int n, int k) {
        String s = Integer.toString(n, k);
        return (int) Arrays.stream(s.split("0"))
                .filter(p ->
                        !p.isEmpty()
                                && !p.equals("1")
                                && isPrime(BigInteger.valueOf(Long.parseLong(p)))
                                && (s.contains("0${p}0")
                                || s.contains("${p}0")
                                || s.contains("0${p}")
                                || s.contains(p))
                )
                .count();
    }

    private static boolean isPrime(BigInteger n) {
        long l = 2;
        while (l <= Math.sqrt(n.doubleValue())) {
            if (n.remainder(BigInteger.valueOf(l)) == BigInteger.ZERO) return false;
            l++;
        }
        return true;
    }
}