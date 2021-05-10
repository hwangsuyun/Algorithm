package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

// 다리를 지나는 트럭
public class Solution6 {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7, 4, 5, 6};
		//int bridge_length = 100;
		//int weight = 100;
		//int[] truck_weights = {10};
		//int bridge_length = 100;
		//int weight = 100;
		//int[] truck_weights = {10, 10, 10, 10, 10, 10, 10, 10, 10, 10};
		if (bridge_length < 1 || bridge_length > 10000) return;
		if (weight < 1 || weight > 10000) return;
		if (truck_weights.length < 1 || truck_weights.length > 10000) return;
		for (int i = 0; i < truck_weights.length; i++) {
			if (truck_weights[i] > weight) return;
		}
		solution(bridge_length, weight, truck_weights);
	}
 
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		// 다리(bridge)
		Queue<Integer> bridgeQueue = new LinkedList<>();
		Queue<Integer> truckQueue = new LinkedList<>();
		int time = 0, sum = 0, totWeight = 0;
		for (int i = 0; i < bridge_length; i++) {
			bridgeQueue.offer(0);
		}
		for (int i = 0; i < truck_weights.length; i++) {
			truckQueue.offer(truck_weights[i]);
		}
		
		while (!(truckQueue.size() == 0 && totWeight == 0)) {
			time++;
			totWeight -= bridgeQueue.peek();
			bridgeQueue.poll();
			if (truckQueue.size() != 0 && totWeight + truckQueue.peek() <= weight) {
				bridgeQueue.offer(truckQueue.peek());
				totWeight += truckQueue.peek();
				truckQueue.poll();
			} else {
				bridgeQueue.offer(0);
			}
		}
		System.out.println(time);
		return time;
	}
}


