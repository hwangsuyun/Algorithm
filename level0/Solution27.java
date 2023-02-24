package programmers.level0;

import java.util.Arrays;

// 가까운 수
public class Solution27 {
    public static void main(String[] args) {
        int[] array = {3, 10, 28};
        int n = 20;
        // 28
        //int[] array = {10, 11, 12};
        //int n = 13;
        // 12

        if (array.length < 1 || array.length > 100) return;
        for (int arr : array) {
            if (arr < 1 || arr > 100) return;
        }
        if (n < 1 || n > 100) return;

        System.out.println(solution(array, n));
    }

    public static int solution(int[] array, int n) {
        array = Arrays.stream(array).sorted().toArray();
        int answer = n, ret = 0;
        for (int arr : array) {
            if (Math.abs(arr - n) < answer) {
                answer = Math.abs(arr - n);
                ret = arr;
            }
        }
        return ret;
    }
}
