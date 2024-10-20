package com.example.algorithm.level0;

// 정수를 나선형으로 배치하기
public class Solution105 {
    public static void main(String[] args) {
        int n = 4; // [[1, 2, 3, 4], [12, 13, 14, 5], [11, 16, 15, 6], [10, 9, 8, 7]]
        //int n = 5;
        // [[1, 2, 3, 4, 5], [16, 17, 18, 19, 6], [15, 24, 25, 20, 7], [14, 23, 22, 21, 8], [13, 12, 11, 10, 9]]

        if (n < 1 || n > 30) return;

        int[][] result = solution(n);
        for (int [] arr : result) {
            for (int i : arr) {
                System.out.println(i);
            }
        }
    }

    public static int[][] solution(int n) {
        int count = 1;
        int[][] answer = new int[n][n];
        int up = n - 1, down = 0, left = 0, right = n;

        while (count <= n * n) {
            for (int i = down; i < right; i++) {
                answer[down][i] = count++;
            }
            down++;

            for (int i = down; i < right; i++) {
                answer[i][right - 1] = count++;
            }
            right--;

            for (int i = up - 1; i >= left; i--) {
                answer[up][i] = count++;
            }
            up--;

            for (int i = up; i >= down; i--) {
                answer[i][left] = count++;
            }
            left++;
        }

        return answer;
    }

    public static int[][] solution2(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int x = 0, y = 0;
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        int direction = 0;

        while (num <= n * n) {
            answer[x][y] = num++;

            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n || answer[nx][ny] != 0) {
                direction = (direction + 1) % 4; //범위 밖에 나갔을 때 방향전환
                nx = x + dx[direction];
                ny = y + dy[direction];
            }
            x = nx;
            y = ny;
        }

        return answer;
    }

    public static int[][] solution3(int n) {
        int[][] answer = new int[n][n];
        int num = 1;
        int start = 0;
        int end = n;

        while (num <= n * n) {
            //->
            for (int j = start; j < end; j++)
                answer[start][j] = num++;
            //v
            for (int i = start + 1; i < end; i++)
                answer[i][end - 1] = num++;
            //<
            for (int j= end - 2; j >= start; j--)
                answer[end - 1][j] = num++;
            //^
            for (int i= end - 2; i > start; i--)
                answer[i][start] = num++;

            start++;
            end--;
        }

        return answer;
    }
}