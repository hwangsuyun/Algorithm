package com.example.algorithm.level2;

import java.util.*;

// 주차 요금 계산
public class Solution95_1 {
    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
                "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        // [14600, 34400, 5000]
        //int[] fees = {120, 0, 60, 591};
        //String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        // [0, 591]
        //int[] fees = {1, 461, 1, 10};
        //String[] records = {"00:00 1234 IN"};
        // [14841]

        int[] result = solution(fees, records);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        TreeMap<String, Integer> map = new TreeMap<>();

        for(String record : records) {
            String[] temp = record.split(" ");
            int time = temp[2].equals("IN") ? -1 : 1;
            time *= timeToInt(temp[0]);
            map.put(temp[1], map.getOrDefault(temp[1], 0) + time);
        }
        int idx = 0;
        int[] ans = new int[map.size()];
        for(int time : map.values()) {
            if(time < 1) time += 1439;
            time -= fees[0];
            int cost = fees[1];
            if(time > 0)
                cost += (time % fees[2] == 0 ? time / fees[2] : time / fees[2] + 1) * fees[3];

            ans[idx++] = cost;
        }
        return ans;
    }

    private static int timeToInt(String time) {
        String[] temp = time.split(":");
        return Integer.parseInt(temp[0]) * 60 + Integer.parseInt(temp[1]);
    }
}