package programmers.level0;

// 숫자 비교하기
public class Solution93 {
    public static void main(String[] args) {
        //int num1 = 2;
        //int num2 = 3;
        // -1
        //int num1 = 11;
        //int num2 = 11;
        // 1
        int num1 = 7;
        int num2 = 99;
        // -1

        if (num1 < 0 || num1 > 10000) return;
        if (num2 < 0 || num2 > 10000) return;

        System.out.println(solution(num1, num2));
    }

    public static int solution(int num1, int num2) {
        return num1 == num2 ? 1 : -1;
    }
}