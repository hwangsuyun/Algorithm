package com.example.algorithm.level0;

// 간단한 식 계산하기
public class Solution137 {
    public static void main(String[] args) {
        //String binomial = "43 + 12"; // 55
        //String binomial = "0 - 7777"; // -7777
        String binomial = "40000 * 40000"; // 1600000000

        System.out.println(solution(binomial));
    }

    public static int solution(String binomial) {
        String a = "";
        String op = "";
        StringBuilder b = new StringBuilder();
        for (char ch : binomial.replace(" ", "").toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                b.append(ch);
            } else {
                op = ch + "";
                a = b.toString();
                b = new StringBuilder();
            }
        }
        return switch (op) {
            case "+" -> Integer.parseInt(a) + Integer.parseInt(b.toString());
            case "-" -> Integer.parseInt(a) - Integer.parseInt(b.toString());
            case "*" -> Integer.parseInt(a) * Integer.parseInt(b.toString());
            case "/" -> Integer.parseInt(a) / Integer.parseInt(b.toString());
            default -> 0;
        };
    }

    public static int solution2(String binomial) {
        String[] parts = binomial.split(" ");
        int a = Integer.parseInt(parts[0]);
        int b = Integer.parseInt(parts[2]);
        char op = parts[1].charAt(0);
        int result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
        return result;
    }
}