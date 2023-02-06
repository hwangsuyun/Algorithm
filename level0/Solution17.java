package programmers.level0;

import java.util.Arrays;
import java.util.function.Predicate;

// 문자열 계산하기
public class Solution17 {
    public static void main(String[] args) {
        String my_string = "3 + 4"; // 7

        if (my_string.length() < 5 || my_string.length() > 100) return;

        System.out.println(solution(my_string));
    }

    public static int solution(String my_string) {
        String[] strArray = my_string.split(" ");
        int answer = Integer.parseInt(strArray[0]);

        for (int i = 0; i < strArray.length; i++) {
            if (i % 2 == 1) {
                if (strArray[i].equals("+")) {
                    answer += Integer.parseInt(strArray[i + 1]);
                } else {
                    answer -= Integer.parseInt(strArray[i + 1]);
                }
            }
        }
        return answer;
    }
}
