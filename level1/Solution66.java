package programmers.level1;

// 콜라 문제
public class Solution66 {
    public static void main(String[] args) {
        //int a = 2;
        //int b = 1;
        //int n = 20;
        // 19
        //int a = 3;
        //int b = 1;
        //int n = 20;
        // 9
        //int a = 3;
        //int b = 2;
        //int n = 10;
        // 16
        int a = 3;
        int b = 2;
        int n = 20;
        // 36

        if (a < 1 || a > 1000000) return;
        if (b < 1 || b > 1000000) return;
        if (n < 1 || n > 1000000) return;

        System.out.println(solution(a, b, n));
    }

    public static int solution(int a, int b, int n) {
        int divide = 0, answer = 0;
        while (n >= a) {
            divide = n / a;
            n = n - (a * divide) + (divide * b);
            answer += divide * b;
        }
        return answer;
    }
}