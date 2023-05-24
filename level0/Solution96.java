package programmers.level0;

// 두 수의 곱
public class Solution96 {
    public static void main(String[] args) {
        //int num1 = 3;
        //int num2 = 4;
        // 12
        int num1 = 27;
        int num2 = 19;
        // 513

        if (num1 < 0 || num1 > 100) return;
        if (num2 < 0 || num2 > 100) return;

        System.out.println(solution(num1, num2));
    }

    public static int solution(int num1, int num2) {
        return num1 * num2;
    }
}