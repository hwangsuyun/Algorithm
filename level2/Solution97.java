package com.example.algorithm.level2;

import java.util.*;

// [3차] 파일명 정렬
public class Solution97 {
    public static void main(String[] args) {
        //String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        // ["img1.png", "IMG01.GIF", "img02.png", "img2.JPG", "img10.png", "img12.png"]
        //String[] files = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};
        // ["A-10 Thunderbolt II", "B-50 Superfortress", "F-5 Freedom Fighter", "F-14 Tomcat"]
        //String[] files = {"F13.png", "F14", "f013", "F014", "F013.TXT"};
        // ["F13.png", "f013", "F013.TXT", "F14", "F014"};
        //String[] files = {"a000011", "a00001"};
        // ["a000011", "a00001"]
        //String[] files = {"a0001", "a001", "a000001"};
        // ["a000001", "a0001", "a001"]
        //String[] files = {"F-15", "f15", "F15.png"};
        // ["f15", "F15.png", "F-15"]
        //String[] files = {"img000012345", "img1.png","img2","IMG02"};
        // ["img1.png", "img2", "IMG02", "img000012345"]
        String[] files = {"ABC12", "AbC12", "aBc12"};
        // [ABC12,AbC12,aBc12]

        String[] result = solution(files);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String[] solution(String[] files) {
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();

        // 1.문자열 header, number, tail 나누기
        for (String file : files) {
            String str;
            String header = "", number = "", tail = "";
            boolean first = false;
            int index = 0;

            for (int i = 0; i < file.length(); i++) {
                char ch = file.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    if (!first) {
                        header = file.substring(0, i);
                        first = true;
                        index = i;
                    }
                } else {
                    if (first) {
                        number = file.substring(index, i);
                        tail = file.substring(i);
                        break;
                    }
                }

                if (number.length() == 0 && i == file.length() - 1) {
                    number = file.substring(index, i + 1);
                }
            }

            if (number.length() > 5) number = number.substring(0, 5);

            str = header + ";" + number + ";" + tail;
            list.add(str);
            map.put(str, file);
        }

        // 2.header, number 로 정렬하기
        list.sort((o1, o2) -> {
            String[] array1 = o1.split(";");
            String[] array2 = o2.split(";");
            String str1 = array1[0].toLowerCase();
            String str2 = array2[0].toLowerCase();
            if (str1.compareTo(str2) == 0) {
                return Integer.parseInt(array1[1]) - Integer.parseInt(array2[1]);
            } else {
                return str1.compareTo(str2);
            }
        });

        // 3.list 값 map 에서 꺼내기
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = map.get(list.get(i));
        }

        return answer;
    }
}