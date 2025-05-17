package com.example.algorithm.level0;

// 문자 개수 세기
public class Solution174 {
    public static void main(String[] args) {
        String my_string = "Programmers";
        // [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 2, 0, 1, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0]

        if (my_string.length() < 1 || my_string.length() > 1000) return;

        int[] result = solution(my_string);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String my_string) {
        int[] answer = new int[52];
        for (char ch : my_string.toCharArray()) {
            if (ch >= 65 && ch <= 90) answer[ch - 65] += 1;
            else answer[ch - 71] += 1;
        }
        return answer;
    }

    public static int[] solution2(String my_string) {
        int[] answer = new int[52];
        for(int i = 0; i < my_string.length(); i++){
            char c = my_string.charAt(i);
            if(c >= 'a')
                answer[c - 'a' + 26]++;
            else
                answer[c - 'A']++;
        }
        return answer;
    }
}