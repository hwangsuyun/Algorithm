package com.example.algorithm.level2;

import java.util.LinkedList;
import java.util.Queue;

// [PCCP 기출문제] 2번 / 석유 시추
public class Solution81 {
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
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0,-1, 0, 1};

        // 1. 모든 구역 순회하기 (column 이동)
        for (int column = 0; column < land[0].length; column++) {
            // 1.1 모든 구역 순회하기 (row 이동)
            for (int row = 0; row < land.length; row++) {
                // 1.2 이미 방문했는지 확인
                if (land[row][column] == -1 || land[row][column] == 0) continue;

                // 2. 석유 발견되면 인근 위치 모두 찾기
                locate.add(new int[]{row, column});
                int count = 0;
                int[] array = new int[land[0].length];

                // 2.1 queue 를 이용한 bfs
                while (!locate.isEmpty()) {
                    int[] point = locate.poll();
                    int x = point[0];
                    int y = point[1];

                    if (x < 0 || x >= land.length || y < 0 || y >= land[0].length
                            || land[x][y] == -1 || land[x][y] == 0) continue;

                    count++;
                    land[x][y] = -1;
                    array[y] = 1;

                    // 2.2 상, 하, 좌, 우 탐색
                    for (int i = 0; i < 4; i++) {
                        int nx = x + dx[i];
                        int ny = y + dy[i];

                        if (nx < 0 || nx >= land.length || ny < 0 || ny >= land[0].length
                                || land[nx][ny] == -1 || land[nx][ny] == 0) continue;
                        locate.add(new int[]{nx, ny});
                    }
                }

                // 2.3 석유의 값을 각 열마다 더해준다.
                for (int i = 0; i < array.length; i++) {
                    if (array[i] == 1) {
                        sum[i] += count;
                    }
                }
            }

            // 3. max 값 구하기 (열의 최대 석유값)
            answer = Math.max(answer, sum[column]);
        }

        return answer;
    }
}