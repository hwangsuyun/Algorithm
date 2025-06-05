package com.example.algorithm.level0;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 배열 만들기 4
public class Solution190 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3}; //	[1, 2, 3]

        if (arr.length < 1 || arr.length > 100000) return;
        for (int i : arr) {
            if (i < 1 || i > 100000) return;
        }

        int[] result = solution(arr);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (list.size() == 0) list.add(arr[i]);
            else if (list.get(list.size() - 1) < arr[i]) list.add(arr[i]);
            else if (list.get(list.size() - 1) >= arr[i]) {
                list.remove(list.size() - 1);
                i -= 1;
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static int[] solution2(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (int num : arr) {
            while (!stack.isEmpty() && num <= stack.peek())
                stack.pop();
            stack.push(num);
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}