package programmers.level1;

// 덧칠하기
public class Solution51 {
    public static void main(String[] args) {
        //int n = 8;
        //int m = 4;
        //int[] section = {2, 3, 6};
        // 2
        //int n = 5;
        //int m = 4;
        //int[] section = {1, 3};
        // 1
        //int n = 4;
        //int m = 1;
        //int[] section = {1, 2, 3, 4};
        // 4
        int n = 16;
        int m = 4;
        int[] section = {2, 3, 15, 16};
        // 2

        if (m < 1 || m > 100000) return;
        if (n < 1 || n > 100000) return;
        if (section.length < 1 || section.length > n) return;

        System.out.println(solution(n, m, section));
    }

    public static int solution(int n, int m, int[] section) {
        int answer = 1;
        int start = section[0];
        for (int i = 1; i < section.length; i++) {
            if (section[i] >= start + m) {
                answer++;
                start = section[i];
            }
        }
        return answer;
    }
}