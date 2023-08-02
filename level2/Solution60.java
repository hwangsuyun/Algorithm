package programmers.level2;

import java.util.*;

// 숫자 변환하기
public class Solution60 {
    public static void main(String[] args) {
        int x = 10;
        int y = 40;
        int n = 5;
        // 2
        //int x = 10;
        //int y = 40;
        //int n = 30;
        // 1
        //int x = 2;
        //int y = 5;
        //int n = 4;
        // -1

        if (x < 1 || x > y) return;
        if (y < x || y > 1000000) return;
        if (n < 1 || n > y) return;

        System.out.println(solution(x, y, n));
    }

    public static int solution(int x, int y, int n) {
        // 1. queue 를 선언하여 bfs 방식으로 문제를 푼다.
        Queue<int[]> queue = new LinkedList<>();

        // 2. queue 에 y의 값과 연산 횟 수를 저장한다. 초기값 0
        queue.add(new int[] {y, 0});

        // 3. queue 를 순회한다.
        while (!queue.isEmpty()) {
            // 4. queue 에서 y 값을 빼낸다.
            int[] array = queue.poll();
            int qy = array[0];

            // 5.queue 의 y값과 x값을 비교한다.
            if (qy == x) {
                // 5.1 y 와 x 가 같다면 연산 횟 수를 반환한다.
                return array[1];
            } else if (qy < x) {
                // 5.2 y 보다 x 가 크다면 반복한다.
                continue;
            }

            // 5.3 y 보다 x 가 작다면 연산을 시작한다.
            // 6. y 를 3으로 나눈 나머지가 0이면?
            if (qy % 3 == 0) {
                // 6.1 y / 3, 연산 횟수 array[1] 에 +1을 하여 queue 에 담는다.
                int temp = array[1];
                queue.add(new int[] {qy / 3, ++temp});
            }
            // 7. y 를 2로 나눈 나머지가 0이면?
            if (qy % 2 == 0) {
                // 7.1 y / 2, 연산 횟수 array[1] 에 +1을 하여 queue 에 담는다.
                int temp = array[1];
                queue.add(new int[] {qy / 2, ++temp});
            }
            // 8. y - n 이 x 보다 크거나 같으면?
            if (qy - n >= x) {
                // 8.1 qy - n, 연산 횟수 array[1] 에 +1을 하여 queue 에 담는다.
                int temp = array[1];
                queue.add(new int[] {qy - n, ++temp});
            }
        }

        return -1;
    }
}