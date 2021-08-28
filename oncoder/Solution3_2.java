package oncoder;

import java.util.LinkedList;

//사칙연산
public class Solution3_2 {
	static LinkedList<Integer> list1 = new LinkedList<>();
	static LinkedList<String> list2 = new LinkedList<>();
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
		int[][] xy = {
				{x, x, y, y},
				{x, y, x, y}, 
				{x, y, y, x},
				{y, y, x, x},
				{y, x, y, x},
				{y, x, x, y},
			};
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
		
		String[] array = new String[xy.length * op.length];
		int index = 0;
		for (int i = 0; i < array.length; i++) {
			array[i] = "";
		}
		
		for (int i = 0; i < xy.length; i++) {
			for (int j = 0; j < op.length; j++) {
				for (int k = 0; k < xy[i].length; k++) {
					array[index] += "" + xy[i][k];
					if (k == op[i].length) break;
					array[index] += op[j][k];
				}
				index++;
			}
			
		}
		
		/*
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
		System.out.println();
		*/
		
		for (int i = 0; i < array.length; i++) {
			if (val == checkValue(array[i])) {
				System.out.println(array[i]);
				answer++;
			}
		}
		
		return answer;
	}
	
	private static int checkValue(String data) {
		String temp = data;
		int cnt = 0, check = 0;
		int first = 0, second = 0, third = 0, fourth = 0;
		int sum = 0, index = 0;

		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == '+' || temp.charAt(i) == '-' || temp.charAt(i) == '*') {
				if (i == 0) continue;
				if (temp.charAt(i + 1) == '+' || temp.charAt(i + 1) == '-' || temp.charAt(i + 1) == '*') {
					check++;
					continue;
				}
					
				if (cnt == 0) {
					first = Integer.parseInt(data.substring(index, i - check));
					index = data.substring(index, i - check).length();
				} else if (cnt == 1) {
					second = Integer.parseInt(data.substring(index + 1, i - check));
					index += data.substring(index + 1, i - check).length();
				} else if (cnt == 2) {
					third = Integer.parseInt(data.substring(index + 2, i - check));
					index += data.substring(index + 1, i - check).length();
					fourth = Integer.parseInt(data.substring(i + 1, data.length()));
				}
				cnt++;
				check = 0;
			}
		}
		
		cnt = 0;		
		for (int i = 0; i < data.length(); i++) {
			if (data.charAt(i) == '+' || data.charAt(i) == '-' || data.charAt(i) == '*') {
				if (cnt == 0) {
					sum = calculate(data.charAt(i), first, second);
					cnt++;
				} else if (cnt == 1) {
					sum = calculate(data.charAt(i), sum, third);
					cnt++;
				} else if (cnt == 2) {
					sum = calculate(data.charAt(i), sum, fourth);
					cnt++;
				}
			}
		}
		
		return sum;
	}
	
	private static int calculate(char ch, int num1, int num2) {
		int result = 0;
		switch (ch) {
			case '+':
				result = num1 + num2;
				break;
			case '-':
				result = num1 - num2;
				break;
			case '*':
				result = num1 * num2;
				break;
			default:
				break;
		}
		return result;
	}
}
