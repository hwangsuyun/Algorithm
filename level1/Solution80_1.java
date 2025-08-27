package com.example.algorithm.level1;

import java.util.*;

// 가장 많이 받은 선물
public class Solution80_1 {
    public static void main(String[] args) {
        //String[] friends = {"muzi", "ryan", "frodo", "neo"};
        //String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        // 2
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        // 4
        //String[] friends = {"a", "b", "c"};
        //String[] gifts = {"a b", "b a", "c a", "a c", "a c", "c a"};
        // 0

        if (friends.length < 2 || friends.length > 50) return;
        if (gifts.length < 1 || gifts.length > 10000) return;

        System.out.println(solution(friends, gifts));
    }

    public static int solution(String[] friends, String[] gifts) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < friends.length; i++) {
            map.put(friends[i], i);
            System.out.println(map.get(friends[i]));
        }
        int[] index = new int[friends.length];
        int[][] record = new int[friends.length][friends.length];

        for (String str : gifts) {
            String[] cur = str.split(" ");
            index[map.get(cur[0])]++;
            index[map.get(cur[1])]--;
            record[map.get(cur[0])][map.get(cur[1])]++;
        }

        int ans = 0;
        for (int i = 0; i < friends.length; i++) {
            int cnt = 0;
            for (int j = 0; j < friends.length; j++) {
                if(i == j) continue;
                if (record[i][j] > record[j][i]) cnt++;
                else if (record[i][j] == record[j][i] && index[i] > index[j]) cnt++;
            }
            ans = Math.max(cnt, ans);
        }
        return ans;
    }
}