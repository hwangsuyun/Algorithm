package programmers.level1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// ½ÇÆÐÀ²
public class Solution40 {
	public static void main(String[] args) {
		//int N = 5;
		//int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		//int N = 4;
		//int[] stages = {4, 4, 4, 4, 4};
		int N = 8;
		int[] stages = {1, 2, 3, 4, 5, 6, 7};
		if (N < 1 || N > 500) return;
		if (stages.length < 1 || stages.length > 200000) return;
		for (int i = 0; i < stages.length; i++) {
			if (stages[i] < 1 || stages[i] > N + 1) return;
		}
		solution(N, stages);
	}
	
	public static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];
		int count = 0;
		int size = 0;
		List<Double> temp = new ArrayList<>();
		Map<Integer, Double> map = new HashMap<>();
		
		size = stages.length;
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < stages.length; j++) {
				if (i == stages[j]) {
					count++;
					continue;
				}
			}
			if (size != 0) {
				map.put(i, count / (double) size);
			} else {
				map.put(i, 0.0);
			}
			
			size -= count;
			temp.add(map.get(i));
			count = 0;
		}
		Collections.sort(temp);
		
		count = 0;
		size = map.size() - 1;
		while (size >= 0) {
			for (int i = 1; i <= map.size(); i++) {
				if (temp.get(size) - map.get(i) == 0) {
					answer[count] = i;
					map.put(i, -9.9999);
					System.out.print(answer[count] + ", ");
					count++;
					break;
				}
			}
			size--;
		}
        return answer;
	}
}
