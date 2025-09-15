package com.example.algorithm.level2;

import java.util.Stack;

// 멀리 뛰기
public class Solution85_1 {
    public static void main(String[] args) {
        String s = "[](){}"; // 3
        //String s = "}]()[{"; // 2
        //String s = "[)(]"; // 0
        //String s = "}}}";	// 0

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        if (s.length() % 2 != 0) return 0;

        int answer = 0;
        String temp;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i++) {
            temp = s.substring(i) + sb;
            sb.append(s.charAt(i));
            if (isMatch(temp)) {
                answer++;
            }
        }
        return answer;
    }

    private static boolean isMatch(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                stack.push(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    char ch = stack.pop();
                    if (ch == '(' && s.charAt(i) == ')') continue;
                    else if (ch == '{' && s.charAt(i) == '}') continue;
                    else if (ch == '[' && s.charAt(i) == ']') continue;
                    return false;
                }
                return false;
            }
        }
        return stack.isEmpty();
    }
}