package programmers.level0;

import java.util.Arrays;

// 숨어있는 숫자의 덧셈 (2)
public class Solution44 {
    public static void main(String[] args) {
        //String my_string = "aAb1B2cC34oOp"; // 37
        String my_string = "1a2b3c4d123Z"; // 133

        if (my_string.length() < 1 || my_string.length() > 1000) return;

        System.out.println(solution(my_string));
    }

    public static int solution(String my_string) {
        my_string = my_string.replaceAll("[a-z]|[A-Z]", ",");
        return Arrays.stream(my_string.split(",")).filter(str -> !str.equals("")).mapToInt(Integer::parseInt).sum();
    }
}