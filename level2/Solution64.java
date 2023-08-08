package programmers.level2;

import java.util.HashMap;
import java.util.Map;

// 유사 칸토어 비트열
public class Solution64 {
    public static void main(String[] args) {
        int n = 2;
        long l = 4;
        long r = 17;
        // 8
        //int n = 3;
        //long l = 1;
        //long r = 125;
        // 64

        if (n < 1 || n > 20) return;
        //if (l < 1 || l > 5 * n) return;
        //if (l < 1 || l > 5 * n) return;
        if (r < l || r > l + 10000000) return;

        System.out.println(solution(n, l, r));
    }

    public static int solution(int n, long l, long r) {
        // n == 0 -> 1
        // n == 1 -> 11011
        // n == 2 -> 11011 11011 00000 11011 11011
        // n == 3 -> 11011 11011 00000 11011 11011 11011 11011 00000 11011 11011 00000 00000 00000 00000 00000
        //           11011 11011 00000 11011 11011 11011 11011 00000 11011 11011
        int answer = 0;
        for (l--; l < r; l++) {
            if (check(l)) answer++;
        }
        return answer;
    }

    private static boolean check(long l) {
        if (l < 5 && l != 2) return true;
        if (l % 5 == 2) return false;

        return check(l / 5);
    }

}