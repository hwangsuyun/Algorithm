package programmers.level0;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// 삼각형의 완성조건 (2)
public class Solution42 {
    public static void main(String[] args) {
        //int[] sides = {1, 2}; // 1
        //int[] sides = {3, 6}; // 5
        int[] sides = {11, 7}; // 13

        if (sides.length != 2) return;
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] < 1 || sides[i] > 1000) return;
        }

        System.out.println(solution(sides));
    }

    public static int solution(int[] sides) {
        int answer = 0;
        // case 1 : sides의 변수가 가장 클 때
        int max = Math.max(sides[0], sides[1]);
        int min = Math.min(sides[0], sides[1]);
        for (int i = 1; i < max; i++) {
            if (i + min > max) answer++;
        }
        // case 2 : 제 3의 변수가 가장 클 때
        for (int i = max; i < min + max; i++) {
            if (i < min + max) answer++;
        }
        return answer;
    }
}