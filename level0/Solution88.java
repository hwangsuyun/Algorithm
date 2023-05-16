package programmers.level0;

import java.util.stream.IntStream;

// 최빈값 구하기
public class Solution88 {
    public static void main(String[] args) {
        //int[] array = {1, 2, 3, 3, 3, 4}; // 3
        //int[] array = {1, 1, 2, 2}; // -1
        //int[] array = {1}; // 1
        //int[] array = {1, 2}; // -1
        int[] array = {1, 1, 2, 2, 3, 3, 3}; // 3

        if (array.length <= 0 || array.length >= 100) return;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0 || array[i] >= 1000) return;
        }

        System.out.println(solution(array));
    }

    public static int solution(int[] array) {
        if (array.length == 1) return array[0];

        int count = 0, answer = 0, index = -1;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                if (array[i] == array[j]) {
                    count++;
                }
            }

            if (answer < count) {
                answer = count;
                index = array[i];
            } else if (answer == count) {
                index = -1;
            }

            count = 0;
        }

        return index;
    }
}