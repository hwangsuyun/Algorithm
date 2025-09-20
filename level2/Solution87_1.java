package com.example.algorithm.level2;

import java.util.ArrayList;

// [1차] 캐시
public class Solution87_1 {
    public static void main(String[] args) {
        int cacheSize = 3;
        String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        // 50
        //int cacheSize = 3;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        // 21
        //int cacheSize = 2;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        // 60
        //int cacheSize = 5;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        // 52
        //int cacheSize = 2;
        //String[] cities = {"Jeju", "Pangyo", "NewYork", "newyork"};
        // 16
        //int cacheSize = 0;
        //String[] cities = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        // 25

        System.out.println(solution(cacheSize, cities));
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;
        ArrayList<String> list = new ArrayList<>();

        if (cacheSize == 0)
            return cities.length * 5;

        for (int i = 0; i < cities.length; i++) {
            cities[i] = cities[i].toUpperCase();

            if (list.contains(cities[i])) {
                answer++;
                list.remove(cities[i]);
                list.add(cities[i]);
            } else {
                answer += 5;
                if (list.size() == cacheSize) {
                    list.remove(0);
                    list.add(cities[i]);
                }
                else
                    list.add(cities[i]);
            }
        }
        return answer;
    }
}