package com.example.algorithm.level0;

// [PCCE 기출문제] 5번 / 산책
public class Solution228 {
    public static void main(String[] args) {
        String route = "NSSNEWWN"; // [-1, 1]
        //String route = "EESEEWNWSNWWNS"; // [0, 0]

        if (route.length() < 1 || route.length() > 20) return;

        int[] result = solution(route);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String route) {
        int east = 0;
        int north = 0;
        int[] answer = new int [2];
        for(int i=0; i<route.length(); i++){
            switch(route.charAt(i)){
                case 'N':
                    north++;
                    break;
                case 'S':
                    north--;
                    break;
                case 'E':
                    east++;
                    break;
                case 'W':
                    east--;
                    break;
            }
        }
        answer[0] = east;
        answer[1] = north;
        return answer;
    }
}