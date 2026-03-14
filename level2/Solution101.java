package com.example.algorithm.level2;

import java.util.stream.IntStream;

// 삼각 달팽이
public class Solution101 {
    public static void main(String[] args) {
        //int n = 4; // [1,2,9,3,10,8,4,5,6,7]
        //int n = 5; //	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
        //int n = 6; //	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
        //int n = 1; // [1]
        //int n = 2; // [1,2,3]
        int n = 100;

        int[] result = solution(n);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int n) {
        int count = IntStream.rangeClosed(1, n).sum();
        int[] answer = new int[count];
        int[][] array = new int[n][n];
        int[] position = {0, n, 0, 0};
        int start = 0, index = 0;

        while (n >= 1) {
            start = getTriangle(start + 1, n, position, array);
            position[0] += 2;
            position[1] -= 1;
            position[2] += 1;
            position[3] -= 1;
            n -= 3;
        }

        for (int[] arr : array) {
            for (int i : arr) {
                if (i != 0) {
                    answer[index++] = i;
                }
            }
        }
        return answer;
    }

    private static int getTriangle(int start, int n, int[] position, int[][] array) {
        int max = start + (n - 1) * 2 + (n - 2);
        int end = max;
        for (int i = position[0]; i < position[1]; i++) {
            for (int j = position[2]; j <= i + position[3]; j++) {
                if (j == position[2]) {
                    array[i][j] = start;
                    start++;
                } else if (j == i + position[3]) {
                    array[i][j] = end;
                    end--;
                } else if (i == position[1] - 1) {
                    array[i][j] = start;
                    start++;
                }
            }
        }
        return max;
    }
}