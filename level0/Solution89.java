package programmers.level0;

import java.util.Arrays;

// 중앙값 구하기
public class Solution89 {
    public static void main(String[] args) {
        //int[] array = {1, 2, 7, 10, 11}; // 7
        int[] array = {9, -1, 0}; // 0

        if (array.length <= 0 || array.length >= 100) return;
        for (int i = 0; i < array.length; i++) {
            if (array[i] <= -1000 || array[i] >= 1000) return;
        }

        System.out.println(solution(array));
    }

    public static int solution(int[] array) {
        Arrays.sort(array);
        return array[array.length / 2];
    }
}