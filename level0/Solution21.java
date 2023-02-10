package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

// 한 번만 등장한 문자
public class Solution21 {
    public static void main(String[] args) {
        //String s = "abcabcadc"; // d
        //String s = "abdc"; // abdc
        String s = "hello"; // eho

        if (s.length() < 0 || s.length() > 1000) return;

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        return Arrays.stream(s.split(""))
                .filter(str -> s.length() - s.replace(str, "").length() == 1)
                .sorted()
                .collect(Collectors.joining());
    }
}
