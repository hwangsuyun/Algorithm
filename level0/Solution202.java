package com.example.algorithm.level0;

// 주사위 게임 2
public class Solution202 {
    public static void main(String[] args) {
        int a = 2, b = 6, c =  1; // 9
        //int a = 5, b = 3, c = 3; // 473
        //int a =  4, b = 4, c = 4; // 110592

        if (a < 1 || a > 7) return;
        if (b < 1 || b > 7) return;
        if (c < 1 || c > 7) return;

        System.out.println(solution(a, b, c));
    }

    public static int solution(int a, int b, int c) {
        if (a != b && a != c && b != c) {
            return a + b + c;
        } else if (a == b && a == c) {
            return (int) ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)) * (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3)));
        } else {
            return (int) ((a + b + c) * (Math.pow(a, 2) + Math.pow(b, 2) + Math.pow(c, 2)));
        }
    }

    public static int solution2(int a, int b, int c) {
        int answer = 1;
        int count = 1;
        if(a == b || a == c || b == c) {
            count++;
        }

        if(a == b && b == c) {
            count++;
        }

        for(int i = 1; i <= count; i++) {
            answer *= (pow(a, i) + pow(b, i) + pow(c, i));
        }

        return answer;
    }

    private static int pow(int a, int b) {
        if(b == 0) return 1;
        return a * pow(a, b-1);
    }
}