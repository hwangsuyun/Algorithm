package com.example.algorithm.level0;

import java.util.stream.IntStream;
import java.util.stream.Stream;

// 문자열이 몇 번 등장하는지 세기
public class Solution143 {
    public static void main(String[] args) {
        //String myString = "banana";
        //String pat = "ana";
        // 2
        String myString = "aaaa";
        String pat = "aa";
        // 3

        if (myString.length() < 1 || myString.length() > 1000) return;
        if (pat.length() < 1 || pat.length() > 10) return;

        System.out.println(solution2(myString, pat));
    }

    public static int solution(String myString, String pat) {
        int answer = 0;
        for (int i = 0; i <= myString.length() - pat.length(); i++) {
            if (myString.startsWith(pat, i)) answer++;
        }
        return answer;
    }

    public static int solution2(String myString, String pat) {
        return (int) IntStream.rangeClosed(0, myString.length() - pat.length()).filter(i -> myString.startsWith(pat, i)).count();
    }

    public static int solution3(String myString, String pat) {
        return (int) Stream.iterate(0, i -> i + 1)
                           .limit(myString.length() - pat.length() + 1)
                           .filter(i -> myString.substring(i, i + pat.length()).equals(pat))
                           .count();
    }
}