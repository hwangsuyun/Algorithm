package com.example.algorithm.level0;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// 주사위 게임 3
public class Solution188 {
    public static void main(String[] args) {
        //int a = 2, b = 2, c = 2, d = 2;
        // 2222
        //int a = 4, b = 1, c = 4, d = 4;
        // 1681
        //int a = 6, b = 3, c = 3, d = 6;
        // 27
        int a = 2, b = 5, c = 2, d = 6;
        // 30
        //int a = 6, b = 4, c = 2, d = 5;
        // 2

        if (a < 1 || a > 6) return;
        if (b < 1 || b > 6) return;
        if (c < 1 || c > 6) return;
        if (d < 1 || d > 6) return;

        System.out.println(solution(a, b, c, d));
    }

    public static int solution(int a, int b, int c, int d) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(a, map.getOrDefault(a, 0) + 1);
        map.put(b, map.getOrDefault(b, 0) + 1);
        map.put(c, map.getOrDefault(c, 0) + 1);
        map.put(d, map.getOrDefault(d, 0) + 1);

        int min = Math.min(map.get(a), Math.min(map.get(b), Math.min(map.get(c), map.get(d))));
        int max = Math.max(map.get(a), Math.max(map.get(b), Math.max(map.get(c), map.get(d))));

        if (max == 4) return 1111 * a;
        if (max == 1) return Math.min(a, Math.min(b, Math.min(c, d)));;
        if (max == 3 && min == 1) {
            int p = 0, q = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    q = entry.getKey();
                } else {
                    p = entry.getKey();
                }
            }
            if (q * p != q * q) return (int) Math.pow(10 * p + q, 2);
            return 0;
        }
        if (max == 2 && min == 2) {
            int p = 0, q = 0;
            Iterator<Integer> keys = map.keySet().iterator();
            while (keys.hasNext()) {
                p = keys.next();
                q = keys.next();
            }
            if (q * p != q * q) return (p + q)  * Math.abs(p - q);
            return 0;
        }
        if (max == 2 && min == 1) {
            int q = 0, r = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == 1) {
                    if (q == 0) q = entry.getKey();
                    else r = entry.getKey();
                }
            }
            if (r * q != r * r) return q * r;
            return 0;
        }

        return 0;
    }

    public static int solution2(int a, int b, int c, int d) {
        int[] dice = {a, b, c, d};
        Arrays.sort(dice);

        int ans = 0;

        if (dice[0] == dice[3]) {
            ans = 1111 * dice[3];
        } else if (dice[0] == dice[2] || dice[1] == dice[3]) {
            ans = (int) Math.pow(dice[1] * 10 + (dice[0] + dice[3] - dice[1]), 2);
        } else if (dice[0] == dice[1] && dice[2] == dice[3]) {
            ans = (dice[0] + dice[3]) * (dice[3] - dice[0]);
        } else if (dice[0] == dice[1]) {
            ans = dice[2] * dice[3];
        } else if (dice[1] == dice[2]) {
            ans = dice[0] * dice[3];
        } else if (dice[2] == dice[3]) {
            ans = dice[0] * dice[1];
        } else {
            ans = dice[0];
        }

        return ans;
    }
}