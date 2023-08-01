package programmers.level2;

import java.util.*;

// 뒤에 있는 큰 수 찾기
public class Solution59 {
    public static void main(String[] args) {
        int[] numbers = {2, 3, 3, 5}; // [3, 5, 5, -1]
        //int[] numbers = {9, 1, 5, 3, 6, 2}; // [-1, 5, 6, 6, -1, -1]

        if (numbers.length < 4 || numbers.length > 1000000) return;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 1 || numbers[i] > 1000000) return;
        }

        int[] result = solution(numbers);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int[] numbers) {
        // 정답 배열 생성
        int[] answer = new int[numbers.length];
        // number index 정보를 담을 Stack 생성
        Stack<Integer> stack = new Stack<>();

        // 첫 번째 number 인덱스 stack에 push
        stack.push(0);

        // 두 번째 원소부터 numbers 탐색
        for (int i = 1; i < numbers.length; i++) {
            // 스택이 비어있지 않으면서 현재 스택이 바라보고 있는 값보다 number의 값이 크면 뒤에 있는 큰 수 해당
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                // 뒤에 있는 큰 수에 해당하는 모든 값 pop
                answer[stack.pop()] = numbers[i];;
            }
            // 현재 인덱스 push
            stack.push(i);
        }

        // 모든 index를 탐색 후 뒤에 있는 큰 수가 없는 경우 -1
        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }
}