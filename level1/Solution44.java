package programmers.level1;

import java.util.ArrayList;

// 3진법 뒤집기
public class Solution44 {
	public static void main(String[] args) {
		//int n = 45; // 7
		int n = 125; // 229
		if (n < 1 || n > 100000000) return;
		
		System.out.println(solution(n));
	}
	
	public static int solution(int n) {
		int answer = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while (true) {
			list.add(n % 3);
			//System.out.println("n : " + n);
			//System.out.println("n % 3: " + n % 3);
			n /= 3;
			if (n <= 0) break;
		}
		
		for (int i = 0; i < list.size(); i++) {
			answer += Math.pow(3, list.size() - i - 1) * list.get(i);
		}
		
		return answer;
	}
	
	
}
