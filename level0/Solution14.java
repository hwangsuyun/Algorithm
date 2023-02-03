package programmers.level0;

import java.util.Arrays;

// n의 배수 고르기
public class Solution14 {
    public static void main(String[] args) {
        //int n = 3;
        //int[] numlist = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        // [6, 9, 12]
        //int n = 5;
        //int[] numlist = {1, 9, 3, 10, 13, 5};
        // [10, 5]
        int n = 12;
        int[] numlist = {2, 100, 120, 600, 12, 12};
        // [120, 600, 12, 12]

        if (n < 1 || n > 10000) return;
        if (numlist.length < 1 || numlist.length > 100) return;
        for (int num : numlist) {
            if (num < 1 || num > 100000) return;
        }

        int[] answer = solution(n, numlist);
        for (int i : answer) System.out.println(i);
    }

    public static int[] solution(int n, int[] numlist) {
        return Arrays.stream(numlist).filter(num -> (num % n) == 0).toArray();
    }
}
