package programmers.level0;

// 공 던지기
public class Solution60 {
    public static void main(String[] args) {
        //int[] numbers = {1, 2, 3, 4};
        //int k = 2;
        // 3
        //int[] numbers = {1, 2, 3, 4, 5, 6};
        //int k = 5;
        // 3
        int[] numbers = {1, 2, 3};
        int k = 3;
        // 2

        if (numbers.length <= 2 || numbers.length >= 100) return;
        if (k <= 0 || k >= 1000) return;

        System.out.println(solution(numbers, k));
    }

    public static int solution(int[] numbers, int k) {
        int index = 0;
        while (k > 1) {
            index += 2;
            if (index > numbers.length) index -= numbers.length;
            k--;
        }
        return numbers[index];
    }
}