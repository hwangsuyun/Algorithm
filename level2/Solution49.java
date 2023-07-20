package programmers.level2;

import java.util.Arrays;

// 두 원 사이의 정수 쌍
public class Solution49 {
    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;
        // 20

        if (r1 < 1 || r1 > r2) return;
        if (r2 < r1 || r2 > 1000000) return;

        System.out.println(solution(r1, r2));
    }

    public static long solution(int r1, int r2) {
        long answer = 0;
        long side = 0;
        long r1x = (long) Math.pow(r1, 2);
        long r2x = (long) Math.pow(r2, 2);

        for(long i = 0; i<= r2; i++) {
            long y2 = (long) Math.sqrt(r2x - (long) Math.pow(i, 2));
            long y1 = (long) Math.sqrt(r1x - (long) Math.pow(i, 2));

            if (Math.sqrt((r1x - Math.pow(i, 2))) % 1 == 0) {
                side++;
            }
            answer += (y2 - y1) * 4;
        }
        answer += side * 4 - 4;
        return answer;
    }
}