package programmers.level2;

import java.util.LinkedList;

// «¡∏∞≈Õ
public class Solution7 {
	public static void main(String[] args) {
		//int[] priorities = {2, 1, 3, 2};
		//int location = 2;
		int[] priorities = {1, 1, 9, 1, 1, 1};
		int location = 0;
		//int[] priorities = {1, 7, 9, 1};
		//int location = 2;
		if (priorities.length < 1 || priorities.length > 100) return;
		for (int i = 0; i < priorities.length; i++) {
			if (priorities[i] < 1 || priorities[i] > 9) return;
		}
		if (location < 0 || location > priorities.length - 1) return;
		solution(priorities, location);
	}
	
	public static int solution(int[] priorities, int location) {
		LinkedList<Integer> queue = new LinkedList<>();
		LinkedList<Integer> list = new LinkedList<>();
		int peek = 0, index = 0, result = 0;
		for (int i = 0; i < priorities.length; i++) {
			queue.offer(i);
			list.offer(priorities[i]);
		}
		
		peek = list.peek();
		while (list.size() > 0) {
			for (int i = 1; i < list.size(); i++) {
				if (peek < list.get(i)) {
					list.offer(list.poll());
					peek = list.peek();
					queue.offer(queue.get(index));
					queue.remove(index);
					i = 0;
				}
			}
			list.removeFirst();
			index++;
			if (!list.isEmpty()) peek = list.peek();
		}

		for (int i = 0; i < queue.size(); i++) {
			if (location == queue.get(i)) {
				result = i + 1;
				break;
			}
		}
		System.out.println(result);
		return result;
	}
}
