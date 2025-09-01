package com.example.algorithm.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

// [PCCE 기출문제] 10번 / 데이터 분석
public class Solution83 {
    public static void main(String[] args) {
        int[][] data = {{1, 20300104, 100, 80},
                {2, 20300804, 847, 37},
                {3, 20300401, 10, 8}};
        String ext = "date";
        int val_ext = 20300501;
        String sort_by = "remain";
        // [[3,20300401,10,8],[1,20300104,100,80]]

        int[][] result = solution(data, ext, val_ext, sort_by);
        for (int[] array : result) {
            for (int i : array) {
                System.out.println(i);
            }
        }
    }

    public static int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        for (int[] array : data) {
            switch (ext) {
                case "code":
                    if (array[0] < val_ext) {
                        list.add(array);
                    }
                    break;
                case "date":
                    if (array[1] < val_ext) {
                        list.add(array);
                    }
                    break;
                case "maximum":
                    if (array[2] < val_ext) {
                        list.add(array);
                    }
                    break;
                case "remain":
                    if (array[3] < val_ext) {
                        list.add(array);
                    }
                    break;
            }
        }

        switch (sort_by) {
            case "code" ->
                    list = list.stream().sorted(Comparator.comparingInt((int[] a) -> a[0])).collect(Collectors.toList());
            case "date" ->
                    list = list.stream().sorted(Comparator.comparingInt((int[] a) -> a[1])).collect(Collectors.toList());
            case "maximum" ->
                    list = list.stream().sorted(Comparator.comparingInt((int[] a) -> a[2])).collect(Collectors.toList());
            case "remain" ->
                    list = list.stream().sorted(Comparator.comparingInt((int[] a) -> a[3])).collect(Collectors.toList());
        }

        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size();i ++) {
            result[i] = list.get(i);
        }

        return result;
    }

    public int[][] solution2(int[][] data, String ext, int val_ext, String sort_by) {

        String[] arr = {"code","date","maximum","remain"};
        List<String> columnList = Arrays.asList(arr);
        int extIdx = columnList.indexOf(ext);
        int sortIdx = columnList.indexOf(sort_by);
        int[][] answer = Arrays.stream(data).filter(o1 -> o1[extIdx] < val_ext)
                .sorted((o1 ,o2) -> o1[sortIdx]-o2[sortIdx]).toArray(int[][]::new);

        return answer;
    }
}