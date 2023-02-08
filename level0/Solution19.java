package programmers.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

// 편지
public class Solution19 {
    public static void main(String[] args) {
        //String message = "happy birthday!"; // 30
        String message = "I love you~"; // 22

        if (message.length() < 1 || message.length() > 50) return;

        System.out.println(solution(message));
    }

    public static int solution(String message) {
        return message.length() * 2;
    }
}
