package com.example.algorithm.level2;

// 쿼드압축 후 개수 세기
public class Solution100_1 {
    public static int answer[]={0,0};
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 0},
                       {1, 0, 0, 0},
                       {1, 0, 0, 1},
                       {1, 1, 1, 1}};
        // [4,9]
        /*
        int[][] arr = {{1, 1, 1, 1, 1, 1, 1, 1},
                       {0, 1, 1, 1, 1, 1, 1, 1},
                       {0, 0, 0, 0, 1, 1, 1, 1},
                       {0, 1, 0, 0, 1, 1, 1, 1},
                       {0, 0, 0, 0, 0, 0, 1, 1},
                       {0, 0, 0, 0, 0, 0, 0, 1},
                       {0, 0, 0, 0, 1, 0, 0, 1},
                       {0, 0, 0, 0, 1, 1, 1, 1}};
         */
        // [10,15]
        //int[][] arr = {{0, 0}, {0, 0}};
        // [1,0]

        int[] result = solution(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[][] arr) {
        int n = arr.length;
        int x = 0;
        int y = 0;
        solve(arr, x, y, n);
        return answer;
    }

    public static void solve(int[][] arr, int x, int y, int n) {
        int first = arr[x][y];
        boolean check = true;
        for (int i = x; i < x + n; i++) {
            for (int k = y; k < y + n; k++) {
                if (arr[i][k] != first) {
                    check = false;
                    break;
                }
            }
        }
        if (check) {
            answer[first] += 1;
        } else {
            int nxt_n = (Integer) n / 2;
            solve(arr,x + nxt_n, y, nxt_n);
            solve(arr, x,y + nxt_n, nxt_n);
            solve(arr, x, y, nxt_n);
            solve(arr,x + nxt_n,y + nxt_n, nxt_n);
        }
    }
}