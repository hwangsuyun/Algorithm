package com.example.algorithm.level2;

import java.util.*;

// 주차 요금 계산
public class Solution95 {
    public static void main(String[] args) {
        //int[] fees = {180, 5000, 10, 600};
        //String[] records = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT",
        //        "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"};
        // [14600, 34400, 5000]
        //int[] fees = {120, 0, 60, 591};
        //String[] records = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"};
        // [0, 591]
        int[] fees = {1, 461, 1, 10};
        String[] records = {"00:00 1234 IN"};
        // [14841]

        int[] result = solution(fees, records);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, String> map = new HashMap<>();
        getInOutTime(records, map);
        return calculateFee(fees, map);
    }

    private static void getInOutTime(String[] records, Map<String, String> map) {
        for (String record : records) {
            String[] array = record.split(" ");
            String time = array[0];
            String car = array[1];

            if (map.get(car) == null) {
                map.put(car, time + ",");
            } else {
                map.put(car, map.get(car) + time + ",");
            }
        }

        for (String key : map.keySet()) {
            String[] array = map.get(key).split(",");
            if (array.length % 2 != 0) {
                map.put(key, map.get(key) + "23:59,");
            }
        }

        for (String value : map.values()) {
            System.out.println(value);
        }
    }

    private static int[] calculateFee(int[] fees, Map<String, String> map) {
        int[] result = new int[map.size()];
        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);
        int index = 0;

        for (String key : list) {
            int totalTime = 0, totalFee;
            String[] array = map.get(key).split(",");

            for (int i = 0; i < array.length; i += 2) {
                int hour = Integer.parseInt(array[i + 1].split(":")[0]) - Integer.parseInt(array[i].split(":")[0]);
                int endMinute = Integer.parseInt(array[i + 1].split(":")[1]);
                int startMinute = Integer.parseInt(array[i].split(":")[1]);
                hour = endMinute < startMinute ? hour - 1 : hour;
                endMinute = endMinute < startMinute ? endMinute + 60 - startMinute : endMinute - startMinute;
                totalTime += hour * 60 + endMinute;
            }
            totalFee = totalTime > fees[0] ? fees[1] + (int) Math.ceil(((double) totalTime - fees[0]) / fees[2]) * fees[3] : fees[1];
            result[index++] = totalFee;
        }

        return result;
    }
}