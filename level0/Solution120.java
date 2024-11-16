package com.example.algorithm.level0;

// 0 떼기
public class Solution120 {
    public static void main(String[] args) {
        //String n_str = "0010"; // "10"
        String n_str = "854020"; //	"854020"

        if (n_str.length() < 2 || n_str.length() > 10) return;

        System.out.println(solution(n_str));
    }

    public static String solution(String n_str) {
        for (char ignored : n_str.toCharArray()) {
            n_str = n_str.replaceAll("^0", "");
        }
        return n_str;
    }

    public static String solution2(String n_str) {
        return "" + Integer.parseInt(n_str);
    }
}