package com.example.algorithm.level2;

// 삼각 달팽이
public class Solution101_2 {
    public static void main(String[] args) {
        int n = 4; // [1,2,9,3,10,8,4,5,6,7]
        //int n = 5; //	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
        //int n = 6; //	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
        //int n = 1; // [1]
        //int n = 2; // [1,2,3]

        int[] result = solution(n);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int n) {
        int[] answer = new int[(n * (n + 1)) / 2];
        int[][] matrix = new int[n][n];

        int x = -1, y = 0;
        int num = 1;

        for (int i = 0; i < n; ++i) {
            for (int j = i; j < n; ++j) {
                if (i % 3 == 0) {
                    ++x;
                } else if (i % 3 == 1) {
                    ++y;
                } else if (i % 3 == 2) {
                    --x;
                    --y;
                }
                matrix[x][y] = num++;
            }
        }

        int k = 0;
        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) break;
                answer[k++] = matrix[i][j];
            }
        }

        return answer;
    }
}