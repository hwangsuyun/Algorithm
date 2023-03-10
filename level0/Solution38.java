package programmers.level0;

import java.util.*;
import java.util.stream.Collectors;

// 겹치는 선분의 길이
public class Solution38 {
    public static void main(String[] args) {
        //int[][] lines = {{0, 1}, {2, 5}, {3, 9}}; // 2
        //int[][] lines = {{-1, 1}, {1, 3}, {3, 9}}; // 0
        //int[][] lines = {{0, 5}, {3, 9}, {1, 10}}; // 8
        //int[][] lines = {{-1, 0}, {0, 1}, {1, 2}}; // 0
        //int[][] lines = {{0, 10}, {3, 9}, {1, 10}}; // 9
        //int[][] lines = {{0, 9}, {1, 1}, {2, 5}}; // 3
        //int[][] lines = {{0, 2}, {-3, -1}, {-2, 1}}; // 2
        //int[][] lines = {{0, 3}, {-3, -1}, {-2, 3}}; // 4
        //int[][] lines = {{0, 3}, {0, 3}, {0, 3}}; // 3
        int[][] lines = {{-3, -1}, {-2, 3}, {2, 3}}; // 2

        if (lines.length != 3) return;
        for (int i = 0; i < lines.length; i++) {
            if (lines[i].length != 2) return;
            for (int j = 0; j < lines[i].length; j++) {
                if (lines[i][j] < -100 || lines[i][j] > 100) return;
            }
        }

        System.out.println(solution(lines));
    }

    public static int solution(int[][] lines) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < lines.length; i++) {
            if (lines[i][0] == lines[i][1]) continue;
            for (int j = i + 1; j <= lines.length - 1; j++) {
                if (lines[j][0] == lines[j][1]) continue;
                if (lines[i][1] > lines[j][0] && lines[i][0] < lines[j][1]) {
                    int a = 0, b = 0;
                    if (lines[i][0] > lines[j][0]) {
                        if (lines[i][1] > lines[j][1]) {
                            a = lines[i][0];
                            b = lines[j][1];
                        } else {
                            a = lines[i][0];
                            b = lines[i][1];
                        }
                    } else {
                        if (lines[i][1] > lines[j][1]) {
                            a = lines[j][0];
                            b = lines[j][1];
                        } else {
                            a = lines[j][0];
                            b = lines[i][1];
                        }
                    }
                    for (int k = a + 1; k <= b; k++) {
                        set.add(k);
                    }
                }
            }
        }

        List<Integer> list = set.stream().sorted().collect(Collectors.toList());
        return list.size() > 0 ? list.size() : 0;
    }
}
