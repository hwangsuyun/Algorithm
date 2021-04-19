package programmers.level1;

// 콜라츠 추측
public class Solution29 {
	static int count;
	public static void main(String[] args) {
		//long num = 626332;
		long num = 626331;
		if (num < 1 || num > 8000000) return;
		System.out.println(solution(num));
	}
	
	public static int solution(long num) {
		if (num == 0) return 0;
		if (num == 1) return count;
		if (count >= 450) {
			count = -1;
			return count;
		}
		count++;
		
		if (num % 2 == 0) solution(num / 2);
		else if (num % 2 == 1) solution(num * 3 + 1);
		
		return count;
	}
}
