package com.example.algorithm.level2;

// 2개 이하로 다른 비트
public class Solution99_1 {
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
        /*
        << : 피연산자의 비트열을 왼쪽으로 이동시키며 이동에 따른 빈공간은 0으로 채움.
        >> : 피연산자의 비트열을 오른쪽으로 이동시키며, 이동에 따른 빈공간은 음수의경우엔 1, 양수의 경우엔 0으로 채움.
        >>> : 피연산자의 비트열을 오른쪽으로 이동시키며, 이동에 따른 빈공간은 0으로 채움.

        >>>2 쓰는 이유가 4로 나누는거랑 비슷한 효과(java 에선 정수를 나누면 버림으로 계산 하기 때문에)를 가질 수 있어서
        / 4로 해도 되지만 그냥 비트에 맞춰서 쉬프트.
        우선 주어진 수 X보다 큰 수 중이기 때문에 최소 +1이상의 수가 필요 하므로 X(풀이에선 answer[i])를 증가시키고
        X와 X+1을 XOR 하면 X를 하나 증가시키면서 변화하는 부분을 캐치가 가능해진다.
        그런데 생각해보면 변화하는 부분이란 X의 비트 1의 자리부터 시작해서 처음으로 0이 나오는 부분까지 밖에 변화가 없으므로
        0을 바로 찾을 수 있고 모든 비트가 1로 이루어진(1로 이루어졌다고 하지만 0001111 이런 식으로 중간에 0이 안들어간다는 이야기이다.)
        숫자가 나오며 이 숫자를 X+1에 더해주면 0 앞에 를 제외한 밑에는 모든 비트가 같아지며 쉬프트를 1번 했을 경우 1개 이하로 다른 비트
        2번하면 2개 이하로 다른 비트 3번 하면 3개 이하로 다른 비트가 나오는 형태가 된다.
         */
        long[] answer = numbers.clone();
        for (int i = 0; i< answer.length; i++) {
            answer[i]++;
            answer[i] += (answer[i] ^ numbers[i]) >>> 2;
        }
        return answer;
    }
}