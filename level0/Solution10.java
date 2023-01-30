package programmers.level0;

// 제곱수 판별하기
public class Solution10 {
    public static void main(String[] args) {
        //int n = 144; // 1
        int n = 976; // 2

        if (n < 1 || n > 1000000) return;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        for (int i = 1; i < n; i++) {
            if (i * i == n) return 1;
        }
        return 2;
    }
}
