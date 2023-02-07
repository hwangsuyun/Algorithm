package programmers.level0;

import java.util.Arrays;
import java.util.stream.IntStream;

// 가장 큰 수 찾기
public class Solution18 {
    public static void main(String[] args) {
        //int[] array = {1, 8, 3}; // [8, 1]
        int[] array = {9, 10, 11, 8}; // [11, 2]

        if (array.length < 1 || array.length > 100) return;
        for (int a : array) {
            if (a < 0 || a > 1000) return;
        }

        solution(array);
    }

    public static int[] solution(int[] array) {
        int[] answer = new int[2];
        answer[0] = Arrays.stream(array).max().getAsInt();
        answer[1] = IntStream.range(0, array.length)
                             .filter(i -> answer[0] == array[i])
                             .findFirst()
                             .orElse(-1);
        System.out.println(answer[0] + ", " + answer[1]);
        return answer;
    }
}
