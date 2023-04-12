package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

// 모음 제거
public class Solution54 {
    public static void main(String[] args) {
        //String my_string = "bus"; // bs
        String my_string = "nice to meet you"; // nc t mt y

        if (my_string.length() < 1 || my_string.length() > 1000) return;

        System.out.println(solution(my_string));
    }

    public static String solution(String my_string) {
        return Arrays.stream(my_string.replaceAll("[aeiou]", "")
                    .split(""))
                    .collect(Collectors.joining(""));
    }
}