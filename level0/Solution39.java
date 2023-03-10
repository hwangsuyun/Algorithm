package programmers.level0;

// 평행
public class Solution39 {
    public static void main(String[] args) {
        //int[][] dot = {{1, 4}, {9, 2}, {3, 8}, {11, 6}}; // 1
        int[][] dot = {{3, 5}, {4, 1}, {2, 4}, {5, 10}}; // 0

        if (dot.length != 4) return;
        for (int i = 0; i < dot.length; i++) {
            for (int j = 0; j < dot[i].length; j++) {
                if (dot[i][j] < 0 || dot[i][j] > 100) return;
            }
        }

        System.out.println(solution(dot));
    }

    public static int solution(int[][] dots) {
        int answer = 0;
        double[] locate1 = new double[2];
        double[] locate2 = new double[2];

        for (int i = 0; i < dots.length - 1; i++) {
            locate1[0] = (double) dots[i + 1][0] - (double) dots[0][0];
            locate1[1] = (double) dots[i + 1][1] - (double) dots[0][1];
            if (i == 0 || i == 1) {
                locate2[0] = (double) dots[3][0] - (double) dots[2 - i][0];
                locate2[1] = (double) dots[3][1] - (double) dots[2 - i][1];
            } else {
                locate2[0] = (double) dots[2][0] - (double) dots[1][0];
                locate2[1] = (double) dots[2][1] - (double) dots[1][1];
            }

            if (locate1[0] / locate2[0] == locate1[1] / locate2[1]) return 1;
            if (locate2[0] / locate1[0] == locate2[1] / locate1[1]) return 1;
        }
        return answer;
    }
}
