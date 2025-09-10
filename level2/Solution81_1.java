package com.example.algorithm.level2;

import java.util.LinkedList;
import java.util.Queue;

// [PCCP 기출문제] 2번 / 석유 시추
public class Solution81_1 {
    public static void main(String[] args) {
        int[][] land = {{0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}};
        // 9
        /*
        int[][] land = {{1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}};
        // 16
         */
        System.out.println(solution(land));
    }

    public static int solution(int[][] land) {
        /*
        {0, 0, 0, 1, 1, 1, 0, 0}
        {0, 0, 0, 0, 1, 1, 0, 0}
        {1, 1, 0, 0, 0, 1, 1, 0}
        {1, 1, 1, 0, 0, 0, 0, 0}
        {1, 1, 1, 0, 0, 0, 1, 1}
         */
        int answer = 0;
        Queue<int[]> locate = new LinkedList<>();
        int[] sum = new int[land[0].length];
        boolean[][] visited = new boolean[land.length][land[0].length];

        // 1. 모든 구역 순회하기 (column 이동)
        for (int column = 0; column < land[0].length; column++) {

            // 1.1 모든 구역 순회하기 (row 이동)
            for (int row = 0; row < land.length; row++) {
                // 1.2 이미 방문했는지 확인
                if (visited[row][column] || land[row][column] == 0) continue;

                // 2. 석유 발견되면 인근 위치 모두 찾기 (queue 를 이용한 bfs)
                locate.add(new int[]{row, column});
                int count = 0;
                int[] array = new int[land[0].length];

                while (!locate.isEmpty()) {
                    int[] point = locate.poll();
                    int x = point[0];
                    int y = point[1];

                    if (x < 0 || x >= land.length || y < 0 || y >= land[0].length
                            || visited[x][y] || land[x][y] == 0) continue;

                    count++;
                    visited[x][y] = true;
                    array[y] = 1;

                    // 2.1 상, 하, 좌, 우 탐색
                    int[] dx = {-1, 0, 1, 0};
                    int[] dy = {0,-1, 0, 1};
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length
                                || visited[nx][ny] || land[nx][ny] == 0) continue;
                        locate.add(new int[]{nx, ny});
                    }
                }

                for (int i = 0; i < array.length; i++) {
                    if (array[i] == 1) {
                        sum[i] += count;
                    }
                }
            }

            // 3. max 값 구하기 (최대 석유값)
            answer = Math.max(answer, sum[column]);
        }

        return answer;
    }
}