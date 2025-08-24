package com.example.algorithm.level1;

import java.util.Arrays;
import java.util.Collections;

// [PCCE 기출문제] 10번 / 공원
public class Solution79 {
    public static void main(String[] args) {
        /*
        int[] mats = {5, 3, 2};
        String[][] park = {{"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"A", "A", "-1", "B", "B", "B", "B", "-1"},
                {"-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"},
                {"D", "D", "-1", "-1", "-1", "-1", "-1", "F"},
                {"D", "D", "-1", "-1", "-1", "-1", "E", "-1"}};
         */
        // 3
        //int[] mats = {3};
        //String[][] park = {{"-1", "-1", "A"}, {"-1", "-1", "-1"}, {"-1", "-1", "-1"}};
        // -1
        int[] mats = {3, 2};
        String[][] park = {{"-1", "-1", "-1"}, {"-1", "A", "-1"}, {"-1", "-1", "-1"}};
        // -1

        if (mats.length < 1 || mats.length > 10) return;
        for (int i = 0; i < mats.length; i++) {
            if (mats[i] < 1 || mats[i] > 20) return;
        }
        if (park.length < 1 || park.length > 50) return;
        for (int i = 0; i < park.length; i++) {
            if (park[i].length < 1 || park[i].length > 50) return;
        }

        System.out.println(solution(mats, park));
    }

    public static int solution(int[] mats, String[][] park) {
        Integer[] orderedMats = Arrays.stream(mats).boxed().toArray(Integer[]::new);
        Arrays.sort(orderedMats, Collections.reverseOrder());

        for (int mat : orderedMats) {

            for (int i = 0; i < park.length; i++) {
                int count = 0;

                for (int j = 0; j < park[i].length; j++) {
                    if (park[i][j].equals("-1")) {
                        for (int k = i; k < i + mat; k++) {
                            if (k == park.length) break;
                            if (park[k][j].equals("-1")) {
                                count++;
                            } else {
                                count = 0;
                                break;
                            }
                        }

                        if (count < mat) {
                            count = 0;
                        } else if (count >= mat * mat) {
                            return mat;
                        }
                    } else {
                        count = 0;
                    }
                }
            }

        }

        return -1;
    }
}