package com.example.algorithm.level0;

// rny_string
public class Solution135 {
    public static void main(String[] args) {
        String rny_string = "masterpiece"; // "rnasterpiece"
        //String rny_string = "programmers"; // "prograrnrners"
        //String rny_string = "jerry"; // "jerry"
        //String rny_string = "burn"; // "burn"

        if (rny_string.length() < 1 || rny_string.length() > 100) return;

        System.out.println(solution(rny_string));
    }

    public static String solution(String rny_string) {
        return rny_string.replace("m", "rn");
    }
}