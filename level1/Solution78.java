package com.example.algorithm.level1;

// [PCCE 기출문제] 9번 / 지폐 접기
public class Solution78 {
    public static void main(String[] args) {
        //int[] wallet = {30, 15};
        //int[] bill = {26, 17};
        // 1
        int[] wallet = {50, 50};
        int[] bill = {100, 241};
        // 4

        if (wallet.length != 2 && bill.length != 2) return;
        for (int i = 0; i < wallet.length; i++) {
            if (wallet[i] < 10 || wallet[i] > 100) return;
        }
        for (int i = 0; i < bill.length; i++) {
            if (bill[i] < 10 || bill[i] > 2000) return;
        }

        System.out.println(solution(wallet, bill));
    }

    public static int solution(int[] wallet, int[] bill) {
        int answer = 0;
        while (Math.min(bill[0], bill[1]) > Math.min(wallet[0], wallet[1])
                || Math.max(bill[0], bill[1]) > Math.max(wallet[0], wallet[1])) {
            if (bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            answer++;
        }
        return answer;
    }
}