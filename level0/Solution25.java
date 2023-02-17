package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

// 암호 해독
public class Solution25 {
    public static void main(String[] args) {
        //String cipher = "dfjardstddetckdaccccdegk";
        //int code = 4;
        // attack
        String cipher = "pfqallllabwaoclk";
        int code = 2;
        // fallback

        if (cipher.length() < 1 || cipher.length() > 1000) return;
        if (code < 1 || code > cipher.length()) return;

        System.out.println(solution(cipher, code));
    }

    public static String solution(String cipher, int code) {
        String answer = "";
        int temp = code;
        for (int i = 0; i < cipher.length(); i++) {
            if (i == temp - 1) {
                answer += cipher.charAt(temp - 1);
                temp += code;
            }
        }
        return answer;
    }
}
