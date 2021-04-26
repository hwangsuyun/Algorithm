package programmers.level1;

import java.util.Arrays;

// ¿¹»ê
public class Solution36 {
	public static void main(String[] args) {
		int[] d = {1, 3, 2, 5, 4};
		int budget = 9;
		//int[] d = {2, 2, 3, 3};
		//int budget = 10;
		//int[] d = {11, 11, 11, 11};
		//int budget = 10;
		if (d.length < 1 || d.length > 100) return;
		for (int i = 0; i < d.length; i++) {
			if (d[i] < 1 || d[i] > 100000) return;
		}
		if (budget < 1 || budget > 10000000) return;
		solution(d, budget);
	}
	
	public static int solution(int[] d, int budget) {
		int temp = 0, count = 0, result = 0;
		Arrays.sort(d);
		for (int i = 0; i < d.length; i++) {
			temp = d[i];
			count++;
			if (temp > budget) {
				count--;
				continue;
			} else {
				for (int j = i + 1; j < d.length; j++) {
					if (temp == budget) break;
					else if (temp > budget) {
						count--;
						break;
					}
					temp += d[j];
					count++;
				}
				if (result <= count) result = count;
				count = 0;
			}
		}
		System.out.println(result);
		return result;
	}
}
