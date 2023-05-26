package programmers.level0;

// 두 수의 합
public class Solution98 {
    public static void main(String[] args) {
        //int num1 = 2;
        //int num2 = 3;
        // 5
        int num1 = 100;
        int num2 = 2;
        // 102

        if (num1 < -50000 || num1 > 50000) return;
        if (num2 < -50000 || num2 > 50000) return;

        System.out.println(solution(num1, num2));
    }

    public static int solution(int num1, int num2) {
        return num1 + num2;
    }
}