package programmers.level2;

// 당구 연습
public class Solution54 {
    public static void main(String[] args) {
        int m = 10;
        int n = 10;
        int startX = 3;
        int startY = 7;
        int[][] balls = {{7, 7}, {2, 7}, {7, 3}};
        // [52, 37, 116]
        //int m = 10;
        //int n = 10;
        //int startX = 5;
        //int startY = 9;
        //int[][] balls = {{5, 8}};
        // [9]
        //int m = 10;
        //int n = 10;
        //int startX = 5;
        //int startY = 9;
        //int[][] balls = {{5, 8}};
        // [9]

        /*
        if (m < 3 || m > n) return;
        if (n < m || n > 1000) return;
        if (startX < 0 || startX > m) return;
        if (startY < 0 || startY > n) return;
        if (balls.length < 2 || balls.length > 1000) return;
        for (int i = 0; i < balls.length; i++) {
            if (balls[i][0] < 0 || balls[i][0] > m) return;
            if (balls[i][1] < 0 || balls[i][1] > n) return;
        }
        */
        int[] result = solution(m, n, startX, startY, balls);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        int min = Integer.MAX_VALUE;

        int[] locate1 = new int[] {-startX, startY};
        int[] locate2 = new int[] {startX, -startY};;
        int[] locate3 = new int[] {m + (m - startX), startY};;
        int[] locate4 = new int[] {startX, n + (n - startY)};;

        for (int i = 0; i < balls.length; i++) {
            if (startY != balls[i][1] || startX < balls[i][0]) {
                min = Math.min(min, (int) Math.pow(Math.abs(locate1[0] - balls[i][0]), 2)
                        + (int) Math.pow(Math.abs(locate1[1] - balls[i][1]), 2));
            }

            if (startX != balls[i][0] || startY < balls[i][1]) {
                min = Math.min(min, (int) Math.pow(Math.abs(locate2[0] - balls[i][0]), 2)
                        + (int) Math.pow(Math.abs(locate2[1] - balls[i][1]), 2));
            }

            if (startY != balls[i][1] || startX > balls[i][0]) {
                min = Math.min(min, (int) Math.pow(Math.abs(locate3[0] - balls[i][0]), 2)
                        + (int) Math.pow(Math.abs(locate3[1] - balls[i][1]), 2));
            }

            if (startX != balls[i][0] || startY > balls[i][1]) {
                min = Math.min(min, (int) Math.pow(Math.abs(locate4[0] - balls[i][0]), 2)
                        + (int) Math.pow(Math.abs(locate4[1] - balls[i][1]), 2));
            }

            answer[i] = min;
            min = Integer.MAX_VALUE;
        }

        return answer;
    }
}