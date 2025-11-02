package com.example.algorithm.level2;

import java.util.*;

// [3차] 압축
public class Solution92 {
    public static void main(String[] args) {
        //String msg = "KAKAO"; // [11, 1, 27, 15]
        //String msg = "TOBEORNOTTOBEORTOBEORNOT"; // [20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
        String msg = "ABABABABABABABAB"; // [1, 2, 27, 29, 28, 31, 30]

        int[] result = solution(msg);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String msg) {
        // 1.길이가 1인 모든 단어를 포함하도록 사전을 초기화한다.
        // 2.사전에서 현재 입력과 일치하는 가장 긴 문자열 w를 찾는다.
        // 3.w에 해당하는 사전의 색인 번호를 출력하고, 입력에서 w를 제거한다.
        // 4.입력에서 처리되지 않은 다음 글자가 남아있다면(c), w+c에 해당하는 단어를 사전에 등록한다.
        // 5.단계 2로 돌아간다.

        List<Integer> list = new ArrayList<>();
        Map<String, Integer> dictionary = new HashMap<>();

        for (char ch = 'A'; ch <= 'Z'; ch++) {
            dictionary.put(ch + "", ch - 64);
        }

        for (int i = 0; i < msg.length(); i++) {
            int index = 0;
            for (int j = i + 1; j <= msg.length(); j++) {
                String temp = msg.substring(i, j);
                if (dictionary.get(temp) == null) {
                    dictionary.put(temp, dictionary.size() + 1);
                    break;
                }
                index = j;
            }
            list.add(dictionary.get(msg.substring(i, index)));
            i = index - 1;
        }

        return list.stream().mapToInt(i -> i).toArray();
    }
}