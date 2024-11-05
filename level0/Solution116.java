package com.example.algorithm.level0;

// 부분 문자열인지 확인하기
public class Solution116 {
    public static void main(String[] args) {
        String my_string = "banana";
        String target = "ana";
        // 1
        //String my_string = "banana";
        //String target = "wxyz"
        // 0

        if (my_string.length() < 1 || my_string.length() > 100) return;
        if (target.length() < 1 || target.length() > 100) return;

        System.out.println(solution(my_string, target));
    }

    public static int solution(String my_string, String target) {
        return my_string.contains(target) ? 1 : 0;
    }
}