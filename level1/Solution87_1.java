package solution1;

import java.util.*;

// 중요한 단어를 스포 방지
public class Solution87_1 {
    public static void main(String[] args) {
        //String message = "here is muzi here is a secret message";
        //int[][] spoiler_ranges = {{0, 3}, {23, 28}};
        // 1
        String message = "my phone number is 01012345678 and may i have your phone number";
        int[][] spoiler_ranges = {{5, 5}, {25, 28}, {34, 40}, {53, 59}};
        //String message = "my phone number is 01012345678 and may i have your phone number";
        //int[][] spoiler_ranges = {{5, 5}, {25, 28}, {25, 31}, {34, 40}, {53, 59}};
        // 4
        System.out.println(solution(message, spoiler_ranges));
    }

    private static int solution(String message, int[][] spoiler_ranges) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();

        StringBuilder blinds = new StringBuilder(message);
        for (int[] range: spoiler_ranges) {
            for (int i=range[0]; i<=range[1]; ++i) {
                if (blinds.charAt(i) != ' ')
                    blinds.setCharAt(i, '*');
            }
        }

        Collections.addAll(set, blinds.toString().split(" "));

        for (String word: message.split(" ")) {
            if (!set.contains(word)) {
                ++answer;
                set.add(word);
            }
        }

        return answer;
    }

}