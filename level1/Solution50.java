package programmers.level1;

import java.util.*;

// 바탕화면 정리
public class Solution50 {
    public static void main(String[] args) {
        //String[] wallpaper = {".#...", "..#..", "...#."};
        // [0, 1, 3, 4]
        //String[] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        // [1, 3, 5, 8]
        //String[] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        // [0, 0, 7, 9]
        String[] wallpaper = {"..", "#."};
        // [1, 0, 2, 1]

        if (wallpaper.length < 1 || wallpaper.length > 50) return;
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].length() < 1 || wallpaper[i].length() > 50) return;
        }

        int[] result = solution(wallpaper);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();

        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                rowSet.add(i);
                columnSet.add(wallpaper[i].indexOf("#"));
                columnSet.add(wallpaper[i].lastIndexOf("#"));
            }
        }

        answer[0] = rowSet.stream().mapToInt(i -> i).min().orElse(-1);
        answer[1] = columnSet.stream().mapToInt(i -> i).min().orElse(-1);
        answer[2] = rowSet.stream().mapToInt(i -> i).max().orElse(-1) + 1;
        answer[3] = columnSet.stream().mapToInt(i -> i).max().orElse(-1) + 1;

        return answer;
    }
}