package programmers.level0;

import java.util.Arrays;

// 문자열 뒤집기
public class Solution78 {
    public static void main(String[] args) {
        //String my_string = "jaron"; // noraj
        String my_string = "bread"; // daerb

        if (my_string.length() < 1 || my_string.length() > 1000) return;

        System.out.println(solution(my_string));
    }

    public static String solution(String my_string) {
        String[] strArray = my_string.split("");
        String answer = "";
        for (int i = strArray.length - 1; i >= 0; i--) {
            answer += strArray[i];
        }
        return answer;
    }
}