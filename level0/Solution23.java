package programmers.level0;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 영어가 싫어요
public class Solution23 {
    public static void main(String[] args) {
        //String numbers = "onetwothreefourfivesixseveneightnine"; //123456789/
        String numbers = "onefourzerosixseven"; //14067

        if (numbers.length() < 1 || numbers.length() > 50) return;

        System.out.println(solution(numbers));
    }

    public static long solution(String numbers) {
        return Long.parseLong(
                numbers.replace("zero", "0")
                .replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9"));
    }
}
