package com.example.algorithm.level0;

// [PCCE 기출문제] 6번 / 물 부족
public class Solution238 {
    public static void main(String[] args) {
        int storage = 5141;
        int usage = 500;
        int[] change = {10, -10, 10, -10, 10, -10, 10, -10, 10, -10};
        // -1
        //int storage = 1000;
        //int usage = 2000;
        //int[] change = {-10, 25, -33};
        // 1

        System.out.println(solution(storage, usage, change));
    }

    public static int solution(int storage, int usage, int[] change) {
        int total_usage = 0;
        for(int i=0; i<change.length; i++){
            usage += usage * change[i] / 100;
            total_usage += usage;
            if(total_usage > storage){
                return i;
            }
        }
        return -1;
    }
}