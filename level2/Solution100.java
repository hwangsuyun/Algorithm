package com.example.algorithm.level2;

import java.util.HashMap;
import java.util.Map;

// 쿼드압축 후 개수 세기
public class Solution100 {
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
        Map<Integer, Integer> map = new HashMap<>();
        int zero, one;
        if (check(arr, map)) {
            compress(new int[]{0, arr.length / 2, 0, arr.length / 2}, arr, map);
            compress(new int[]{0, arr.length / 2, arr.length / 2, arr.length}, arr, map);
            compress(new int[]{arr.length / 2, arr.length, 0, arr.length / 2}, arr, map);
            compress(new int[]{arr.length / 2, arr.length, arr.length / 2, arr.length}, arr, map);
            zero = map.get(0) / 4;
            one = map.get(1) / 4;
        } else {
            zero = map.getOrDefault(0, 0) == 0 ? 0 : map.get(0);
            one = map.getOrDefault(1, 0) == 0 ? 0 : map.get(1);
        }
        return new int[] {zero, one};
    }

    private static void compress(int[] position, int[][] arr, Map<Integer, Integer> map) {
        if (arr.length == 1) {
            return;
        }

        int rs = position[0];
        int re = position[1];
        int cs = position[2];
        int ce = position[3];

        int[][] array = new int[arr.length / 2][arr.length / 2];
        for (int i = rs, x = 0; i < re; i++, x++) {
            for (int j = cs, y = 0; j < ce; j++, y++) {
                array[x][y] = arr[i][j];
            }
        }

        if (check(array, map)) compress(new int[]{0, array.length / 2, 0, array.length / 2}, array, map);
        if (check(array, map)) compress(new int[]{0, array.length / 2, array.length / 2, array.length}, array, map);
        if (check(array, map)) compress(new int[]{array.length / 2, array.length, 0, array.length / 2}, array, map);
        if (check(array, map)) compress(new int[]{array.length / 2, array.length, array.length / 2, array.length}, array, map);
    }

    private static boolean check(int[][] array, Map<Integer, Integer> map) {
        int zero = 0, one = 0;
        for (int[] aaa : array) {
            for (int i : aaa) {
                if (i == 0) zero++;
                if (i == 1) one++;
            }
        }
        if (zero == array.length * array.length) {
            map.put(0, map.getOrDefault(0, 0) + 1);
            return false;
        } else if (one == array.length * array.length) {
            map.put(1, map.getOrDefault(1, 0) + 1);
            return false;
        }
        return true;
    }
}