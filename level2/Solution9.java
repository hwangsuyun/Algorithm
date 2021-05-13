package programmers.level2;

import java.util.PriorityQueue;

// ´õ ¸Ê°Ô
public class Solution9 {
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 10;
		//int[] scoville = {0, 0, 0, 0, 3};
		//int K = 4;
		//int[] scoville = {0, 0, 1};
		//int K = 2;
		//int[] scoville = {1, 2};
		//int K = 3;
		if (scoville.length < 1 || scoville.length > 1000000) return;
		if (K < 0 || K > 1000000000) return;
		for (int i = 0; i < scoville.length; i++) {
			if (scoville[i] < 0 || scoville[i] > 1000000) return;
		}
		System.out.println(solution(scoville, K));
	}
	
	public static int solution(int[] scoville, int K) {
		PriorityQueue<Integer> queue = new PriorityQueue<>();
		int peek = 0, result = 0;
		for (int i = 0; i < scoville.length; i++) {
			queue.offer(scoville[i]);
		}
		if (queue.size() == 0) return 0;
		
		while (queue.size() > 0) {
			peek = queue.poll();
			if (peek < K) {
				if (!queue.isEmpty()) { 
					peek += (queue.poll() * 2);
					result++;
					queue.offer(peek);
				}
			}
		}
		if (peek < K) result = -1;
		return result;
	}
}
