package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

// 인덱스 바꾸기
public class Solution22 {
    public static void main(String[] args) {
        //String my_string = "hello";
        //int num1 = 1;
        //int num2 = 2;
        // hlelo
        String my_string = "I love you";
        int num1 = 3;
        int num2 = 6;
        // I l veoyou

        if (my_string.length() < 1 || my_string.length() > 100) return;
        if (num1 < 0 || num1 > my_string.length()) return;
        if (num2 < 0 || num2 > my_string.length()) return;
        if (num1 == num2) return;

        System.out.println(solution(my_string, num1, num2));
    }

    public static String solution(String my_string, int num1, int num2) {
        String[] strArray = my_string.split("");
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            if (i == num1) {
                strArray[num1] = my_string.substring(num2, num2 + 1);
            } else if (i == num2) {
                strArray[num2] = my_string.substring(num1, num1 + 1);
            }
            answer += strArray[i];
        }
        return answer;
    }
}
