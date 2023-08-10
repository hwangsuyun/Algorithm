package programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

// 디펜스 게임
public class Solution66 {
    public static void main(String[] args) {
        int n = 7;
        int k = 3;
        int[] enemy = {4, 2, 4, 5, 3, 3, 1};
        // 5
        //int n = 2;
        //int k = 4;
        //int[] enemy = {3, 3, 3, 3};
        // 4
        //int n = 10;
        //int k = 3;
        //int[] enemy = {12, 11, 4, 2, 1, 5, 8, 6, 7};
        // 6

        if (n < 1 || n > 1000000000) return;
        if (k < 1 || k > 500000) return;
        if (enemy.length < 1 || enemy.length > 1000000) return;
        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i] < 1 || enemy[i] > 1000000) return;
        }

        System.out.println(solution(n, k, enemy));
    }

    public static int solution(int n, int k, int[] enemy) {
        // 1.enemy 를 반복하면서 더한 값이 n 을 넘어서면 그 enemy 까지의 우선순위를 구해야 한다.
        // ex) n = 7, k = 3, enemy = {4, 2, 4, 5, 3, 3, 1} 일 때는 최초 4, 2, 4 까지 갔을 때 우선 순위 구함
        // 여기서 우선 순위가 젤 높은 4 를 k 를 사용
        // 2.1을 반복
        // n = 7, k = 2, enemy = {0, 2, 4, 5, 3, 3, 1}, 2, 4, 5 우선 순위 구함
        // 우선 순위가 젤 높은 5를 k 를 사용
        // n = 7, k = 1, enemy = {0, 2, 4, 0, 3, 3, 1}, 2, 4, 3 우선 순위 구함
        // 우선 순위가 젤 높은 5를 k 를 사용
        // n = 7, k = 1, enemy = {0, 2, 0, 0, 3, 3, 1}, 2, 3, 3 우선 순위 구함
        // k == 0 이므로 순차적으로 n에서 마이너스 처리
        // n = 2, k = 1, enemy = {0, 0, 0, 0, 0, 3, 1}, n 이 3보다 작으므로 종료

        Queue<Integer> priQueue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0, sum = 0;

        for (int i = 0; i < enemy.length; i++) {
            sum += enemy[i];
            priQueue.add(enemy[i]);
            // 1.enemy 를 반복하면서 더한 값이 n 을 넘어서면 그 enemy 까지의 우선순위를 구해야 한다.
            if (n < sum) {
                if (k > 0) {
                    // 2. 우선 순위를 구하고 k--, sum -= max, enemy 의 값을 0으로 변경
                    int max = priQueue.poll();
                    sum -= max;
                    k--;

                    for (int j = i; j >= 0; j--) {
                        if (max == enemy[j]) {
                            enemy[j] = 0;
                            break;
                        }
                    }
                } else {
                    break;
                }
            }
        }

        // 3. k (무적권) 을 다 사용하고 n 으로 값을 비교한다.
        for (int i = 0; i < enemy.length; i++) {
            if (enemy[i] == 0) continue;
            n -= enemy[i];
            if (n < 0) {
                answer = i;
                break;
            }
        }

        if (n >= 0) return enemy.length;
        return answer;
    }
}