package com.example.algorithm.level2;

// n^2 배열 자르기
public class Solution86 {
    public static void main(String[] args) {
        //int n = 3;
        //long left = 2;
        //long right = 5;
        // [3,2,2,3]
        int n = 4;
        long left = 7;
        long right = 14;
        // [4,3,3,3,4,4,4,4]

        int[] result = solution(n, left, right);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(int n, long left, long right) {
        // 1. n행 n열 크기의 비어있는 2차원 배열을 만든다.
        // 2. i = 1, 2, 3, ..., n에 대해서, 다음 과정을 반복한다.
        // 2.1 1행 1열부터 i행 i열 까지의 영역 내의 모든 빈 칸을 숫자 i로 채운다.
        // 3. 1행, 2행, ..., n행을 잘라내어 모두 이어붙인 새로운 1차원 배열을 만든다.
        // 4. 새로운 1차원 배열을 arr 이라 할 때, arr[left], arr[left+1], ..., arr[right]만 남기고 나머지는 지운다.

        // 1 2 3 4 5
        // 2 2 3 4 5
        // 3 3 3 4 5
        // 4 4 4 4 5
        // 5 5 5 5 5
        // (0,2) -> (1,2) -> (0,2),(1,0),(1,1),(1,2)
        // (1,3) -> (3,2) -> (1,3),(2,0),(2,1),(2,2),(2,3),(3,0),(3,1),(3,2)
        int[] answer = new int[(int) (right - left + 1)];
        long startX = left / n;
        long startY = left % n;
        long endX = right / n;
        long endY = right % n;
        int index = 0;

        for (long i = startX; i <= endX; i++) {
            for (long j = 0; j < n; j++) {
                if (i == startX && j < startY) continue;
                if (i == endX && j > endY) continue;
                answer[index++] = (int) Math.max(i, j) + 1;
            }
        }

        return answer;
    }
}