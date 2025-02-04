package com.example.algorithm.level0;

// A 강조하기
public class Solution146 {
    public static void main(String[] args) {
        String myString = "abstract algebra"; // "AbstrAct AlgebrA"
        //String myString = "PrOgRaMmErS"; // "progrAmmers"

        if (myString.length() < 1 || myString.length() > 20) return;

        System.out.println(solution(myString));
    }

    public static String solution(String myString) {
        return myString.toLowerCase().replace("a", "A");
    }
}