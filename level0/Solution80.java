package programmers.level0;

// 나이 출력
public class Solution80 {
    public static void main(String[] args) {
        //int age = 40; // 1983
        int age = 23; // 2000

        if (age <= 0 || age > 120) return;

        System.out.println(solution(age));
    }

    public static int solution(int age) {
        return 2023 - age;
    }
}