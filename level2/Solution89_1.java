package com.example.algorithm.level2;

// 피로도
public class Solution89_1 {
    static int answer = 0;
    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};
        // 3

        System.out.println(solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        int[] arr = new int[dungeons.length];

        // 1. dungeons 길이만큼의 배열을 생성하고 0, 1, 2 ... 값을 채운다.
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        // 2. 순열을 이용하여 모든 경우의 수를 구한다.
        // 2.1 ex) {0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,1,0},{2,0,1}
        // 3. arr 을 순회하면서 피로도를 계산하고 가장 큰 수를 반환한다.
        permutation(arr, 0, arr.length, k, dungeons);
        return answer;
    }

    private static void permutation(int[] arr, int depth, int n, int k, int[][] dungeons) {
        if (depth == n) {
            answer = Math.max(calculate(arr, k, dungeons), answer);
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, k, dungeons);
            swap(arr, depth, i);
        }
    }

    private static void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }

    private static int calculate(int[] arr, int k, int[][] dungeons) {
        int count = 0;
        int hp = k;
        for (int i = 0; i < arr.length; i++) {
            if (hp < dungeons[arr[i]][0]) return count;
            hp -= dungeons[arr[i]][1];
            count++;
        }
        return count;
    }
}