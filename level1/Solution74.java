package programmers.level1;

// 부족한 금액 계산하기
public class Solution74 {
    public static void main(String[] args) {
        int price = 3;
        int money = 20;
        int count = 4;
        // 10

        System.out.println(solution(price, money, count));
    }

    public static long solution(int price, int money, int count) {
        long answer = money;
        long sum = 0;
        for (int i = 1; i <= count; i++) {
            sum += i * price;
        }
        return answer - sum > 0 ? 0 : Math.abs(answer - sum);
    }
}