package programmers.level1;

// 삼총사
public class Solution67 {
    public static void main(String[] args) {
        //int[] number = {-2, 3, 0, 2, -5}; // 2
        //int[] number = {-3, -2, -1, 0, 1, 2, 3}; // 5
        int[] number = {-1, 1, -1, 1}; // 0

        if (number.length < 3 || number.length > 13) return;
        for (int i = 0; i < number.length; i++) {
            if (number[i] < -1000 || number[i] > 1000) return;
        }

        System.out.println(solution(number));
    }

    public static int solution(int[] number) {
        int answer = 0;
        for (int i = 0; i < number.length; i++) {
            for (int j = i + 1; j < number.length; j++) {
                for (int k = j + 1; k < number.length; k++) {
                    if (number[i] + number[j] + number[k] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}