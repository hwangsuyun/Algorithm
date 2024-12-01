package com.example.algorithm.level0;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

// 전국 대회 선발 고사
public class Solution124 {
    public static void main(String[] args) {
        //int[] rank = {3, 7, 2, 5, 4, 6, 1};
        //boolean[] attendance = {false, true, true, true, true, false, false};
        // 20403
        //int[] rank = {1, 2, 3};
        //boolean[] attendance = {true, true, true};
        // 102
        int[] rank = {6, 1, 5, 2, 3, 4};
        boolean[] attendance = {true, false, true, false, false, true};
        // 50200

        if (rank.length < 3 || rank.length > 100) return;

        System.out.println(solution(rank, attendance));
    }

    public static int solution(int[] rank, boolean[] attendance) {
        int[] rank1 = IntStream.range(0, rank.length)
                .map(i -> !attendance[i] ? rank[i] = -1 : rank[i])
                .filter(r -> r != -1)
                .sorted()
                .toArray();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < rank.length; i++) {
            map.put(rank[i], i);
        }
        return map.get(rank1[0]) * 10000 + map.get(rank1[1]) * 100 + map.get(rank1[2]);
    }

    public static int solution2(int[] rank, boolean[] attendance) {
        return IntStream.range(0, rank.length)
                .filter(i -> attendance[i])
                .boxed()
                .sorted(Comparator.comparing(i -> rank[i]))
                .limit(3L)
                .reduce((current, next) -> current * 100 + next)
                .get();
    }

    public static int solution3(int[] rank, boolean[] attendance) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Comparator.comparingInt(a -> rank[a]));
        for (int i = 0; i < attendance.length; i++) {
            if (attendance[i])
                que.add(i);
        }
        return que.poll() * 10000 + que.poll() * 100 + que.poll();
    }
}