package programmers.level0;

import java.util.Arrays;

// 배열 자르기
public class Solution70 {
    public static void main(String[] args) {
        //int[] numbers ={1, 2, 3, 4, 5};
        //int num1 = 1;
        //int num2 = 3;
        // [2, 3, 4]
        int[] numbers ={1, 3, 5};
        int num1 = 1;
        int num2 = 2;
        // [3, 5]

        if (numbers.length < 2 || numbers.length > 30) return;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > 1000) return;
        }
        if (num1 < 0 || num1 >= num2 || num1 >= numbers.length) return;
        if (num2 < 0 || num2 <= num1 || num2 >= numbers.length) return;
        if (numbers.length < 0 || numbers.length <= num1 || numbers.length <= num2) return;

        int[] result = solution(numbers, num1, num2);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int[] numbers, int num1, int num2) {
        return Arrays.copyOfRange(numbers, num1, num2 + 1);
    }
}