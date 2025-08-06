package com.example.algorithm.level0;

// [PCCE 기출문제] 7번 / 가습기
public class Solution226 {
    public static void main(String[] args) {
        String mode_type = "auto";
        int humidity = 23;
        int val_set = 45;
        // 3
        //String mode_type = "target";
        //int humidity = 41;
        //int val_set = 40;
        // 1
        //String mode_type = "minimum";
        //int humidity = 10;
        //int val_set = 34;
        // 1

        System.out.println(solution(mode_type, humidity, val_set));
    }

    public static int func1(int humidity, int val_set){
        if(humidity < val_set)
            return 3;
        return 1;
    }

    public static int func2(int humidity){
        if(humidity >= 50)
            return 0;
        else if (humidity >= 40)
            return 1;
        else if (humidity >= 30)
            return 2;
        else if (humidity >= 20)
            return 3;
        else if (humidity >= 10)
            return 4;
        else
            return 5;
    }

    public static int func3(int humidity, int val_set){
        if(humidity < val_set)
            return 1;
        return 0;
    }

    public static int solution(String mode_type, int humidity, int val_set) {
        int answer = 0;

        if(mode_type.equals("auto")){
            answer = func2(humidity);
        }
        else if(mode_type.equals("target")){
            answer = func1(humidity, val_set);
        }
        else if(mode_type.equals("minimum")){
            answer = func3(humidity, val_set);
        }

        return answer;
    }
}