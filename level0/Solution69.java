package programmers.level0;

import java.util.Arrays;

// 외계행성의 나이
public class Solution69 {
    public static void main(String[] args) {
        //int age = 23; // "cd"
        //int age = 51; // "fb"
        int age = 100; // "baa"

        if (age > 1000) return;

        System.out.println(solution(age));
    }

    public static String solution(int age) {
        String[] strArray = Arrays.stream(String.valueOf(age).split(""))
                .mapToInt(s -> Integer.parseInt(s))
                .mapToObj(i -> (char) (i + 97))
                .map(c -> String.valueOf(c))
                .toArray(String[]::new);
        return String.join("", strArray);
    }
}