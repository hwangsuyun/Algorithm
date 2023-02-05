package programmers.level0;

import java.util.Arrays;
import java.util.function.Predicate;

// 배열의 유사도
public class Solution16 {
    public static void main(String[] args) {
        //String s1[] = {"a", "b", "c"};
        //String s2[] = {"com", "b", "d", "p", "c"};
        // 2
        String s1[] = {"n", "omg"};
        String s2[] = {"m", "dot"};
        // 0

        if (s1.length < 1 || s1.length > 100) return;
        if (s2.length < 1 || s2.length > 100) return;
        for (String s : s1) {
            if (s.length() < 1 || s.length() > 10) return;
        }
        for (String s : s2) {
            if (s.length() < 1 || s.length() > 10) return;
        }

        System.out.println(solution(s1, s2));
    }

    public static int solution(String[] s1, String[] s2) {
        return Long.valueOf(
                Arrays.stream(s1)
                .filter(s -> Arrays.stream(s2).anyMatch(Predicate.isEqual(s)))
                .count())
                .intValue();
    }
}
