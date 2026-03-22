package com.example.algorithm.level2;

// 삼각 달팽이
public class Solution101_1 {
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
        boolean[][] checked = new boolean[n][n];
        int[][] position = new int[n][n];
        int count = getMovingCount(n);
        move(checked, position, count, n);
        return getTrace(position, count);
    }

    private static int getMovingCount(int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                count++;
            }
        }
        return count;
    }

    private static void move(boolean[][] checked, int[][] position, int count, int n) {
        int row = 0, column = 0, number = 1, floor = 1, wall = 1;
        while (number <= count) {
            // 1.down
            while (true) {
                if (row < n - floor && !checked[row][column]) {
                    checked[row][column] = true;
                    position[row][column] = number;
                    row++;
                    number++;
                } else {
                    break;
                }
            }
            if (number == count) {
                position[row][column] = number;
                break;
            }

            // 2.right
            while (true) {
                if (column < n - wall && !checked[row][column]) {
                    checked[row][column] = true;
                    position[row][column] = number;
                    column++;
                    number++;
                } else {
                    break;
                }
            }
            if (number == count) {
                position[row][column] = number;
                break;
            }

            // 3. up + left
            while (true) {
                if (row > floor && !checked[row][column]) {
                    checked[row][column] = true;
                    position[row][column] = number;
                    row--;
                    column--;
                    number++;
                } else {
                    break;
                }
            }
            if (number == count) {
                position[row][column] = number;
                break;
            }

            floor++;
            wall += 2;
        }
    }

    private static int[] getTrace(int[][] position, int count) {
        int[] answer = new int[count];
        int index = 0;
        for (int[] point : position) {
            for (int po : point) {
                if (po != 0) {
                    answer[index++] = po;
                }
            }
        }
        return answer;
    }
}