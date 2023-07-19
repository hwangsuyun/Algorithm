package programmers.level2;

import java.util.Arrays;

// 요격 시스템
public class Solution48 {
    public static void main(String[] args) {
        int[][] targets = {{4, 5}, {4, 8}, {10, 14},
                {11, 13}, {5, 12}, {3, 7}, {1, 4}}; // 3
        //int[][] targets = {{0, 4}, {1, 2}, {1, 3}, {3, 4}}; // 2
        //int[][] targets = {{0, 4}, {0, 1}, {2, 3}}; // 2
        //int[][] targets = {{0, 4}, {5, 10}, {6, 8}, {8, 9}}; // 3

        if (targets.length < 1 || targets.length > 500000) return;
        for (int i = 0; i < targets.length; i++) {
            if (targets[i][0] < 0 || targets[i][0] > targets[i][1]) return;
            if (targets[i][1] < targets[i][0] || targets[i][1] > 100000000) return;
        }

        System.out.println(solution(targets));
    }

    public static int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int end = targets[0][1];
        answer++;

        for (int[] tar : targets) {
            if (tar[0] >= end) {
                end = tar[1];
                answer++;
            }
        }

        return answer;
    }
}