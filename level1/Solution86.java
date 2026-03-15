package solution1;

import java.util.*;

// 노란불 신호등
public class Solution86 {
    public static void main(String[] args) {
        //int[][] signals = {{2, 1, 2}, {5, 1, 1}};
        // 13
        //int[][] signals = {{2, 3, 2}, {3, 1, 3}, {2, 1, 1}};
        // 11
        int[][] signals = {{3, 3, 3}, {5, 4, 2}, {2, 1, 2}};
        // 193
        //int[][] signals = {{1, 1, 4}, {2, 1, 3}, {3, 1, 2}, {4, 1, 1}};
        // -1
        System.out.println(solution(signals));
    }

    private static int solution(int[][] signals) {
        // 3 8  13 18 23 28 33
        // 6 13 20 27 34 41 48
        List<Map<Integer, Integer>> maps = new ArrayList<>();
        for (int[] signal : signals) {
            int sum = 0;
            Map<Integer, Integer> map = new LinkedHashMap<>();

            while (sum <= 10000000) {
                sum += signal[0];
                for (int i = sum + 1; i <= sum + signal[1]; i++) {
                    map.put(i, 0);
                }
                sum += signal[1] + signal[2];
            }
            maps.add(map);
        }

        for (int yellow : maps.get(0).keySet()) {
            boolean flag = false;

            for (int j = 1; j < maps.size(); j++) {
                for (int z = 0; z < maps.get(j).size(); z++) {
                    if (maps.get(j).get(yellow) == null) {
                        flag = false;
                        break;
                    } else if (maps.get(j).get(yellow) == 0) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) break;
            }
            if (flag) return yellow;
        }

        return -1;
    }
}