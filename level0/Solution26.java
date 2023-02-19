package programmers.level0;

import java.util.Arrays;

// 369게임
public class Solution26 {
    public static void main(String[] args) {
        //int order = 3; // 1
        //int order = 29423; // 2
        int order = 0; // 0

        System.out.println(solution(order));
    }

    public static int solution(int order) {
        return Long.valueOf(Arrays.stream(String.valueOf(order).split(""))
                .filter(str -> Integer.parseInt(str) != 0 && Integer.parseInt(str) % 3 == 0)
                .count()).intValue();
    }
}
