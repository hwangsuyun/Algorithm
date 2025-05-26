package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

// 접미사 배열
public class Solution181 {
    public static void main(String[] args) {
        String my_string = "banana";
        // ["a", "ana", "anana", "banana", "na", "nana"]
        //String my_string = "programmers";
        // ["ammers", "ers", "grammers", "mers", "mmers", "ogrammers", "programmers", "rammers", "rogrammers", "rs", "s"]

        if (my_string.length() < 1 || my_string.length() > 100) return;

        String[] result = solution(my_string);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String[] solution(String my_string) {
        String[] answer = new String[my_string.length()];
        for (int i = 0; i < my_string.length(); i++) {
            answer[i] = my_string.substring(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    public static String[] solution2(String my_string) {
        return IntStream.range(0, my_string.length()).mapToObj(my_string::substring).sorted().toArray(String[]::new);
    }
}