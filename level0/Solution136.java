package com.example.algorithm.level0;

// 문자열 바꿔서 찾기
public class Solution136 {
    public static void main(String[] args) {
        String myString = "ABBAA";
        String pat = "AABB";
        // 1
        //String myString = "ABAB";
        //String pat = "ABAB";
        // 0

        if (myString.length() < 1 || myString.length() > 100) return;
        if (pat.length() < 1 || pat.length() > 10) return;

        System.out.println(solution(myString, pat));
    }

    public static int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        for (char ch : myString.toCharArray()) {
            if (ch == 'A') sb.append("B");
            else if (ch == 'B') sb.append("A");
            else sb.append(ch);
        }
        return sb.toString().contains(pat) ? 1 : 0;
    }

    public static int solution2(String myString, String pat) {
        myString = myString.replace("A", "a").replace("B", "A").replace("a", "B");
        return myString.contains(pat) ? 1 : 0;
    }
}