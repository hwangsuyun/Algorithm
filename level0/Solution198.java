package com.example.algorithm.level0;

// 수 조작하기 1
public class Solution198 {
    public static void main(String[] args) {
        int n = 0;
        String control = "wsdawsdassw";
        // -1

        if (n < -100000 || n > 100000) return;
        if (control.length() < 1 || control.length() > 100000) return;

        System.out.println(solution(n, control));
    }

    public static int solution(int n, String control) {
        for (char ch : control.toCharArray()) {
            switch (ch) {
                case 'w' -> n += 1;
                case 's' -> n -= 1;
                case 'd' -> n += 10;
                case 'a' -> n -= 10;
            }
        }
        return n;
    }
}