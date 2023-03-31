package programmers.level0;

// 최댓값 만들기 (2)
public class Solution46 {
    public static void main(String[] args) {
        //int[] numbers = {1, 2, -3, 4, -5}; // 15
        //int[] numbers = {0, -31, 24, 10, 1, 9}; // 240
        //int[] numbers ={10, 20, 30, 5, 5, 20, 5}; // 600
        int[] numbers ={1, -2}; // -2

        if (numbers.length < 2 || numbers.length > 100) return;
        for (int i : numbers) {
            if (i < -10000 || i > 10000) return;
        }

        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int answer = Integer.MAX_VALUE * -1;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers.length; j++) {
                if (i == j) continue;
                if (numbers[i] * numbers[j] > answer) {
                    answer = numbers[i] * numbers[j];
                }
            }
        }
        return answer;
    }
}