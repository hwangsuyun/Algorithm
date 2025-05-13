package com.example.algorithm.level0;

// 글자 지우기
public class Solution172 {
    public static void main(String[] args) {
        String my_string = "apporoograpemmemprs";
        int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};
        // "programmers"

        if (indices.length < 1 || indices.length > my_string.length()) return;
        for (int i : indices) {
            if (i < 0 || i > my_string.length()) return;
        }
        if (my_string.length() < indices.length || my_string.length() > 100) return;

        System.out.println(solution(my_string, indices));
    }

    public static String solution(String my_string, int[] indices) {
        String[] strArr = my_string.split("");
        for (int i : indices) strArr[i] = "";
        return String.join("", strArr);
    }
}