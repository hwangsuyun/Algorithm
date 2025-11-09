package com.example.algorithm.level2;

import java.util.*;

// 방문 길이
public class Solution94 {
    public static void main(String[] args) {
        String dirs = "ULURRDLLU"; // 7
        //String dirs = "LULLLLLLU"; // 7
        //String dirs = "LRLRL"; // 1

        System.out.println(solution(dirs));
    }

    public static int solution(String dirs) {
        int answer = 0;
        int x = 5, y = 5;
        List<String> list = new ArrayList<>();

        for (String dir : dirs.split("")) {
            boolean moved = false;
            int currX = x, currY = y;

            if (dir.equals("U") && x < 10) {
                moved = true;
                x++;
            } else if (dir.equals("D") && x > 0) {
                moved = true;
                x--;
            } else if (dir.equals("R") && y < 10) {
                moved = true;
                y++;
            } else if (dir.equals("L") && y > 0) {
                moved = true;
                y--;
            }

            if (moved) {
                String position = currX + "," + currY + "," + x + "," + y;
                String reverse = x + "," + y + "," + currX + "," + currY;
                if (!list.contains(position)) {
                    list.add(position);
                    list.add(reverse);
                    answer++;
                }
            }
        }

        return answer;
    }
}