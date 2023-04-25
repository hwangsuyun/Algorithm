package programmers.level0;

// 모스부호(1)
public class Solution66 {
    public static void main(String[] args) {
        //int hp = 23; // 5
        //int hp = 24; // 6
        int hp = 999; // 201

        if (hp < 0 || hp > 1000) return;

        System.out.println(solution(hp));
    }

    public static int solution(int hp) {
        int answer = hp / 5;
        answer += hp % 5 / 3;
        answer += hp % 5 % 3 / 1;
        return answer;
    }
}