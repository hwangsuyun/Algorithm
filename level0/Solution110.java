package com.example.algorithm.level0;

import java.util.Arrays;

// 커피 심부름
public class Solution110 {
    public static void main(String[] args) {
        String[] order = {"cafelatte", "americanoice", "hotcafelatte", "anything"};
        // 19000
        //String[] order = {"americanoice", "americano", "iceamericano"};
        // 13500

        if (order.length < 1 || order.length > 1000) return;
        System.out.println(solution2(order));
    }

    public static int solution(String[] order) {
        int answer = 0;
        for (String s : order) {
            if (s.contains("am") || s.contains("an")) {
                answer += 4500;
            } else {
                answer += 5000;
            }
        }
        return answer;
    }

    public static int solution2(String[] order) {
        return order.length * 4500 + (int) (Arrays.stream(order).filter(s -> s.contains("tt")).count()) * 500;
    }

    public static int solution3(String[] order) {
        int answer = 0;
        for(String o : order) {
            if(o.contains("cafelatte")) {
                answer += 5000;
            } else {
                answer += 4500;
            }
        }
        return answer;
    }
}