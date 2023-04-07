package programmers.level0;

import java.util.Arrays;

// 배열 원소의 길이
public class Solution49 {
    public static void main(String[] args) {
        //String[] strlist = {"We", "are", "the", "world!"}; // [2, 3, 3, 6]
        String[] strlist = {"I", "Love", "Programmers."}; // [1, 4, 12]

        if (strlist.length < 1 || strlist.length > 100) return;

        int[] result = solution(strlist);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] strlist) {
        return Arrays.stream(strlist).mapToInt(str -> str.length()).toArray();
    }
}