package com.example.algorithm.level0;

import java.util.stream.Collectors;

// l로 만들기
public class Solution107 {
    public static void main(String[] args) {
        //String myString = "abcdevwxyz"; // "lllllvwxyz"
        String myString = "jjnnllkkmm"; // "llnnllllmm"

        if (myString.length() < 1 || myString.length() > 100000) return;

        System.out.println(solution2(myString));
    }

    public static String solution(String myString) {
        StringBuilder sb = new StringBuilder();
        for (char c : myString.toCharArray()) {
            if (c >= 'a' && c <= 'l') {
                sb.append("l");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static String solution2(String myString) {
        return myString.replaceAll("[a-l]", "l");
    }

    public static String solution3(String myString) {
        return myString.chars()
                .mapToObj(i -> Character.toString(Integer.max(i, 'l')))
                .collect(Collectors.joining());
    }
}