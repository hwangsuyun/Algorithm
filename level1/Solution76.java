package programmers.level1;

// 약수의 개수와 덧셈
public class Solution76 {
    public static void main(String[] args) {
        //int left = 13;
        //int right = 17;
        // 43
        int left = 24;
        int right = 27;
        // 52

        if (left < 1 || left > right) return;
        if (right < left || right > 1000) return;

        System.out.println(solution(left, right));
    }

    public static int solution(int left, int right) {
        int answer = 0, count = 0;
        for (int i = left; i <= right; i++) {
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count % 2 == 0) {
                answer += i;
            } else {
                answer -= i;
            }
            count = 0;
        }
        return answer;
    }
}