package programmers.level0;

import java.util.Arrays;

// 배열 두 배 만들기
public class Solution91 {
    public static void main(String[] args) {
        //int[] numbers = {1, 2, 3, 4, 5}; // [2, 4, 6, 8, 10]
        int[] numbers = {1, 2, 100, -99, 1, 2, 3}; // [2, 4, 200, -198, 2, 4, 6]

        if (numbers.length < 1 || numbers.length > 1000) return;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < -10000 || numbers[i] > 10000) return;
        }

        int[] result = solution(numbers);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int[] numbers) {
        return Arrays.stream(numbers).map(i -> i * 2).toArray();
    }
}