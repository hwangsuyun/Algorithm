package programmers.level0;

// 피자 나눠 먹기 (1)
public class Solution86 {
    public static void main(String[] args) {
        //int n = 7; // 1
        //int n = 1; // 1
        int n = 15; // 3

        if (n < 1 || n > 100) return;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        return n % 7 == 0 ? n / 7 : n / 7 + 1;
    }
}