package programmers.level0;

import java.util.Arrays;

// 삼각형의 완성조건 (1)
public class Solution28 {
    public static void main(String[] args) {
        //int[] sides = {1, 2, 3}; // 2
        //int[] sides = {3, 6, 2}; // 2
        int[] sides = {199, 72, 222}; // 1

        if (sides.length != 3) return;
        for (int i : sides) {
            if (i < 1 || i > 1000) return;
        }

        System.out.println(solution(sides));
    }

    public static int solution(int[] sides) {
        Arrays.sort(sides);
        return sides[0] + sides[1] > sides[2] ? 1 : 2;
    }
}
