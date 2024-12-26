package com.example.algorithm.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 세 개의 구분자
public class Solution134 {
    public static void main(String[] args) {
        String myStr = "baconlettucetomato"; // ["onlettu", "etom", "to"]
        //String myStr = "abcd"; // ["d"]
        //String myStr = "cabab"; // ["EMPTY"]

        if (myStr.length() < 1 || myStr.length() > 1000000) return;

        String[] result = solution3(myStr);
        for (String s : result) {
            System.out.println(s);
        }
    }

    public static String[] solution(String myStr) {
        List<String> list = new ArrayList<>();
        StringTokenizer stk = new StringTokenizer(myStr.replaceAll("[abc]", " "), " ");
        while (stk.hasMoreTokens()) {
            list.add(stk.nextToken());
        }
        return list.isEmpty() ? new String[]{"EMPTY"} : list.toArray(String[]::new);
    }

    public static String[] solution2(String myStr) {
        String[] arr = Arrays.stream(myStr.split("[abc]+")).filter(str -> !str.isEmpty()).toArray(String[]::new);
        return arr.length == 0 ? new String[]{"EMPTY"} : arr;
    }

    public static String[] solution3(String myStr) {
        myStr = myStr.replaceAll("[a|b|c]+", ",");
        myStr = myStr.charAt(0) == ',' ? myStr.substring(1) : myStr;
        myStr = myStr.equals("") ? "EMPTY" : myStr;

        return myStr.split("[,]");
    }
}