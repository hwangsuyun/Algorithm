package com.example.algorithm.level2;

import java.util.LinkedHashMap;
import java.util.Map;

// [1차] 캐시
public class Solution87 {
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
        if (cacheSize == 0) return cities.length * 5;

        LRUCache<String, String> cache = new LRUCache<>(cacheSize);
        int answer = 0;

        for (String city : cities) {
            city = city.toLowerCase();
            if (cache.get(city) == null) {
                answer += 5;
            } else {
                answer += 1;
                cache.remove(city);
            }
            cache.put(city, "");
        }
        return answer;
    }

    static class LRUCache<K, V> extends LinkedHashMap<K, V> {
        private final int cacheSize;

        public LRUCache(int cacheSize) {
            super(cacheSize, 0.75f, false);
            this.cacheSize = cacheSize;
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
            return size() > cacheSize;
        }
    }
}