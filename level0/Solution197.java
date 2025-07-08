package com.example.algorithm.level0;

// 수 조작하기 2
public class Solution197 {
    public static void main(String[] args) {
        int[] numLog = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1}; // "wsdawsdassw"

        if (numLog.length < 2 || numLog.length > 100000) return;
        for (int num : numLog) {
            if (num < -100000 || num > 1000000) return;
        }

        System.out.println(solution(numLog));
    }

    public static String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numLog.length - 1; i++) {
            if (numLog[i] + 1 == numLog[i + 1]) {
                sb.append("w");
            } else if (numLog[i] - 1 == numLog[i + 1]) {
                sb.append("s");
            } else if (numLog[i] + 10 == numLog[i + 1]) {
                sb.append("d");
            } else {
                sb.append("a");
            }
        }

        return sb.toString();
    }
}