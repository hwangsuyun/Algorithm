package com.example.algorithm.level0;

import java.util.Arrays;

// 조건에 맞게 수열 변환하기 2
public class Solution153 {
    public static void main(String[] args) {
        int[] num_list = {1, 2, 3, 100, 99, 98}; // 5

        if (num_list.length < 1 || num_list.length > 1000000) return;
        for (int num : num_list) {
            if (num < 1 || num > 100) return;
        }

        System.out.println(solution(num_list));
    }

    public static int solution(int[] arr) {
        int answer = 0;
        int count = 0;
        int[] newArr = new int[arr.length];

        while (count < arr.length) {
            count = 0;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    newArr[i] = arr[i] / 2;
                } else if (arr[i] < 50 && arr[i] % 2 != 0){
                    newArr[i] = arr[i] * 2 + 1;
                } else {
                    newArr[i] = arr[i];
                }

                if (newArr[i] == arr[i]) {
                    count++;
                } else {
                    arr[i] = newArr[i];
                }
            }

            answer++;
        }

        return answer - 1;
    }

    public static int solution2(int[] arr) {
        return Arrays.stream(arr).map(i -> cntAction(i)).max().getAsInt();
    }

    private static int cntAction(int n) {
        int cnt = 0;
        boolean flag = true;

        while (flag) {
            if (n % 2 == 0 && 50 <= n) {
                n /= 2;
                cnt++;
            } else if (n % 2 == 1 && n < 50) {
                n *= 2;
                n += 1;
                cnt++;
            } else {
                flag = false;
            }
        }
        return cnt;
    }
}