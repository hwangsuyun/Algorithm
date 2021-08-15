package oncoder;

// 사칙연산
public class Solution3_1 {
	public static void main(String[] args) {
		//int x = 7, y = 8, val = 16; // 9
		//int x = 100, y = 1, val = 10000; // 12
		int x = -100, y = 100, val = 2; // 0
		//int x = 3, y = 5, val = 7; // 5
		
		if (x < -100 || x > 100) return;
		if (y < -100 || y > 100) return;
		if (x == y) return;
		if (val < -100000000 || val > 100000000) return;
		
		System.out.println(solution(x, y, val));
		
	}
		
	public static int solution(int x, int y, int val) {
		int answer = 0;
		char[][] op = {
				{'+', '+', '+'}, {'+', '+', '-'}, {'+', '-', '+'}, 
				{'+', '-', '-'}, {'+', '+', '*'}, {'+', '*', '+'},
				{'+', '*', '*'}, {'*', '-', '-'}, {'*', '-', '*'}, 
				{'*', '*', '-'}, {'*', '+', '+'}, {'*', '+', '*'},
				{'*', '*', '+'}, {'*', '*', '*'}, {'+', '-', '*'}, 
				{'+', '*', '-'}, {'*', '+', '-'}, {'*', '-', '+'},
				{'-', '-', '-'}, {'-', '-', '+'}, {'-', '+', '-'}, 
				{'-', '+', '+'}, {'-', '-', '*'}, {'-', '*', '-'},
				{'-', '*', '*'}, {'-', '+', '*'}, {'-', '*', '+'},   
			};		
		
		int[][] xy = {
				{x, x, y, y},
				{x, y, x, y}, 
				{x, y, y, x},
				{y, y, x, x},
				{y, x, y, x},
				{y, x, x, y},
			};
		
		// x, x, y, y
		if (x + x + y + y == val) {
			System.out.println(x + "+" + x + "+" + y + "+" + y);
			answer++; 
		}
		if (x + x + y - y == val) {
			System.out.println(x + "+" + x + "+" + y + "-" + y);
			answer++;
		}
		if (x + x - y + y == val) {
			System.out.println(x + "+" + x + "-" + y + "+" + y);
			answer++;
		}
		if (x + x - y - y == val) {
			System.out.println(x + "+" + x + "-" + y + "-" + y);
			answer++;
		}
		if ((x + x + y) * y == val) {
			System.out.println(x + "+" + x + "+" + y + "*" + y);
			answer++;
		}
		if ((x + x) * y + y == val) {
			System.out.println(x + "+" + x + "*" + y + "+" + y);
			answer++;
		}
		if ((x + x) * y * y == val) {
			System.out.println(x + "+" + x + "*" + y + "*" + y);
			answer++;
		}
		if (x * x - y - y == val) {
			System.out.println(x + "*" + x + "-" + y + "-" + y);
			answer++;
		}
		if ((x * x - y) * y == val) {
			System.out.println(x + "*" + x + "-" + y + "*" + y);
			answer++;
		}
		if (x * x * y - y == val) {
			System.out.println(x + "*" + x + "*" + y + "-" + y);
			answer++;
		}
		if (x * x + y + y == val) {
			System.out.println(x + "*" + x + "+" + y + "+" + y);
			answer++;
		}
		if ((x * x + y) * y == val) {
			System.out.println(x + "*" + x + "+" + y + "*" + y);
			answer++;
		}
		if (x * x * y + y == val) {
			System.out.println(x + "*" + x + "*" + y + "+" + y);
			answer++;
		}
		if (x * x * y * y == val) {
			System.out.println(x + "*" + x + "*" + y + "*" + y);
			answer++;
		}
		if ((x + x - y) * y == val) {
			System.out.println(x + "+" + x + "-" + y + "*" + y);
			answer++;
		}
		if ((x + x) * y - y == val) {
			System.out.println(x + "+" + x + "*" + y + "-" + y);
			answer++;
		}
		if (x * x + y - y == val) {
			System.out.println(x + "*" + x + "+" + y + "-" + y);
			answer++;
		}
		if (x * x - y + y == val) {
			System.out.println(x + "*" + x + "-" + y + "+" + y);
			answer++;
		}
		if (x - x - y - y == val) {
			System.out.println(x + "-" + x + "-" + y + "-" + y);
			answer++;
		}
		if (x - x - y + y == val) {
			System.out.println(x + "-" + x + "-" + y + "+" + y);
			answer++;
		}
		if (x - x + y - y == val) {
			System.out.println(x + "-" + x + "+" + y + "-" + y);
			answer++;
		}
		if (x - x + y + y == val) {
			System.out.println(x + "-" + x + "+" + y + "+" + y);
			answer++;
		}
		if ((x - x - y) * y == val) {
			System.out.println(x + "-" + x + "-" + y + "*" + y);
			answer++;
		}
		if ((x - x) * y - y == val) {
			System.out.println(x + "-" + x + "*" + y + "-" + y);
			answer++;
		}
		if ((x - x) * y * y == val) {
			System.out.println(x + "-" + x + "*" + y + "*" + y);
			answer++;
		}
		if ((x - x + y) * y == val) {
			System.out.println(x + "-" + x + "+" + y + "*" + y);
			answer++;
		}
		if ((x - x) * y + y == val) {
			System.out.println(x + "-" + x + "*" + y + "+" + y);
			answer++;
		}
		
		
		// x, y, x, y 
		if (x + y + x + y == val) {
			System.out.println(x + "+" + y + "+" + x + "+" + y);
			answer++; 
		}
		if (x + y + x - y == val) {
			System.out.println(x + "+" + y + "+" + x + "-" + y);
			answer++;
		}
		if (x + y - x + y == val) {
			System.out.println(x + "+" + y + "-" + x + "+" + y);
			answer++;
		}
		if (x + y - x - y == val) {
			System.out.println(x + "+" + y + "-" + x + "-" + y);
			answer++;
		}
		if ((x + y + x) * y == val) {
			System.out.println(x + "+" + y + "+" + x + "*" + y);
			answer++;
		}
		if ((x + y) * x + y == val) {
			System.out.println(x + "+" + y + "*" + x + "+" + y);
			answer++;
		}
		if ((x + y) * x * y == val) {
			System.out.println(x + "+" + y + "*" + x + "*" + y);
			answer++;
		}
		if (x * y - x - y == val) {
			System.out.println(x + "*" + y + "-" + x + "-" + y);
			answer++;
		}
		if ((x * y - x) * y == val) {
			System.out.println(x + "*" + y + "-" + x + "*" + y);
			answer++;
		}
		if (x * y * x - y == val) {
			System.out.println(x + "*" + y + "*" + x + "-" + y);
			answer++;
		}
		if (x * y + x + y == val) {
			System.out.println(x + "*" + y + "+" + x + "+" + y);
			answer++;
		}
		if ((x * y + x) * y == val) {
			System.out.println(x + "*" + y + "+" + x + "*" + y);
			answer++;
		}
		if (x * y * x + y == val) {
			System.out.println(x + "*" + y + "*" + x + "+" + y);
			answer++;
		}
		if (x * y * x * y == val) {
			System.out.println(x + "*" + y + "*" + x + "*" + y);
			answer++;
		}
		if ((x + y - x) * y == val) {
			System.out.println(x + "+" + y + "-" + x + "*" + y);
			answer++;
		}
		if ((x + y) * x - y == val) {
			System.out.println(x + "+" + y + "*" + x + "-" + y);
			answer++;
		}
		if (x * y + x - y == val) {
			System.out.println(x + "*" + y + "+" + x + "-" + y);
			answer++;
		}
		if (x * y - x + y == val) {
			System.out.println(x + "*" + y + "-" + x + "+" + y);
			answer++;
		}		
		if (x - y - x - y == val) {
			System.out.println(x + "-" + y + "-" + x + "-" + y);
			answer++;
		}
		if (x - y - x + y == val) {
			System.out.println(x + "-" + y + "-" + x + "+" + y);
			answer++;
		}
		if (x - y + x - y == val) {
			System.out.println(x + "-" + y + "+" + x + "-" + y);
			answer++;
		}
		if (x - y + x + y == val) {
			System.out.println(x + "-" + y + "+" + x + "+" + y);
			answer++;
		}
		if ((x - y - x) * y == val) {
			System.out.println(x + "-" + y + "-" + x + "*" + y);
			answer++;
		}
		if ((x - y) * x - y == val) {
			System.out.println(x + "-" + y + "*" + x + "-" + y);
			answer++;
		}
		if ((x - y) * x * y == val) {
			System.out.println(x + "-" + y + "*" + x + "*" + y);
			answer++;
		}
		if ((x - y + x) * y == val) {
			System.out.println(x + "-" + y + "+" + x + "*" + y);
			answer++;
		}
		if ((x - y) * x + y == val) {
			System.out.println(x + "-" + y + "*" + x + "+" + y);
			answer++;
		}
		
		
		// x, y, y, x
		if (x + y + y + x == val) {
			System.out.println(x + "+" + y + "+" + y + "+" + x);
			answer++; 
		}
		if (x + y + y - x == val) {
			System.out.println(x + "+" + y + "+" + y + "-" + x);
			answer++;
		}
		if (x + y - y + x == val) {
			System.out.println(x + "+" + y + "-" + y + "+" + x);
			answer++;
		}
		if (x + y - y - x == val) {
			System.out.println(x + "+" + y + "-" + y + "-" + x);
			answer++;
		}
		if ((x + y + y) * x == val) {
			System.out.println(x + "+" + y + "+" + y + "*" + x);
			answer++;
		}
		if ((x + y) * y + x == val) {
			System.out.println(x + "+" + y + "*" + y + "+" + x);
			answer++;
		}
		if ((x + y) * y * x == val) {
			System.out.println(x + "+" + y + "*" + y + "*" + x);
			answer++;
		}
		if (x * y - y - x == val) {
			System.out.println(x + "*" + y + "-" + y + "-" + x);
			answer++;
		}
		if ((x * y - y) * x == val) {
			System.out.println(x + "*" + y + "-" + y + "*" + x);
			answer++;
		}
		if (x * y * y - x == val) {
			System.out.println(x + "*" + y + "*" + y + "-" + x);
			answer++;
		}
		if (x * y + y + x == val) {
			System.out.println(x + "*" + y + "+" + y + "+" + x);
			answer++;
		}
		if ((x * y + y) * x == val) {
			System.out.println(x + "*" + y + "+" + y + "*" + x);
			answer++;
		}
		if (x * y * y + x == val) {
			System.out.println(x + "*" + y + "*" + y + "+" + x);
			answer++;
		}
		if (x * y * y * x == val) {
			System.out.println(x + "*" + y + "*" + y + "*" + x);
			answer++;
		}
		if ((x + y - y) * x == val) {
			System.out.println(x + "+" + y + "-" + y + "*" + x);
			answer++;
		}
		if ((x + y) * y - x == val) {
			System.out.println(x + "+" + y + "*" + y + "-" + x);
			answer++;
		}
		if (x * y + y - x == val) {
			System.out.println(x + "*" + y + "+" + y + "-" + x);
			answer++;
		}
		if (x * y - y + x == val) {
			System.out.println(x + "*" + y + "-" + y + "+" + x);
			answer++;
		}		
		if (x - y - y - x == val) {
			System.out.println(x + "-" + y + "-" + y + "-" + x);
			answer++;
		}
		if (x - y - y + x == val) {
			System.out.println(x + "-" + y + "-" + y + "+" + x);
			answer++;
		}
		if (x - y + y - x == val) {
			System.out.println(x + "-" + y + "+" + y + "-" + x);
			answer++;
		}
		if (x - y + y + x == val) {
			System.out.println(x + "-" + y + "+" + y + "+" + x);
			answer++;
		}
		if ((x - y - y) * x == val) {
			System.out.println(x + "-" + y + "-" + y + "*" + x);
			answer++;
		}
		if ((x - y) * y - x == val) {
			System.out.println(x + "-" + y + "*" + y + "-" + x);
			answer++;
		}
		if ((x - y) * y * x == val) {
			System.out.println(x + "-" + y + "*" + y + "*" + x);
			answer++;
		}
		if ((x - y + y) * x == val) {
			System.out.println(x + "-" + y + "+" + y + "*" + x);
			answer++;
		}
		if ((x - y) * y + x == val) {
			System.out.println(x + "-" + y + "*" + y + "+" + x);
			answer++;
		}
		
		
		// y, y, x, x
		if (y + y + x + x == val) {
			System.out.println(y + "+" + y + "+" + x + "+" + x);
			answer++; 
		}
		if (y + y + x - x == val) {
			System.out.println(y + "+" + y + "+" + x + "-" + x);
			answer++;
		}
		if (y + y - x + x == val) {
			System.out.println(y + "+" + y + "-" + x + "+" + x);
			answer++;
		}
		if (y + y - x - x == val) {
			System.out.println(y + "+" + y + "-" + x + "-" + x);
			answer++;
		}
		if ((y + y + x) * x == val) {
			System.out.println(y + "+" + y + "+" + x + "*" + x);
			answer++;
		}
		if ((y + y) * x + x == val) {
			System.out.println(y + "+" + y + "*" + x + "+" + x);
			answer++;
		}
		if ((y + y) * x * x == val) {
			System.out.println(y + "+" + y + "*" + x + "*" + x);
			answer++;
		}
		if (y * y - x - x == val) {
			System.out.println(y + "*" + y + "-" + x + "-" + x);
			answer++;
		}
		if ((y * y - x) * x == val) {
			System.out.println(y + "*" + y + "-" + x + "*" + x);
			answer++;
		}
		if (y * y * x - x == val) {
			System.out.println(y + "*" + y + "*" + x + "-" + x);
			answer++;
		}
		if (y * y + x + x == val) {
			System.out.println(y + "*" + y + "+" + x + "+" + x);
			answer++;
		}
		if ((y * y + x) * x == val) {
			System.out.println(y + "*" + y + "+" + x + "*" + x);
			answer++;
		}
		if (y * y * x + x == val) {
			System.out.println(y + "*" + y + "*" + x + "+" + x);
			answer++;
		}
		if (y * y * x * x == val) {
			System.out.println(y + "*" + y + "*" + x + "*" + x);
			answer++;
		}
		if ((y + y - x) * x == val) {
			System.out.println(y + "+" + y + "-" + x + "*" + x);
			answer++;
		}
		if ((y + y) * x - x == val) {
			System.out.println(y + "+" + y + "*" + x + "-" + x);
			answer++;
		}
		if (y * y + x - x == val) {
			System.out.println(y + "*" + y + "+" + x + "-" + x);
			answer++;
		}
		if (y * y - x + x == val) {
			System.out.println(y + "*" + y + "-" + x + "+" + x);
			answer++;
		}		
		if (y - y - x - x == val) {
			System.out.println(y + "-" + y + "-" + x + "-" + x);
			answer++;
		}
		if (y - y - x + x == val) {
			System.out.println(y + "-" + y + "-" + x + "+" + x);
			answer++;
		}
		if (y - y + x - x == val) {
			System.out.println(y + "-" + y + "+" + x + "-" + x);
			answer++;
		}
		if (y - y + x + x == val) {
			System.out.println(y + "-" + y + "+" + x + "+" + x);
			answer++;
		}
		if ((y - y - x) * x == val) {
			System.out.println(y + "-" + y + "-" + x + "*" + x);
			answer++;
		}
		if ((y - y) * x - x == val) {
			System.out.println(y + "-" + y + "*" + x + "-" + x);
			answer++;
		}
		if ((y - y) * x * x == val) {
			System.out.println(y + "-" + y + "*" + x + "*" + x);
			answer++;
		}
		if ((y - y + x) * x == val) {
			System.out.println(y + "-" + y + "+" + x + "*" + x);
			answer++;
		}
		if ((y - y) * x + x == val) {
			System.out.println(y + "-" + y + "*" + x + "+" + x);
			answer++;
		}
		
		
		// y, x, y, x
		if (y + x + y + x == val) {
			System.out.println(y + "+" + x + "+" + y + "+" + x);
			answer++; 
		}
		if (y + x + y - x == val) {
			System.out.println(y + "+" + x + "+" + y + "-" + x);
			answer++;
		}
		if (y + x - y + x == val) {
			System.out.println(y + "+" + x + "-" + y + "+" + x);
			answer++;
		}
		if (y + x - y - x == val) {
			System.out.println(y + "+" + x + "-" + y + "-" + x);
			answer++;
		}
		if ((y + x + y) * x == val) {
			System.out.println(y + "+" + x + "+" + y + "*" + x);
			answer++;
		}
		if ((y + x) * y + x == val) {
			System.out.println(y + "+" + x + "*" + y + "+" + x);
			answer++;
		}
		if ((y + x) * y * x == val) {
			System.out.println(y + "+" + x + "*" + y + "*" + x);
			answer++;
		}
		if (y * x - y - x == val) {
			System.out.println(y + "*" + x + "-" + y + "-" + x);
			answer++;
		}
		if ((y * x - y) * x == val) {
			System.out.println(y + "*" + x + "-" + y + "*" + x);
			answer++;
		}
		if (y * x * y - x == val) {
			System.out.println(y + "*" + x + "*" + y + "-" + x);
			answer++;
		}
		if (y * x + y + x == val) {
			System.out.println(y + "*" + x + "+" + y + "+" + x);
			answer++;
		}
		if ((y * x + y) * x == val) {
			System.out.println(y + "*" + x + "+" + y + "*" + x);
			answer++;
		}
		if (y * x * y + x == val) {
			System.out.println(y + "*" + x + "*" + y + "+" + x);
			answer++;
		}
		if (y * x * y * x == val) {
			System.out.println(y + "*" + x + "*" + y + "*" + x);
			answer++;
		}
		if ((y + x - y) * x == val) {
			System.out.println(y + "+" + x + "-" + y + "*" + x);
			answer++;
		}
		if ((y + x) * y - x == val) {
			System.out.println(y + "+" + x + "*" + y + "-" + x);
			answer++;
		}
		if (y * x + y - x == val) {
			System.out.println(y + "*" + x + "+" + y + "-" + x);
			answer++;
		}
		if (y * x - y + x == val) {
			System.out.println(y + "*" + x + "-" + y + "+" + x);
			answer++;
		}		
		if (y - x - y - x == val) {
			System.out.println(y + "-" + x + "-" + y + "-" + x);
			answer++;
		}
		if (y - x - y + x == val) {
			System.out.println(y + "-" + x + "-" + y + "+" + x);
			answer++;
		}
		if (y - x + y - x == val) {
			System.out.println(y + "-" + x + "+" + y + "-" + x);
			answer++;
		}
		if (y - x + y + x == val) {
			System.out.println(y + "-" + x + "+" + y + "+" + x);
			answer++;
		}
		if ((y - x - y) * x == val) {
			System.out.println(y + "-" + x + "-" + y + "*" + x);
			answer++;
		}
		if ((y - x) * y - x == val) {
			System.out.println(y + "-" + x + "*" + y + "-" + x);
			answer++;
		}
		if ((y - x) * y * x == val) {
			System.out.println(y + "-" + x + "*" + y + "*" + x);
			answer++;
		}
		if ((y - x + y) * x == val) {
			System.out.println(y + "-" + x + "+" + y + "*" + x);
			answer++;
		}
		if ((y - x) * y + x == val) {
			System.out.println(y + "-" + x + "*" + y + "+" + x);
			answer++;
		}
		
		
		// y, x, x, y
		if (y + x + x + y == val) {
			System.out.println(y + "+" + x + "+" + x + "+" + y);
			answer++; 
		}
		if (y + x + x - y == val) {
			System.out.println(y + "+" + x + "+" + x + "-" + y);
			answer++;
		}
		if (y + x - x + y == val) {
			System.out.println(y + "+" + x + "-" + x + "+" + y);
			answer++;
		}
		if (y + x - x - y == val) {
			System.out.println(y + "+" + x + "-" + x + "-" + y);
			answer++;
		}
		if ((y + x + x) * y == val) {
			System.out.println(y + "+" + x + "+" + x + "*" + y);
			answer++;
		}
		if ((y + x) * x + y == val) {
			System.out.println(y + "+" + x + "*" + x + "+" + y);
			answer++;
		}
		if ((y + x) * x * y == val) {
			System.out.println(y + "+" + x + "*" + x + "*" + y);
			answer++;
		}
		if (y * x - x - y == val) {
			System.out.println(y + "*" + x + "-" + x + "-" + y);
			answer++;
		}
		if ((y * x - x) * y == val) {
			System.out.println(y + "*" + x + "-" + x + "*" + y);
			answer++;
		}
		if (y * x * x - y == val) {
			System.out.println(y + "*" + x + "*" + x + "-" + y);
			answer++;
		}
		if (y * x + x + y == val) {
			System.out.println(y + "*" + x + "+" + x + "+" + y);
			answer++;
		}
		if ((y * x + x) * y == val) {
			System.out.println(y + "*" + x + "+" + x + "*" + y);
			answer++;
		}
		if (y * x * x + y == val) {
			System.out.println(y + "*" + x + "*" + x + "+" + y);
			answer++;
		}
		if (y * x * x * y == val) {
			System.out.println(y + "*" + x + "*" + x + "*" + y);
			answer++;
		}
		if ((y + x - x) * y == val) {
			System.out.println(y + "+" + x + "-" + x + "*" + y);
			answer++;
		}
		if ((y + x) * x - y == val) {
			System.out.println(y + "+" + x + "*" + x + "-" + y);
			answer++;
		}
		if (y * x + x - y == val) {
			System.out.println(y + "*" + x + "+" + x + "-" + y);
			answer++;
		}
		if (y * x - x + y == val) {
			System.out.println(y + "*" + x + "-" + x + "+" + y);
			answer++;
		}		
		if (y - x - x - y == val) {
			System.out.println(y + "-" + x + "-" + x + "-" + y);
			answer++;
		}
		if (y - x - x + y == val) {
			System.out.println(y + "-" + x + "-" + x + "+" + y);
			answer++;
		}
		if (y - x + x - y == val) {
			System.out.println(y + "-" + x + "+" + x + "-" + y);
			answer++;
		}
		if (y - x + x + y == val) {
			System.out.println(y + "-" + x + "+" + x + "+" + y);
			answer++;
		}
		if ((y - x - x) * y == val) {
			System.out.println(y + "-" + x + "-" + x + "*" + y);
			answer++;
		}
		if ((y - x) * x - y == val) {
			System.out.println(y + "-" + x + "*" + x + "-" + y);
			answer++;
		}
		if ((y - x) * x * y == val) {
			System.out.println(y + "-" + x + "*" + x + "*" + y);
			answer++;
		}
		if ((y - x + x) * y == val) {
			System.out.println(y + "-" + x + "+" + x + "*" + y);
			answer++;
		}
		if ((y - x) * x + y == val) {
			System.out.println(y + "-" + x + "*" + x + "+" + y);
			answer++;
		}
		
		
		return answer;
	}
	
	
}
