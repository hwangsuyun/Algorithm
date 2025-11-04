package com.example.algorithm.level2;

// 모음사전
public class Solution93_1 {
    public static void main(String[] args) {
        //String word = "AAAAE"; // 6
        //String word = "AAAE"; // 10
        //String word = "I"; // 1563
        String word = "EIO"; // 1189

        System.out.println(solution(word));
    }

    public static int solution(String word) {
        int answer = 0, per = 3905;
        for(String s : word.split("")) answer += "AEIOU".indexOf(s) * (per /= 5) + 1;
        return answer;
    }
}