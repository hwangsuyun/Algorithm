package com.example.algorithm.level2;

import java.util.*;

// [PCCP 기출문제] 3번 / 충돌위험 찾기
public class Solution80 {
    public static void main(String[] args) {
        //int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        //int [][] routes = {{4, 2}, {1, 3}, {2, 4}};
        // 1
        int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int [][] routes = {{4, 2}, {1, 3}, {4, 2}, {4, 3}};
        // 9
        //int[][] points = {{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};
        //int [][] routes = {{2, 3, 4, 5}, {1, 3, 4, 5}};
        // 0

        System.out.println(solution(points, routes));
    }

    public static int solution(int[][] points, int[][] routes) {
        Map<String, Integer> map = new HashMap<>();
        List<int[]> list = new ArrayList<>();

        // 1.모든 경로 구하기
        for (int[] route : routes) {
            int sec = 0;
            boolean moved = false;

            for (int i = 0; i < route.length - 1; i++) {
                int start = route[i];
                int end = route[i + 1];
                int[] startPosition = points[start - 1];
                int[] endPosition = points[end - 1];
                int xp = startPosition[0], yp = startPosition[1];

                // 1.1 up row
                if (startPosition[0] < endPosition[0]) {
                    int j = startPosition[0];
                    if (moved) j++;
                    for (; j <= endPosition[0]; j++) {
                        list.add(new int[]{sec, j, yp});
                        xp = j;
                        sec++;
                    }
                    moved = true;
                // 1.2 down row
                } else if (startPosition[0] > endPosition[0]) {
                    int j = startPosition[0];
                    if (moved) j--;
                    for (; j >= endPosition[0]; j--) {
                        list.add(new int[]{sec, j, yp});
                        xp = j;
                        sec++;
                    }
                    moved = true;
                }

                // 1.3 right column
                if (startPosition[1] < endPosition[1]) {
                    int j = startPosition[1];
                    if (moved) j++;
                    for (; j <= endPosition[1]; j++) {
                        list.add(new int[]{sec, xp, j});
                        sec++;
                    }
                    moved = true;
                // 1.4 left column
                } else if (startPosition[1] > endPosition[1]) {
                    int j = startPosition[1];
                    if (moved) j--;
                    for (; j >= endPosition[1]; j--) {
                        list.add(new int[]{sec, xp, j});
                        sec++;
                    }
                    moved = true;
                }
            }
        }

        // 2.중복 경로 구하기
        for (int[] ints : list) {
            String key = ints[0] + "," + ints[1] + "," + ints[2];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        return (int) map.values().stream().filter(i -> i > 1).count();
    }
}