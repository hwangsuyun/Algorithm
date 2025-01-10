package com.example.algorithm.level0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 공백으로 구분하기 2
public class Solution140 {
    public static void main(String[] args) {
        //String myString = " i    love  you"; // ["i", "love", "you"]
        String myString = "    programmers  "; // ["programmers"]

        if (myString.length() < 1 || myString.length() > 1000) return;

        String[] result = solution(myString);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String[] solution(String my_string) {
        return Arrays.stream(my_string.split(" ")).filter(str -> !str.isEmpty()).toArray(String[]::new);
    }

    public static String[] solution2(String my_string) {
        List<String> list = new ArrayList<>();
        String[] array = my_string.split(" ");
        for (String str : array) {
            if (!str.isEmpty()) {
                list.add(str);
            }
        }

        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public static String[] solution3(String my_string) {
        return my_string.trim().split("[ ]+");
        // return myString.trim().split("\\s+");
    }
}