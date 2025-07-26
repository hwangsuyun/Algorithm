package com.example.algorithm.level0;

// 문자열 겹쳐쓰기
public class Solution215 {
    public static void main(String[] args) {
        String my_string = "He11oWor1d";
        String overwrite_string = "lloWorl";
        int s = 2;
        // "HelloWorld"
        //String my_string = "Program29b8UYP";
        //String overwrite_string = "merS123";
        //int s = 7;
        // "ProgrammerS123"

        if (overwrite_string.length() < 1 || overwrite_string.length() > 1000) return;
        if (my_string.length() < 1 || my_string.length() > 1000) return;

        System.out.println(solution(my_string, overwrite_string, s));
    }

    public static String solution(String my_string, String overwrite_string, int s) {
        return my_string.substring(0, s) + overwrite_string + my_string.substring(s + overwrite_string.length());
    }
}