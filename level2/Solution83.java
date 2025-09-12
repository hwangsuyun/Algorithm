package com.example.algorithm.level2;

// 이진 변환 반복하기
public class Solution83 {
    public static void main(String[] args) {
        //String s = "110010101001"; // [3,8]
        //String s = "01110"; // [3,3]
        String s = "1111111"; // [4,1]

        int[] result = solution(s);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String s) {
        int[] answer = new int[2];
        int zero = 0;
        int count = 0;

        while (!s.equals("1")) {
            zero += s.length();

            // 1. remove zero
            s = s.replace("0", "");
            zero -= s.length();

            // 2. replace decimal to binary
            s = Integer.toBinaryString(s.length());
            count++;
        }
        answer[0] = count;
        answer[1] = zero;

        return answer;
    }
}