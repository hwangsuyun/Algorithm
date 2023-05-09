package programmers.level0;

// 아이스 아메리카노
public class Solution81 {
    public static void main(String[] args) {
        //int money = 5500; // [1, 0]
        int money = 15000; // [2, 4000]

        if (money <= 0 || money > 1000000) return;

        int[] result = solution(money);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int money) {
        int[] answer = new int[2];
        answer[0] = money / 5500;
        answer[1] = money - answer[0] * 5500;
        return answer;
    }
}