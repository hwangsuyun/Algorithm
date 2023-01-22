package com.example.algorithm.level0;

// 연속된 수의 합
public class Solution3 {
    public static void main(String[] args) {
        //int num = 3, total = 12; // [3, 4, 5]
        //int num = 5, total = 15; // [1, 2, 3, 4, 5]
        //int num = 4, total = 14; // [2, 3, 4, 5]
        //int num = 5, total = 5; // [-1, 0, 1, 2, 3]
        //int num = 3, total = 0; // [-1, 0, 1]
        int num = 1, total = 5; // [5]

        if (num < 1 || num > 100) return;
        if (total < 0 || total > 1000) return;

        solution(num, total);
    }

    public static int[] solution(int num, int total) {
        int[] answer = new int[num];
        int count = 0, sum = 0, index = 0, start = -49;

        for (int i = start; i <= 150; i++) {
            if (count == num) {
                if (total == sum) {
                    for (int j = i - num; j < i; j++) {
                        answer[index] = j;
                        System.out.println(answer[index]);
                        index++;
                    }
                    return answer;
                } else {
                    count = 0;
                    sum = 0;
                    start++;
                    i = start - 1;
                }
            } else if (count < num) {
                sum += i;
                count++;
            }
        }
        return answer;
    }
}
