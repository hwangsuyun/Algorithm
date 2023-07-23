package programmers.level2;

import java.util.*;

// 연속된 부분 수열의 합
public class Solution50 {
    public static void main(String[] args) {
        //int[] sequence = {1, 2, 3, 4, 5};
        //int k = 7;
        // [2, 3]
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        // [6, 6]
        //int[] sequence = {2, 2, 2, 2, 2};
        //int k = 6;
        // [0, 2]
        //int[] sequence = {1, 1, 1, 1, 1, 1, 1};
        //int k = 7;
        // [0, 6]
        //int[] sequence = {7, 5, 5, 1, 1, 50, 50};
        //int k = 100;
        // [5, 6]

        if (sequence.length < 5 || sequence.length > 1000000) return;
        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i] < 1 || sequence[i] > 1000) return;
        }
        if (k < 5 || k > 1000000000) return;

        int[] result = solution(sequence, k);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int[] sequence, int k) {
        List<Integer> list = new ArrayList<>();
        int left = 0, right = 0;
        int sum = sequence[0];

        while (true) {
            if (sum == k) {
                list.add(left);
                list.add(right);
            }
            if (left == sequence.length && right == sequence.length) break;

            if (sum < k && right < sequence.length) {
                right++;
                if (right < sequence.length) sum += sequence[right];
            } else {
                if (left < sequence.length) sum -= sequence[left];
                left++;
            }
        }

        int temp = Integer.MAX_VALUE, index = 0;
        for (int i = 0; i <= list.size() - 2; i += 2) {
            if (temp > list.get(i + 1) - list.get(i)) {
                temp = list.get(i + 1) - list.get(i);
                index = i;
            }
        }

        return new int[] {list.get(index), list.get(index + 1)};
    }
}