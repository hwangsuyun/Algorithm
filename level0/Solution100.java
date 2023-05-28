package programmers.level0;

import java.util.Arrays;

// 중복된 숫자 개수
public class Solution100 {
    public static void main(String[] args) {
        //int[] array = {1, 1, 2, 3, 4, 5};
        //int n = 1;
        // 2
        int[] array = {0, 2, 3, 4};
        int n = 1;
        // 0

        if (array.length < 1 || array.length > 100) return;
        for (int i = 0; i <array.length; i++) {
            if (array[i] < 0 || array[i] > 1000) return;
        }
        if (n < 0 || n > 1000) return;

        System.out.println(solution(array, n));
    }

    public static int solution(int[] array, int n) {
        return (int) Arrays.stream(array).filter(i -> i == n).count();
    }
}