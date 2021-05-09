package programmers.level2;

// 주식가격
public class Solution4 {
	public static void main(String[] args) {
		int[] prices = {498, 501, 470, 489};
		//int[] prices = {1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3};
		if (prices.length < 2 || prices.length > 100000) return;
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] < 1 || prices[i] > 10000) return;
		}
		solution(prices);
	}
	
	public static int[] solution(int[] prices) {
		int[] result = new int[prices.length];
		int time = 0; 
		for (int i = 0; i < prices.length; i++) {
			for (int j = i + 1; j < result.length; j++) {
				if (i == prices.length - 1) break;
				time++;
				if (prices[i] > prices[j]) break;
			}
			result[i] = time;
			time = 0;
			System.out.println(result[i]);
		}
		return result;
	}
}
