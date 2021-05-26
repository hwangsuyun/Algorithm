package programmers.level2;

import java.util.Collections;
import java.util.PriorityQueue;

// 라면공장
public class Solution21 {
	public static void main(String[] args) {
		int stock = 4;
		//int[] dates = {4, 10, 15};
		//int[] supplies = {20, 5, 10};
		//int k = 30;
		int[] dates = {1, 2, 3, 4};
		int[] supplies = {10, 40, 30, 20};
		int k = 100;
		if (stock < 2 || stock > 100000) return;
		if (k < 2 || k > 100000) return;
		for (int i = 0; i < dates.length; i++) {
			if (dates[i] < 1 || dates[i] > k) return;
		}
		for (int i = 0; i < supplies.length; i++) {
			if (supplies[i] < 1 || supplies[i] > 1000) return;
		}
		if (dates.length < 1 || dates.length > 20000) return;
		if (supplies.length < 1 || supplies.length > 20000) return;
		solution(stock, dates, supplies, k);
	}
	
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
		if (stock >= k) return 0;
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		int result = 0, index = 0;
		for (int i = 0; i < k; i++) {
			if (index < dates.length && i == dates[index]) {
				queue.add(supplies[index]);
				index++;
			}
			if (stock == 0) {
				stock += queue.poll();
				result++;
			}
			stock--;
		}
		System.out.println(result);
		return result;
	}
}
