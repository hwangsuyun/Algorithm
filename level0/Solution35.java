package programmers.level0;

import java.util.Arrays;
import java.util.stream.Collectors;

// 등수 매기기
public class Solution35 {
    public static void main(String[] args) {
        //int[][] score = {{80, 70}, {90, 50}, {40, 70}, {50, 80}}; // [1, 2, 4, 3]
        int[][] score = {{80, 70}, {70, 80}, {30, 50}, {90, 100}, {100, 90}, {100, 100}, {10, 30}};
        // [4, 4, 6, 2, 2, 1, 7]
        int[] rank = new int[score.length];

        for (int i = 0; i < score.length; i++) {
            if (score[i].length != 2) return;
            for (int j = 0; j < score[i].length; j++) {
                if (score[i][j] < 0 || score[i][j] > 100) return;
            }
        }

        rank = solution(score);
        for (int i : rank) System.out.println(i);
    }

    public static int[] solution(int[][] score) {
        int[] rank = new int[score.length];
        for (int i = 0; i < score.length; i++) {
            rank[i] = 1;
            for (int j = 0; j < score.length; j++) {
                if (score[i][0] + score[i][1] < score[j][0] + score[j][1]) {
                    rank[i] = rank[i] + 1;
                }
            }
        }
        return rank;
    }
}
