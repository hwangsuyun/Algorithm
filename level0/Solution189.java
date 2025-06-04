package com.example.algorithm.level0;

// 간단한 논리 연산
public class Solution189 {
    public static void main(String[] args) {
        boolean x1 = false, x2 = true, x3 =	true, x4 =	true;
        // true
        //boolean x1 = true, x2 =	false, x3 =	false, x4 =	false;
        // false

        System.out.println(solution(x1, x2, x3, x4));
    }

    public static boolean solution(boolean x1, boolean x2, boolean x3, boolean x4) {
        return (x1 || x2) && (x3 || x4);
    }
}