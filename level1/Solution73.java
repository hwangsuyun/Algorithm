package programmers.level1;

// 없는 숫자 더하기
public class Solution73 {
    public static void main(String[] args) {
        //int[] numbers = {1, 2, 3, 4, 6, 7, 8, 0}; // 14
        int[] numbers = {5, 8, 4, 0, 6, 7, 9}; // 6

        if (numbers.length < 1 || numbers.length > 9) return;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0 || numbers[i] > 9) return;
        }

        System.out.println(solution(numbers));
    }

    public static int solution(int[] numbers) {
        int answer = 0;
        String temp = "";

        for (int i : numbers) {
            temp += i;
        }

        for (int i = 1; i < 10; i++) {
            if (!temp.contains(String.valueOf(i))) {
                answer += i;
            }
        }

        return answer;
    }
}