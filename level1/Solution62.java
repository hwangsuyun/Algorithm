package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 과일 장수
public class Solution62 {
    public static void main(String[] args) {
        //int k = 3;
        //int m = 4;
        //int[] score = {1, 2, 3, 1, 2, 3, 1};
        // 8
        int k = 4;
        int m = 3;
        int[] score = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        // 33

        if (k < 3 || k > 9) return;
        if (m < 3 || m > 10) return;
        if (score.length < 7 || score.length > 1000000) return;
        for (int i = 0; i < score.length; i++) {
            if (score[i] < 1 || score[i] > k) return;
        }

        System.out.println(solution(k, m, score));
    }

    public static int solution(int k, int m, int[] score) {
        int[][] boxes = new int[score.length / m][m];
        int boxIndex = 0, j = 0;
        int min = 0, apple = 0;
        int answer = 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < score.length; i++) {
            if (score[i] <= k) {
                list.add(score[i]);
            }
        }
        Collections.sort(list);

        for (int i = list.size() - 1; i >= 0; i--) {
            if (j == m) {
                j = 0;
                boxIndex++;
            }
            if (boxIndex < boxes.length) {
                boxes[boxIndex][j] = list.get(i);
                j++;
            }
        }

        for (int i = 0; i < boxes.length; i++) {
            min = boxes[i][m - 1];
            apple = boxes[i].length;
            answer += min * apple;
        }

        return answer;
    }
}