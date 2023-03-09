package programmers.level0;

// 유한소수 판별하기
public class Solution37 {
    public static void main(String[] args) {
        //int a = 7, b = 20; // 1
        //int a = 11, b = 22; // 1
        int a = 12, b = 21; // 2
        //int a = 1, b = 30; // 2

        if (a < 0 || a > 1000) return;
        if (b < 0 || b > 1000) return;

        System.out.println(solution(a, b));
    }

    public static int solution(int a, int b) {
        if (a % b == 0) return 1;

        int count = 0;
        for (int i = b; i > 2; i--) {
            if (b % i == 0 && a % i == 0) {
                a /= i;
                b /= i;
                break;
            }
        }

        for (int i = 2; i <= b; i++) {
            if (b % i == 0) {
                if (i % 2 == 0 || i % 5 == 0) count++;
                else return 2;
            }
        }

        return count = count >= 1 ? 1 : 2;
    }
}
