package com.example.algorithm.level2;

import java.util.*;

// 튜플
public class Solution88 {
    public static void main(String[] args) {
        //String s = "{{2},{2,1},{2,1,3},{2,1,3,4}}"; // [2, 1, 3, 4]
        //String s = "{{1,2,3},{2,1},{1,2,4,3},{2}}"; // [2, 1, 3, 4]
        //String s = "{{20,111},{111}}"; // [111, 20]
        //String s = "{{123}}"; // [123]
        String s = "{{4,2,3},{3},{2,3,4,1},{2,3}}"; // [3, 2, 4, 1]

        int[] result = solution(s);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String s) {
        // 1. s의 { }} 를 공백으로 바꾼다.
        s = s.replace("{", "").replace("}}", "},");
        // 2. s를 },로 잘라서 String 배열에 담는다.
        String[] strArray = s.split("},");

        Map<String, Integer> map = new HashMap<>();
        int[] answer = new int[strArray.length];
        int index = 0;

        // 3. strArray 를 순회하면서 map 에 원소를 담는다.
        // map 에 이미 있으면 있는 값 + 1, 없으면 1
        for (String str : strArray) {
            String[] temp = str.split(",");
            for (String t : temp) {
                map.put(t, map.getOrDefault(t, 0) + 1);
            }
        }

        // 4. map 을 내림차순으로 정렬한다.
        List<String> keySet = new ArrayList<>(map.keySet());
        keySet.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));
        for (String key : keySet) {
            answer[index++] = Integer.parseInt(key);
        }

        return answer;
    }
}