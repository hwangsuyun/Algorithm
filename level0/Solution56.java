package programmers.level0;

import java.util.Arrays;

// 최댓값 만들기(1)
public class Solution56 {
    public static void main(String[] args) {
        //int[] numbers = {1, 2, 3, 4, 5}; // 20
        int[] numbers = {0, 31, 24, 10, 1, 9}; // 744

        if (numbers.length < 2 || numbers.length > 100) return;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > 10000) return;
        }

        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int[] array = Arrays.stream(numbers).sorted().toArray();
        return array[numbers.length - 1] * array[numbers.length - 2];
    }
}