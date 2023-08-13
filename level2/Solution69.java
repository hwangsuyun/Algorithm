package programmers.level2;

import java.util.*;

// 숫자 카드 나누기
public class Solution69 {
    public static void main(String[] args) {
        //int[] arrayA = {10, 17};
        //int[] arrayB = {5, 20};
        // 0
        //int[] arrayA = {10, 20};
        //int[] arrayB = {5, 17};
        // 10
        int[] arrayA = {14, 35, 119};
        int[] arrayB = {18, 30, 102};
        // 7

        if (arrayA.length < 1 || arrayA.length > 500000) return;
        if (arrayB.length < 1 || arrayB.length > 500000) return;
        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] < 1 || arrayA[i] > 100000000) return;
            if (arrayB[i] < 1 || arrayB[i] > 100000000) return;
        }

        System.out.println(solution(arrayA, arrayB));
    }

    public static int solution(int[] arrayA, int[] arrayB) {
        // 1. arrayA 의 약수를 구한다.
        // 2. arrayB 의 약수를 구한다.
        // 3. arrayA 약수로 arrayB 를 나누고 나누어 지지 않으면 최대값을 반환한다.
        // 4. arrayB 약수로 arrayA 를 나누고 나누어 지지 않으면 최대값을 반환한다.
        // 5. 두 약수 최대값에서 큰 값을 반환한다.
        // 6. 조건에 맞지 않으면 0을 리턴한다.
        return Math.max(getList(arrayA, arrayB), getList(arrayB, arrayA));
    }

    // 1. arrayA 의 약수를 구한다.
    // 2. arrayB 의 약수를 구한다.
    private static int getList(int[] arrayA, int[] arrayB) {
        int result = 0;
        int min = Arrays.stream(arrayA).min().orElse(0);
        for (int i = min; i >= 2; i--) {
            int count = 0;
            for (int j = 0; j < arrayA.length; j++) {
                if (arrayA[j] % i == 0) count++;
                else break;
            }

            if (count == arrayA.length) {
                result = Math.max(getCount(i, arrayB), result);
                if (result != 0) break;
            }
        }
        return result;
    }

    // 3. arrayA 약수로 arrayB 를 나누고 나누어 지지 않으면 최대값을 반환한다.
    // 4. arrayB 약수로 arrayA 를 나누고 나누어 지지 않으면 최대값을 반환한다.
    private static int getCount(int max, int[] array) {
        int result = 0;
        int count = 0;
        for (int arr : array) {
            if (arr % max != 0) count++;
            else break;
        }
        if (count == array.length) {
            if (result < max) {
                result = max;
            }
        }
        return result;
    }
}