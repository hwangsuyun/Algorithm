package programmers.level0;

import java.util.Arrays;

// 중복된 문자 제거
public class Solution29 {
    public static void main(String[] args) {
        //String my_string = "people"; //peol
        String my_string = "We are the world"; //We arthwold

        if (my_string.length() < 1 || my_string.length() > 110) return ;

        System.out.println(solution(my_string));
    }

    public static String solution(String my_string) {
        char[] chars = my_string.toCharArray();
        String answer = "";
        for (int i = 0; i < chars.length; i++) {
            for (int j = i + 1; j <= chars.length - 1; j++) {
                if (chars[i] == chars[j]) {
                    chars[j] = '9';
                }
            }
        }
        for (char ch : chars) answer += ch;
        answer = answer.replace("9", "");
        return answer;
    }
}
