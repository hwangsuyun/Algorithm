package com.example.algorithm.level0;

// 문자열 여러 번 뒤집기
public class Solution185 {
    public static void main(String[] args) {
        String my_string = "rermgorpsam";
        int[][] queries = {{2, 3}, {0, 7}, {5, 9}, {6, 10}};
        // "programmers"

        if (my_string.length() < 1 || my_string.length() > 1000) return;
        if (queries.length < 1 || queries.length > 1000) return;

        System.out.println(solution(my_string, queries));
    }

    public static String solution(String my_string, int[][] queries) {
        for (int[] query : queries) {
            my_string = my_string.substring(0, query[0])
                    + new StringBuilder().append(my_string, query[0], query[1] + 1).reverse()
                    + my_string.substring(query[1] + 1);
        }
        return my_string;
    }

    public static String solution2(String my_string, int[][] queries) {
        char[] arr = my_string.toCharArray();
        for (int[] query : queries) {
            reverse(arr, query[0], query[1]);
        }
        return new String(arr);
    }

    private static void reverse(char[] arr, int s, int e) {
        while (s < e) {
            char temp = arr[s];
            arr[s++] = arr[e];
            arr[e--] = temp;
        }
    }
}