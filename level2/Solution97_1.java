package com.example.algorithm.level2;

import java.util.*;
import java.util.regex.*;

// [3차] 파일명 정렬
public class Solution97_1 {
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
        Pattern p = Pattern.compile("([a-z\\s.-]+)([0-9]{1,5})");

        Arrays.sort(files, (s1, s2) -> {
            Matcher m1 = p.matcher(s1.toLowerCase());
            Matcher m2 = p.matcher(s2.toLowerCase());
            m1.find();
            m2.find();

            if(!m1.group(1).equals(m2.group(1))) {
                return m1.group(1).compareTo(m2.group(1));
            } else {
                return Integer.parseInt(m1.group(2)) - Integer.parseInt(m2.group(2));
            }
        });

        return files;
    }
}