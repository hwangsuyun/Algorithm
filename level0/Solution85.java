package programmers.level0;

// 피자 나눠 먹기 (2)
public class Solution85 {
    public static void main(String[] args) {
        //int n = 6; // 1
        //int n = 10; // 5
        //int n = 4; // 2
        //int n = 13; // 13
        int n = 12; // 2

        if (n < 1 || n > 100) return;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        for (int i = 0; i < n * 100; i += 6) {
            if (i != 0 && i % n == 0) {
                answer = i / 6;
                break;
            }
        }
        return answer;
    }
}