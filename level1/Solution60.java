package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 명예의 전당 (1)
public class Solution60 {
    public static void main(String[] args) {
        //int k = 3;
        //int[] score = {10, 100, 20, 150, 1, 100, 200};
        // [10, 10, 10, 20, 20, 100, 100]
        int k = 4;
        int[] score = {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000};
        // [0, 0, 0, 0, 20, 40, 70, 70, 150, 300]

        if (k < 3 || k > 100) return;
        if (score.length < 7 || score.length > 1000) return;
        for (int i = 0; i < score.length; i++) {
            if (score[i] < 0 || score[i] > 2000) return;
        }

        int[] result = solution(k, score);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int k, int[] score) {
        List<Integer> hallOfHonor = new ArrayList<>();
        int[] answer = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            if (i < k) {
                hallOfHonor.add(score[i]);
            } else {
                Collections.sort(hallOfHonor);
                if (score[i] > hallOfHonor.get(0)) {
                    hallOfHonor.set(0, score[i]);
                }
            }
            Collections.sort(hallOfHonor);
            answer[i] = hallOfHonor.get(0);
        }
        return answer;
    }
}