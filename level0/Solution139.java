package com.example.algorithm.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// x 사이의 개수
public class Solution139 {
    public static void main(String[] args) {
        String myString = "oxooxoxxox"; // [1, 2, 1, 0, 1, 0]
        //String myString = "xabcxdefxghi"; // [0, 3, 3, 3]

        if (myString.length() < 1 || myString.length() > 100000) return;

        int[] result = solution(myString);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String myString) {
         return Arrays.stream(myString.split("x", myString.length())).mapToInt(String::length).toArray();
    }

    public static int[] solution2(String myString) {
        List<Integer> list = new ArrayList<>();
        String[] strArray = myString.split("x");
        for (String str : strArray) {
            list.add(str.length());
        }
        if (myString.endsWith("x")) {
            list.add(0);
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}