package com.example.algorithm.level0;

// 접두사인지 확인하기
public class Solution178 {
    public static void main(String[] args) {
        String my_string = "banana";
        String is_prefix = "ban";
        // 1
        //String my_string = "banana";
        //String is_prefix = "nan";
        // 0
        //String my_string = "banana";
        //String is_prefix = "abcd";
        // 0
        //String my_string = "banana";
        //String is_prefix = "bananan";
        // 0

        if (my_string.length() < 1 || my_string.length() > 100) return;
        if (is_prefix.length() < 1 || is_prefix.length() > 100) return;

        System.out.println(solution(my_string, is_prefix));
    }

    public static int solution(String my_string, String is_prefix) {
        StringBuilder sb = new StringBuilder();
        for (char ch : my_string.toCharArray()) {
            if (sb.append(ch).toString().equals(is_prefix)) return 1;
        }
        return 0;
    }

    public static int solution2(String my_string, String is_prefix) {
        return my_string.startsWith(is_prefix) ? 1 : 0;
    }
}