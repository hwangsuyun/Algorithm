package com.example.algorithm.level1;

import java.util.*;

// 가장 많이 받은 선물
public class Solution80 {
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
        int[] answer = new int[friends.length];
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        int index;

        // 1. gifts 배열에서 서로 주고 받은 개 수 구하기
        for (String giver : friends) {
            map.put(giver, 0);

            for (String taker : friends) {
                if (!giver.equals(taker)) {
                    String temp = giver + " " + taker;
                    int count = 0;

                    for (String gift : gifts) {
                        if (temp.equals(gift)) {
                            count++;
                        }
                    }
                    list.add(temp + " " + count);
                    map.put(giver, map.get(giver) + count);
                }
            }
        }

        // 2. 선물 지수 구하기
        for (String giver : friends) {
            int count = 0;
            for (String gift : gifts) {
                if (giver.equals(gift.split(" ")[1])) {
                    count++;
                }
            }
            map.put(giver, map.get(giver) - count);
        }

        // 3. list 에서 서로 주고 받은 선물 개 수 비교하기
        for (int i = 0; i < list.size(); i++) {
            index = i / (friends.length - 1);

            String[] arrayA = list.get(i).split(" ");
            String giver1 = arrayA[0];
            String taker1= arrayA[1];
            int valueA = Integer.parseInt(arrayA[2]);

            for (int j = 0; j < list.size(); j++) {
                if (i != j) {
                    String[] arrayB = list.get(j).split(" ");
                    String giver2 = arrayB[0];
                    String taker2 = arrayB[1];
                    int valueB = Integer.parseInt(arrayB[2]);

                    // 3.1 서로 주고 받은 선물 개 수가 더 많으면 증가
                    if (giver1.equals(taker2) && taker1.equals(giver2) && valueA > valueB) {
                        answer[index]++;
                    } else if (giver1.equals(taker2) && taker1.equals(giver2) && valueA == valueB) {
                        // 3.2 서로 주고 받은 선물 개 수가 같으면 선물 지수 구하기
                        if (map.get(giver1) > map.get(giver2)) {
                            answer[index]++;
                        }
                    }
                }
            }
        }

        // 4. 가장 많은 선물 개 수 반환하기
        Arrays.sort(answer);
        return answer[answer.length - 1];
    }
}