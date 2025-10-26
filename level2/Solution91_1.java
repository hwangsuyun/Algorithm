package com.example.algorithm.level2;

// k진수에서 소수 개수 구하기
public class Solution91_1 {
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
        int ans = 0;
        String temp[] = Integer.toString(n, k).split("0");

        Loop : for (String t : temp) {
            if (t.length() == 0) continue;
            long a = Long.parseLong(t);
            if (a == 1) continue;
            for (int i = 2; i <= Math.sqrt(a); i++)
                if (a % i == 0) continue Loop;

            ans++;
        }
        return ans;
    }
}