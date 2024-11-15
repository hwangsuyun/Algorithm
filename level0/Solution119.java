package com.example.algorithm.level0;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Stack;

// 두 수의 합
public class Solution119 {
    public static void main(String[] args) {
        //String a = "582";
        //String b = "734";
        // "1316"
        String a = "18446744073709551615";
        String b = "287346502836570928366";
        // "305793246910280479981"
        //String a = "0";
        //String b = "0";
        // "0"

        if (a.length() < 1 || a.length() > 100000) return;
        if (b.length() < 1 || b.length() > 100000) return;

        System.out.println(solution(a, b));
    }

    public static String solution(String a, String b) {
        return new BigDecimal(a).add(new BigDecimal(b)) + "";
    }

    public static String solution2(String a, String b) {
        String answer = "";
        Stack<Integer> stack = new Stack<>();
        String tmp = "";

        int shortLen = Math.min(a.length(), b.length());
        int longLen = Math.max(a.length(), b.length());

        if (a.length() != b.length()) {
            if (shortLen == a.length()) {
                for (int i = shortLen; i < longLen; i++) {
                    tmp += "0";
                }
                a = tmp + a;
            } else {
                for (int i = shortLen; i < longLen; i++) {
                    tmp += "0";
                }
                b = tmp + b;
            }
        }

        boolean carry = false;
        int sumNum = 0;

        for (int i = a.length() - 1; i >= 0; i--) {
            int NumA = Integer.parseInt(String.valueOf(a.charAt(i)));
            int NumB = Integer.parseInt(String.valueOf(b.charAt(i)));

            if (carry) {
                sumNum = NumA + NumB + 1;
                carry = false;
            } else {
                sumNum = NumA + NumB;
            }

            if (sumNum >= 10) {
                carry = true;
                stack.push(sumNum - 10);
            } else {
                stack.push(sumNum);
            }
        }

        if (carry) {
            stack.push(1);
        }

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }

    public static String solution3(String a, String b) {
        return new BigInteger(a).add(new BigInteger(b)).toString();
    }
}