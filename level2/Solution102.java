package com.example.algorithm.level2;

import java.util.*;

// 전력망을 둘로 나누기
public class Solution102 {
    public static void main(String[] args) {
        int n = 9;
        int[][] wires = {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        // 3
        //int n = 4;
        //int[][] wires = {{1, 2}, {2, 3}, {3, 4}};
        // 0
        //int n = 7;
        //int[][] wires = {{1, 2}, {2, 7}, {3, 7}, {3, 4}, {4, 5}, {6, 7}};
        // 1
        //int n = 4;
        //int[][] wires = {{1, 2}, {2, 3}, {4, 2}};
        // 2

        System.out.println(solution(n, wires));
    }

    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < wires.length; i++) {
            Set<Integer> setA = new LinkedHashSet<>();
            Set<Integer> setB = new LinkedHashSet<>();

            int x = wires[i][0];
            int y = wires[i][1];

            setA.add(x);
            setB.add(y);

            int cntA = getCount(i, setA, wires);
            int cntB = getCount(i, setB, wires);
            answer = Math.min(answer, Math.abs(cntA - cntB));
        }

        return answer;
    }

    private static int getCount(int i, Set<Integer> set, int[][] wires) {
        while (true) {
            int before = set.size();
            List<Integer> temp = new ArrayList<>();

            for (int number : set) {
                for (int j = 0; j < wires.length; j++) {
                    if (i == j) continue;
                    if (number == wires[j][0]) {
                        temp.add(wires[j][1]);
                    } else if (number == wires[j][1]) {
                        temp.add(wires[j][0]);
                    }
                }
            }
            set.addAll(temp);
            if (before == set.size()) break;
        }

        System.out.println("key : " + wires[i][0]);
        for (int number : set) {
            System.out.print(number + ",");
        }
        System.out.println();

        return set.size();
    }
}