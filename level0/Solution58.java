package programmers.level0;

import java.util.Arrays;

// 주사위의 개수
public class Solution58 {
    public static void main(String[] args) {
        //int[] box = {1, 1, 1};
        //int n = 1;
        // 1
        int[] box = {10, 8, 6};
        int n = 3;
        // 12

        if (box.length != 3) return;
        for (int i = 0; i < box.length; i++) {
            if (box[i] < 1 || box[i] > 100) return;
            if (box[i] < n) return;
        }
        if (n < 1 || n > 50) return;

        System.out.println(solution(box, n));
    }

    public static int solution(int[] box, int n) {
        int answer = 1;
        for (int i : box) {
            answer *= i / n;
        }
        return answer;
    }
}