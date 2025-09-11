package com.example.algorithm.level2;

// [PCCP 기출문제] 3번 / 아날로그 시계
public class Solution82 {
    public static void main(String[] args) {
        int h1 = 0, m1 = 5, s1 = 30, h2 = 0, m2 = 7, s2 = 0;
        // 2
        //int h1 = 12, m1 = 0, s1 = 0, h2 = 12, m2 = 0, s2 = 30;
        // 1
        //int h1 = 0, m1 = 6, s1 = 1, h2 = 0, m2 = 6, s2 = 6;
        // 0
        //int h1 = 11, m1 = 59, s1 = 30, h2 = 12, m2 = 0, s2 = 0;
        // 1
        //int h1 = 11, m1 = 58, s1 = 59, h2 = 11, m2 = 59, s2 = 0;
        // 1
        //int h1 = 1, m1 = 5, s1 = 5, h2 = 1, m2 = 5, s2 = 6;
        // 2
        //int h1 = 0, m1 = 0, s1 = 0, h2 = 23, m2 = 59, s2 = 59;
        // 2852

        System.out.println(solution(h1, m1, s1, h2, m2, s2));
    }

    public static int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = getCountFromMidnight(h2, m2, s2) - getCountFromMidnight(h1, m1, s1);
        //0시와 12시인경우에만 예외적으로 1씩 더해줌
        if ((h1 == 0 || h1 == 12) && m1 == 0 && s1 == 0) answer += 1;
        return answer;
    }

    private static int getCountFromMidnight(int hour, int minute, int second) {
        int ret = -1; //0시0분0초는 분에 한번이므로 -1로 시작
        double hourAngle = (hour * 30 + minute * 0.5 + second * 0.5 / 60) % 360;
        double minuteAngle = minute * 6 + second * 0.1;
        double secondAngle = second * 6;

        // 마지막 분의 상태를 계산
        if (secondAngle >= minuteAngle) ret += 1;
        if (secondAngle >= hourAngle) ret += 1;

        //분당 2번씩 만난다고 계산
        ret += (hour * 60 + minute) * 2;
        //59분 -> 0분일때는 분침과 만나지 않음
        ret -= hour;
        // 11시59분59초 -> 12시인경우 분,초침과 만나지않고 12시에 2번이아닌 1번만 만나는걸로 처리
        if (hour >= 12) ret -= 2;
        return ret;
    }
}