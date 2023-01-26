package programmers.level0;

import java.util.Arrays;

// 종이 자르기
public class Solution7 {
    public static void main(String[] args) {
        //int[] array = {7, 77, 17}; // 4
        int[] array = {10, 29}; // 0

        if (array.length < 1 || array.length > 100) return;
        for (int arr : array) {
            if (arr < 0 || arr > 100000) return;
        }

        System.out.println(solution(array));
    }

    public static int solution(int[] array) {
        String[] strArray = Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new);
        return Long.valueOf(
                Arrays.stream(strArray)
                        .mapToLong(str -> str.chars().filter(c -> c == '7').count())
                        .sum()).intValue();
    }
}
