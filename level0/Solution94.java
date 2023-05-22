package programmers.level0;

// 두 수의 나눗셈
public class Solution94 {
    public static void main(String[] args) {
        //int num1 = 3;
        //int num2 = 2;
        // 1500
        //int num1 = 7;
        //int num2 = 3;
        // 2333
        int num1 = 1;
        int num2 = 16;
        // 62

        if (num1 <= 0 || num1 > 100) return;
        if (num2 <= 0 || num2 > 100) return;

        System.out.println(solution(num1, num2));
    }

    public static int solution(int num1, int num2) {
        return (int) ((double) num1 / (double) num2 * 1000);
    }
}