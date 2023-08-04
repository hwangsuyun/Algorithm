package programmers.level2;

import java.util.Stack;

// 택배 배달과 수거하기
public class Solution62 {
    public static void main(String[] args) {
        //int cap = 4;
        //int n = 5;
        //int[] deliveries = {1, 0, 3, 1, 2};
        //int[] pickups = {0, 3, 0, 4, 0};
        // 16
        int cap = 2;
        int n = 7;
        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
        int[] pickups = {0, 2, 0, 1, 0, 2, 0};
        // 30

        if (cap < 1 || cap > 50) return;
        if (n < 1 || n > 100000) return;
        if (deliveries.length != pickups.length && deliveries.length != n) return;
        for (int i = 0; i < deliveries.length; i++) {
            if (deliveries[i] < 0 || deliveries[i] > 50) return;
        }
        for (int i = 0; i < pickups.length; i++) {
            if (pickups[i] < 0 || pickups[i] > 50) return;
        }

        System.out.println(solution(cap, n, deliveries, pickups));
    }

    public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
        /*
        	            집#1	집#2	집#3	집#4	집#5	집#6	집#7	설명
        남은 배달/수거	1/0	    0/2	    2/0	    0/1     1/0	    0/2	    2/0	    물류창고에서 택배 2개를 트럭에 실어 출발합니다.
        남은 배달/수거	1/0	    0/2	    2/0	    0/1	    1/0	    0/2	    0/0	    물류창고에서 7번째 집까지 이동하면서(거리 7) 7번째 집에 택배 2개를 배달합니다.
        남은 배달/수거	1/0	    0/2	    2/0	    0/1	    1/0	    0/0	    0/0	    7번째 집에서 물류창고까지 이동하면서(거리 7) 6번째 집에서 빈 택배 상자 2개를 수거한 후,
                                                                                수거한 빈 택배 상자를 물류창고에 내리고 택배 2개를 트럭에 싣습니다.
        남은 배달/수거	1/0	    0/2	    1/0	    0/1	    0/0	    0/0	    0/0	    물류창고에서 5번째 집까지 이동하면서(거리 5) 3번째 집에 택배 1개를 배달하고, 5번째 집에 택배 1개를 배달합니다.
        남은 배달/수거	1/0	    0/1	    1/0	    0/0	    0/0	    0/0	    0/0	    5번째 집에서 물류창고까지 이동하면서(거리 5) 4번째 집에서 빈 택배 상자 1개를 수거하고 2번째 집에서 빈 택배 상자 1개를 수거한 후,
                                                                                수거한 빈 택배 상자를 물류창고에 내리고 택배 2개를 트럭에 싣습니다.
        남은 배달/수거	0/0	    0/1	    0/0	    0/0	    0/0	    0/0	    0/0	    물류창고에서 3번째 집까지 이동하면서(거리 3) 1번째 집에 택배 1개를 배달하고, 3번째 집에 택배 1개를 배달합니다.
        남은 배달/수거	0/0	    0/0	    0/0	    0/0	    0/0	    0/0	    0/0	    3번째 집에서 물류창고까지 이동하면서(거리 3) 2번째 집에서 빈 택배 상자 1개를 수거한 후, 수거한 빈 택배 상자를 물류창고에 내립니다.
         */

        long answer = 0;
        Stack<Integer> deliveryStack = new Stack<>();
        Stack<Integer> pickupStack = new Stack<>();
        int box = 0, distance = 0;

        for (int i : deliveries) deliveryStack.push(i);
        for (int i : pickups) pickupStack.push(i);

        while (deliveries[n - 1] == 0 && pickups[n - 1] == 0) {
            deliveryStack.pop();
            pickupStack.pop();
            n--;
            if (n == 0) break;
        }

        distance = n;
        while (!deliveryStack.isEmpty() || !pickupStack.isEmpty()) {
            while (!deliveryStack.isEmpty()) {
                box += deliveryStack.pop();
                if (box > cap) {
                    deliveryStack.push(box - cap);
                    break;
                }
            }

            box = 0;
            while (!pickupStack.isEmpty()) {
                box += pickupStack.pop();
                if (box > cap) {
                    pickupStack.push(box - cap);
                    break;
                }
            }

            box = 0;
            answer += distance;
            distance = Math.max(deliveryStack.size(), pickupStack.size());
        }
        return answer * 2;
    }
}