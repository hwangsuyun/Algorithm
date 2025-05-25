package com.example.algorithm.level0;

// 접미사인지 확인하기
public class Solution180 {
    public static void main(String[] args) {
        String my_string = "banana";
        String is_suffix = "ana";
        // 1
        //String my_string = "banana";
        //String is_suffix = "nan";
        // 0
        //String my_string = "banana";
        //String is_suffix = "wxyz";
        // 0
        //String my_string = "banana";
        //String is_suffix = "abanana";
        // 0

        if (my_string.length() < 1 || my_string.length() > 100) return;
        if (is_suffix.length() < 1 || is_suffix.length() > 100) return;

        System.out.println(solution(my_string, is_suffix));
    }

    public static int solution(String my_string, String is_suffix) {
        return my_string.endsWith(is_suffix) ? 1 : 0;
    }
}