package solution1;

import java.util.*;

// 중요한 단어를 스포 방지
public class Solution87 {
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
        Set<String> revealedWords = new HashSet<>();

        // 1. 모든 스포 방지 구간을 boolean 배열로 표시
        boolean[] isSpoiler = new boolean[message.length()];
        for (int[] range : spoiler_ranges) {
            for (int i = range[0]; i <= range[1] && i < message.length(); i++) {
                isSpoiler[i] = true;
            }
        }

        // 2. 각 단어가 스포 방지 구간에 완전히 포함되지 않은 경우 추출
        Set<String> nonSpoilerWords = getStrings(message, isSpoiler);

        // 3. 각 스포 방지 구간 처리
        for (int[] spoiler : spoiler_ranges) {
            int start = spoiler[0];
            int end = spoiler[1];

            // 단어의 시작 위치 찾기
            while (start > 0 && message.charAt(start - 1) != ' ') {
                start--;
            }

            // 단어의 끝 위치 찾기
            while (end < message.length() - 1 && message.charAt(end + 1) != ' ') {
                end++;
            }

            String importantMessage = message.substring(start, end + 1);
            String[] words = importantMessage.split("\\s+");

            for (String w : words) {
                if (!w.isEmpty() &&
                        !nonSpoilerWords.contains(w) &&
                        !revealedWords.contains(w)) {
                    revealedWords.add(w);
                    answer++;
                }
            }
        }

        return answer;
    }

    private static Set<String> getStrings(String message, boolean[] isSpoiler) {
        Set<String> nonSpoilerWords = new HashSet<>();
        StringBuilder word = new StringBuilder();
        boolean wordHasSpoiler = false;

        for (int i = 0; i <= message.length(); i++) {
            if (i == message.length() || message.charAt(i) == ' ') {
                if (!word.isEmpty() && !wordHasSpoiler) {
                    nonSpoilerWords.add(word.toString());
                }
                word.setLength(0);
                wordHasSpoiler = false;
            } else {
                word.append(message.charAt(i));
                if (isSpoiler[i]) {
                    wordHasSpoiler = true;
                }
            }
        }
        return nonSpoilerWords;
    }

}