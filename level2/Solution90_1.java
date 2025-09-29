package com.example.algorithm.level2;

// [3차] n진수 게임
public class Solution90_1 {
    public static void main(String[] args) {
        //int n = 2, t = 4, m = 2, p = 1; // "0111"
        int n = 16, t = 16, m = 2, p = 1; // "02468ACE11111111"
        //int n = 16, t = 16, m = 2, p = 2; // "13579BDF01234567"

        System.out.println(solution(n, t, m, p));
    }

    public static String solution(int n, int t, int m, int p) {
        String answer = "";
        int startNum = 0;
        String targetString = new String();
        String retString = new String();

        while (targetString.length() < m * t) {
            targetString += Integer.toString(startNum++, n);
        }

        for (int i=0; i<t; i++) {
            retString += targetString.charAt(p - 1 + i * m);
        }

        answer = retString.toUpperCase();
        return answer;
    }
}