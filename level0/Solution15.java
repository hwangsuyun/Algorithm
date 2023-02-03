package programmers.level0;

import java.util.stream.IntStream;

// 숫자 찾기
public class Solution15 {
    public static void main(String[] args) {
        //int num = 29183;
        //int k = 1;
        // 3
        int num = 232443;
        int k = 4;
        // 4
        //int num = 123456;
        //int k = 7;
        // -1

        if (num <= 0 || num > 1000000) return;
        if (k < 0 || k > 10) return;

        System.out.println(solution(num, k));
    }

    public static int solution(int num, int k) {
        String[] strArray = String.valueOf(num).split("");
        int answer = IntStream
                            .range(0, strArray.length)
                            .filter(i -> String.valueOf(k).equals(strArray[i]))
                            .findFirst()
                            .orElse(-1);
        answer = answer == -1 ? answer : answer + 1;
        return answer;
    }
}
