package programmers.level1;

// 기사단원의 무기
public class Solution61 {
    public static void main(String[] args) {
        //int number = 5;
        //int limit = 3;
        //int power = 2;
        // 10
        int number = 10;
        int limit = 3;
        int power = 2;
        // 21

        if (number < 1 || number > 100000) return;
        if (limit < 2 || limit > 100) return;
        if (power < 1 || power > limit) return;

        System.out.println(solution(number, limit, power));
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0, count = 0;

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    count++;
                    if (j != i / j) {
                        count++;
                    }
                }
            }

            if (count > limit) {
                answer += power;
            } else {
                answer += count;
            }
            count = 0;
        }

        return answer;
    }
}