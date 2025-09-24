package com.example.algorithm.level2;

import java.util.ArrayList;
import java.util.List;

// 피로도
public class Solution89 {
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};
        // 3

        System.out.println(solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        int[] arr = new int[dungeons.length];
        List<int[]> list = new ArrayList<>();

        // 1. dungeons 길이만큼의 배열을 생성하고 0, 1, 2 ... 값을 채운다.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // 2. 순열을 이용하여 모든 경우의 수를 구한다.
        // 2.1 ex) {0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,1,0},{2,0,1}
        permutation(arr, 0, arr.length, arr.length, list);

        // 3. list 를 순회하면서 피로도를 계산하고 가장 큰 수를 반환한다.
        return calculate(list, k, dungeons);
    }

    private static void permutation(int[] arr, int depth, int n, int r, List<int[]> list) {
        if (depth == r) {
            copy(arr, r, list);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r, list);
            swap(arr, depth, i);
        }
    }

    private static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    private static void copy(int[] arr, int r, List<int[]> list) {
        int[] temp = new int[arr.length];
        System.arraycopy(arr, 0, temp, 0, r);
        list.add(temp);
    }

    private static int calculate(List<int[]> list, int k, int[][] dungeons) {
        int result = 0;
        for (int[] a : list) {
            int count = 0;
            int hp = k;
            for (int i : a) {
                if (hp < dungeons[i][0]) break;
                hp -= dungeons[i][1];
                count++;
            }
            if (result < count) result = count;
        }
        return result;
    }
}