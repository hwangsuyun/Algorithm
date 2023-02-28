package programmers.level0;

import java.util.stream.IntStream;

// k의 개수
public class Solution30 {
    public static void main(String[] args) {
        int i = 1, j = 13, k = 1; // 6

        if (i < 1 || i > 100000) return;
        if (i > j) return;
        if (j < 1 || j > 100000) return;
        if (k < 0 || k > 9) return;

        System.out.println(solution(i, j, k));
    }

    public static int solution(int i, int j, int k) {
        String answer = "";
        int result = 0;
        for (int x = i; x <= j; x++) {
            answer = String.valueOf(x);
            if (answer.length() > 1) {
                String[] strArray = answer.split("");
                for (String str : strArray) {
                    if (str.equals(String.valueOf(k))) result++;
                }
            } else {
                if (answer.contains(String.valueOf(k))) result++;
            }
        }
        return result;
    }
}
