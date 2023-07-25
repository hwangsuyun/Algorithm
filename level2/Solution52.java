package programmers.level2;

import java.util.*;

// 광물 캐기
public class Solution52 {
    public static void main(String[] args) {
        //int[] picks = {1, 3, 2};
        //String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        // 12
        //int[] picks = {0, 1, 1};
        //String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};
        // 50
        int[] picks = {0, 1, 0};
        String[] minerals = {"diamond", "iron", "iron", "iron", "iron", "diamond", "diamond", "iron", "iron", "iron"};
        //

        for (int i = 0; i < picks.length; i++) {
            if (picks[i] < 0 || picks[i] > 5) return;
        }
        if (minerals.length < 5 || minerals.length > 50) return;

        System.out.println(solution(picks, minerals));
    }

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int size = 0, first = 0, second = 0, index = 0, value = 0;
        if (minerals.length % 5 == 0) size = minerals.length / 5;
        else size = minerals.length / 5 + 1;
        String[][] temp = new String[size][5];
        int[][] mineralScore = new int[size][picks.length];

        // 1.minerals 를 5개씩 잘라서 2차원 배열 temp 에 담기
        for (int i = 0; i < minerals.length; i++) {
            if (picks[0] + picks[1] + picks[2] <= first) break;
            if (i != 0 && i % 5 == 0) {
                first++;
                second = 0;
            }
            temp[first][second] = minerals[i];
            second++;
        }

        // 2. temp 의 diamond, iron, stone 을 숫자로 계산하여 2차원 배열 mineralScore 담기
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp[i].length; j++) {
                if (temp[i][j] == null) break;
                mineralScore[i][0] += calculateScore("diamond", temp[i][j]);
                mineralScore[i][1] += calculateScore("iron", temp[i][j]);
                mineralScore[i][2] += calculateScore("stone", temp[i][j]);
            }
        }

        // 3. mineralScore 배열의 값이 큰 것을 기준으로 내림차순 정렬
        Arrays.sort(mineralScore, ((o1, o2) -> (o2[0] + o2[1] + o2[2]) - (o1[0] + o1[1] + o1[2])));

        // 4. picks 곡괭이 바열만큼 돌면서 mineralScore 광물 캐서 점수 구하기
        index = 0; first = 0;
        while (true) {
            if (picks[0] == 0 && picks[1] == 0 && picks[2] == 0) break;
            if (index >= mineralScore.length) break;
            if (first >= picks.length) break;

            value = picks[first];
            second = first;
            while (value != 0) {
                if (index >= mineralScore.length) break;
                answer += mineralScore[index][second];
                index++;
                value--;
            }

            first++;
        }

        return answer;
    }

    private static int calculateScore(String pick, String mineral) {
        int score = 0;
        if (pick.equals("diamond")) {
            score = 1;
        } else if (pick.equals("iron") && mineral.equals("diamond")) {
            score = 5;
        } else if (pick.equals("stone") && mineral.equals("diamond")) {
            score = 25;
        } else if (pick.equals("stone") && mineral.equals("iron")) {
            score = 5;
        } else {
            score = 1;
        }
        return score;
    }
}