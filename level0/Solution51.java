package programmers.level0;

import java.util.ArrayList;
import java.util.List;

// 소인수분해
public class Solution51 {
    public static void main(String[] args) {
        //int n = 12; // [2, 3]
        //int n = 17; // [17]
        int n = 420; // [2, 3, 5, 7]

        if (n < 2 || n > 10000) return;

        int[] result = solution(n);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int n) {
        List<Integer> list = new ArrayList<>();
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                for (int j = 1; j <= i; j++) {
                    if (count > 2) break;
                    if (i % j == 0) count++;
                }
                if (count == 2) list.add(i);
            }
            count = 0;
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}