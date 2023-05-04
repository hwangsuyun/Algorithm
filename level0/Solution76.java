package programmers.level0;

import java.util.Arrays;

// 짝수 홀수 개수
public class Solution76 {
    public static void main(String[] args) {
        //int[] num_list = {1, 2, 3, 4, 5}; // [2, 3]
        int[] num_list = {1, 3, 5, 7}; // [0, 4]}

        if (num_list.length < 0 || num_list.length > 1000) return;
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] < 1 || num_list[i] > 100) return;
        }

        int[] result = solution(num_list);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int[] num_list) {
        int[] answer = new int[2];
        answer[0] = (int ) Arrays.stream(num_list).filter(i -> i % 2 == 0).count();
        answer[1] = (int ) Arrays.stream(num_list).filter(i -> i % 2 != 0).count();
        return answer;
    }
}