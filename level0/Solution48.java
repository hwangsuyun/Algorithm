package programmers.level0;

// 직사각형 넓이 구하기
public class Solution48 {
    public static void main(String[] args) {
        //int[][] dots = {{1, 1}, {2, 1}, {2, 2}, {1, 2}}; // 1
        int[][] dots = {{-1, -1}, {1, 1}, {1, -1}, {-1, 1}}; // 4

        if (dots.length != 4) return;
        for (int i = 0; i < dots.length; i++) {
            if (dots[i].length != 2) return;
            for (int j = 0; j < dots[i].length; j++) {
                if (dots[i][j] < -256 || dots[i][j] > 256) return;
            }
        }

        System.out.println(solution(dots));
    }

    public static int solution(int[][] dots) {
        int minWidth = dots[0][0], maxWidth = dots[0][0];
        int minHeight = dots[0][1], maxHeight = dots[0][1];
        for (int i = 0; i < dots.length; i++) {
            if (dots[i][0] < minWidth) minWidth = dots[i][0];
            if (dots[i][0] > maxWidth) maxWidth = dots[i][0];
            if (dots[i][1] < minHeight) minHeight = dots[i][1];
            if (dots[i][1] > maxHeight) maxHeight = dots[i][1];
        }
        return (maxWidth - minWidth) * (maxHeight - minHeight);
    }
}