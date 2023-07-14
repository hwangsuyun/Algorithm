package programmers.level1;

// 최소직사각형
public class Solution72 {
    public static void main(String[] args) {
        /*
        명함번호 가로길이 세로길이
         1	    60	   50
         2	    30     70
         3	    60	   30
         4	    80	   40
         */
        //int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}}; // 4000
        //int[][] sizes = {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}}; // 120
        int[][] sizes = {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}}; // 133

        if (sizes.length < 1 || sizes.length > 10000) return;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] < 1 || sizes[i][0] > 1000) return;
            if (sizes[i][1] < 1 || sizes[i][1] > 1000) return;
        }

        System.out.println(solution(sizes));
    }

    public static int solution(int[][] sizes) {
        int width = Math.max(sizes[0][0], sizes[0][1]);
        int height = Math.min(sizes[0][0], sizes[0][1]);

        for (int i = 0; i < sizes.length; i++) {
            for (int j = i + 1; j <= sizes.length - 1; j++) {
                if (width < Math.max(sizes[j][0], sizes[j][1])) {
                    width = Math.max(sizes[j][0], sizes[j][1]);
                }
                if (height < Math.min(sizes[j][0], sizes[j][1])) {
                    height = Math.min(sizes[j][0], sizes[j][1]);
                }
            }
        }
        return width * height;
    }
}