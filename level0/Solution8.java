package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

// 문자열 정렬하기(2)
public class Solution8 {
    public static void main(String[] args) {
        //String my_string = "Bcad"; // abcd
        //String my_string = "heLLo"; // ehllo
        String my_string = "Python"; // hnopty

        if (my_string.length() < 0  || my_string.length() > 100) return;

        System.out.println(solution(my_string));
    }

    public static String solution(String my_string) {
        return Arrays.stream(
                my_string.toLowerCase().chars().toArray())
                .sorted().mapToObj(i -> ((char) i + ""))
                .collect(Collectors.joining(""));
    }
}
