package solution1;

// 노란불 신호등
public class Solution86_1 {
    public static void main(String[] args) {
        //int[][] signals = {{2, 1, 2}, {5, 1, 1}};
        // 13
        //int[][] signals = {{2, 3, 2}, {3, 1, 3}, {2, 1, 1}};
        // 11
        int[][] signals = {{3, 3, 3}, {5, 4, 2}, {2, 1, 2}};
        // 193
        //int[][] signals = {{1, 1, 4}, {2, 1, 3}, {3, 1, 2}, {4, 1, 1}};
        // -1
        System.out.println(solution(signals));
    }

    private static int solution(int[][] signals) {
        int n = signals.length;
        int lcm = 1;
        for (int[] s : signals) {
            int cycle = s[0] + s[1] + s[2];
            lcm = lcm(lcm, cycle);
        }

        for (int t = 1; t <= lcm; t++) {
            boolean ok = true;
            for (int[] s : signals) {
                int g = s[0], y = s[1], r = s[2];
                int cycle = g + y + r;
                int pos = (t - 1) % cycle;
                if (!(pos >= g && pos < g + y)) {
                    ok = false;
                    break;
                }
            }
            if (ok) return t;
        }
        return -1;
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
}