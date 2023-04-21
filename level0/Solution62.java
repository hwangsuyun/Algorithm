package programmers.level0;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 점의 위치 구하기
public class Solution62 {
    public static void main(String[] args) {
        //int[] dot = {2, 4}; // 1
        int[] dot = {-7, 9}; // 2

        if (dot.length != 2) return;
        for (int i = 0; i < dot.length; i++) {
            if (dot[i] < -500 || dot[i] > 500) return;
        }

        System.out.println(solution(dot));
    }

    public static int solution(int[] dot) {
        return (dot[0] >= 0 && dot[1] >= 0)
                ? 1 : (dot[0] < 0 && dot[1] >= 0)
                ? 2 : (dot[0] < 0 && dot[1] < 0)
                ? 3 : 4;
    }
}