package programmers.level1;

import java.util.LinkedHashMap;
import java.util.Map;

// 푸드 파이트 대회
public class Solution63 {
    public static void main(String[] args) {
        //int[] food = {1, 3, 4, 6}; //1223330333221
        int[] food = {1, 7, 1, 2}; //111303111

        if (food.length < 2 || food.length > 9) return;
        for (int i = 0; i < food.length; i++) {
            if (food[i] < 1 || food[i] > 1000) return;
        }

        System.out.println(solution(food));
    }

    public static String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 1; i < food.length; i++) {
            if (food[i] != 1) {
                map.put(i, food[i] / 2);
            } else {
                map.put(i, 0);
            }
        }
        for (int i = 1; i <= map.size(); i++) {
            if (map.get(i) != 0) {
                for (int j = map.get(i); j > 0; j--) {
                    sb.append(i);
                }
            }
        }
        return sb.toString() + "0" + sb.reverse().toString();
    }
}