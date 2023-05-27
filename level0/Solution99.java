package programmers.level0;

import java.util.Arrays;

// 머쓱이보다 키 큰 사람
public class Solution99 {
    public static void main(String[] args) {
        //int[] array = {149, 180, 192, 170};
        //int height = 167;
        // 3
        int[] array = {180, 120, 140};
        int height = 190;
        // 0

        if (array.length < 1 || array.length > 100) return;
        if (height < 1 || height > 200) return;
        for (int i = 0; i <array.length; i++) {
            if (array[i] < 1 || array[i] > 200) return;
        }

        System.out.println(solution(array, height));
    }

    public static int solution(int[] array, int height) {
        return (int) Arrays.stream(array).filter(i -> i > height).count();
    }
}