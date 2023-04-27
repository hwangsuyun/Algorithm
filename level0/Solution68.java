package programmers.level0;

import java.util.stream.IntStream;

// 진료순서 정하기
public class Solution68 {
    public static void main(String[] args) {
        //int[] emergency = {3, 76, 24}; // [3, 1, 2]
        //int[] emergency = {1, 2, 3, 4, 5, 6, 7}; // [7, 6, 5, 4, 3, 2, 1]
        int[] emergency = {30, 10, 23, 6, 100}; // [2, 4, 3, 5, 1]

        if (emergency.length < 1 || emergency.length > 10) return;
        for (int i = 0; i < emergency.length; i++) {
            if (emergency[i] < 1 || emergency[i] > 100) return;
        }

        int[] result = solution(emergency);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        for (int i = 0; i < emergency.length; i++) {
            answer[i] = 1;
        }

        for (int i = 0; i < emergency.length; i++) {
            for (int j = 0; j < emergency.length; j++) {
                if (i == j) continue;
                if (emergency[i] < emergency[j]) {
                    answer[i] += 1;
                }
            }
        }
        return answer;
    }
}