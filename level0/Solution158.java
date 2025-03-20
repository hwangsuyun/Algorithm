package com.example.algorithm.level0;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// 5명씩
public class Solution158 {
    public static void main(String[] args) {
        String[] names = {"nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"}; // ["nami", "vex"]

        if (names.length < 5 || names.length > 30) return;
        for (String name : names) {
            if (name.length() < 1 || name.length() > 10) return;
        }

        String[] result = solution2(names);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String[] solution(String[] names) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            if (i % 5 == 0) {
                list.add(names[i]);
            }
        }
        return list.toArray(String[]::new);
    }

    public static String[] solution2(String[] names) {
        return IntStream.range(0, names.length).filter(i -> i % 5 == 0).mapToObj(i -> names[i]).toArray(String[]::new);
    }

    public static String[] solution3(String[] names) {
        int idx = 0;
        String[] answer = new String[names.length % 5 == 0 ? names.length / 5 : names.length / 5 + 1];
        for (int i = 0; i < names.length; i += 5) {
            answer[idx++] = names[i];
        }
        return answer;
    }
}