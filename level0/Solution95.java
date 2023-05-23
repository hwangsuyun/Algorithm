package programmers.level0;

// 두 수의 나눗셈
public class Solution95 {
    public static void main(String[] args) {
        //int num1 = 10;
        //int num2 = 5;
        // 2
        int num1 = 7;
        int num2 = 2;
        // 3

        if (num1 <= 0 || num1 > 100) return;
        if (num2 <= 0 || num2 > 100) return;

        System.out.println(solution(num1, num2));
    }

    public static int solution(int num1, int num2) {
        return num1 / num2;
    }
}