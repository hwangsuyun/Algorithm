package programmers.level2;

// 점 찍기
public class Solution67 {
    public static void main(String[] args) {
        //int k = 2;
        //int d = 4;
        // 6
        int k = 1;
        int d = 5;
        // 26

        if (k < 1 || k > 1000000) return;
        if (d < 1 || d > 1000000) return;

        System.out.println(solution(k, d));
    }

    public static long solution(int k, int d) {
        long answer = 0;
        for (int x = 0; x <= d; x += k) {
            long xx = (long) Math.pow(x, 2);
            long dd = (long) Math.pow(d, 2);
            int result = (int) Math.sqrt(dd - xx);
            int yy = result / k;
            yy++;
            answer += yy;
        }
        return answer;
    }
}