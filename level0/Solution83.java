package programmers.level0;

import java.util.Arrays;

// 배열의 평균값
public class Solution83 {
    public static void main(String[] args) {
        //int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // 5.5
        int[] numbers = {89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99}; // 94.0

        if (numbers.length < 1 || numbers.length > 100) return;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > 1000) return;
        }

        System.out.println(solution(numbers));
    }

    public static double solution(int[] numbers) {
        return Arrays.stream(numbers).sum() / (double) numbers.length;
    }
}