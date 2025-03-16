package com.example.algorithm.level0;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

// 할 일 목록
public class Solution157 {
    public static void main(String[] args) {
        String[] todo_list = {"problemsolving", "practiceguitar", "swim", "studygraph"};
        boolean[] finished = {true, false, true, false};
        // ["practiceguitar", "studygraph"]

        if (todo_list.length < 1 || todo_list.length > 100) return;
        for (String todo : todo_list) {
            if (todo.length() < 2 || todo.length() > 20) return;
        }

        String[] result = solution(todo_list, finished);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String[] solution(String[] todo_list, boolean[] finished) {
        return IntStream.range(0, finished.length).filter(i -> !finished[i]).mapToObj(i -> todo_list[i]).toArray(String[]::new);
    }

    public static String[] solution2(String[] todo_list, boolean[] finished) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < finished.length; i++) {
            if (!finished[i]) {
                list.add(todo_list[i]);
            }
        }
        return list.toArray(String[]::new);
    }

    public static String[] solution3(String[] todo_list, boolean[] finished) {
        String str = "";
        for(int i=0; i<finished.length; i++){
            str = finished[i] == false ? str + todo_list[i] + "," : str;
        }
        return str.split(",");
    }

    public static String[] solution4(String[] todo_list, boolean[] finished) {
        return IntStream.range(0, todo_list.length)
                .mapToObj(i -> new AbstractMap.SimpleEntry<>(todo_list[i], !finished[i]))
                .filter(AbstractMap.SimpleEntry::getValue)
                .map(AbstractMap.SimpleEntry::getKey)
                .toArray(String[]::new);
    }
}