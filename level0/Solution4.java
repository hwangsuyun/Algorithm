package programmers.level0;

// 종이 자르기
public class Solution4 {
    public static void main(String[] args) {
        //int M = 2, N = 2; // 3
        //int M = 2, N = 5; // 9
        int M = 1, N = 1; // 0

        if (M < 0) return;
        if (N > 100) return;

        System.out.println(solution(M, N));
    }

    public static int solution(int M, int N) {
        return M * N - 1;
    }
}
