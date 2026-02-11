package com.example.algorithm.level2;

// 2개 이하로 다른 비트
public class Solution99 {
    public static void main(String[] args) {
        //long[] numbers = {2, 7}; // [3,11]
        //long[] numbers = {15}; // [23]
        long[] numbers = {55}; // [59]
        //long[] numbers = {3}; // [5]

        long[] result = solution(numbers);
        for (long l : result) {
            System.out.println(l);
        }
    }

    public static long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        int index = 0;

        for (long number : numbers) {
            long result;
            String str = Long.toBinaryString(number);
            int lastIndex = -1;

            for (int i = 0; i < str.length(); i++){
                if (str.charAt(i) == '0') lastIndex = i;
            }

            // 0이 없는 경우
            if (lastIndex == -1) {
                result = Long.parseLong("10" + str.substring(1), 2);
            } else {
                // 제일 끝에 있는 경우
                if (lastIndex == str.length() - 1) {
                    result = Long.parseLong(str.substring(0, str.length() - 1) + "1", 2);
                } else {
                    // 가운데에 0이 있는 경우
                    result = Long.parseLong(str.substring(0, lastIndex) + "10" + str.substring(lastIndex + 2), 2);
                }
            }
            answer[index++] = result;
        }

        return answer;
    }
}