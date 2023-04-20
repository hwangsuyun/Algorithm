package programmers.level0;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 2차원으로 만들기
public class Solution61 {
    public static void main(String[] args) {
        int[] num_list = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = 2;
        // [[1, 2], [3, 4], [5, 6], [7, 8]]
        //int[] num_list = {100, 95, 2, 4, 5, 6, 18, 33, 948};
        //int n = 3;
        // [[100, 95, 2], [4, 5, 6], [18, 33, 948]]

        if (num_list.length <= 0 || num_list.length >= 150) return;
        if (n < 2 || n >= num_list.length) return;

        solution(num_list, n);
    }

    public static int[][] solution(int[] num_list, int n) {
        Integer[] boxed = Arrays.stream(num_list).boxed().toArray(Integer[]::new);
        Queue<Integer> queue = new LinkedList<>(Arrays.asList(boxed));
        int[][] answer = new int[num_list.length / n][n];
        int index = 0, k = 0;

        while (!queue.isEmpty()) {
            while (k < n) {
                answer[index][k] = queue.poll();
                k++;
            }
            index++;
            k = 0;
        }
        return answer;
    }
}