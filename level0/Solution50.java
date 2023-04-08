package programmers.level0;

import java.util.Arrays;

// 컨트롤 제트
public class Solution50 {
    public static void main(String[] args) {
        //String s = "1 2 Z 3"; // 4
        //String s = "10 20 30 40"; // 100
        //String s = "10 Z 20 Z 1"; // 1
        //String s = "10 Z 20 Z"; // 0
        String s = "-1 -2 -3 Z"; // -3

        if (s.length() < 1 || s.length() > 200) return;

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0, index = 0;
        String[] array = s.split(" ");

        for (String str : array) {
            if (!str.equals("Z")) {
                answer += Integer.parseInt(str);
            } else {
                answer -= Integer.parseInt(array[index - 1]);
            }
            index++;
        }
        return answer;
    }
}