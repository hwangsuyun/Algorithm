package programmers.level2;

import java.util.LinkedList;

// 숫자 야구
public class Solution18 {
	public static void main(String[] args) {
		int[][] baseball = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		if (baseball.length < 1 || baseball.length > 100) return;
		for (int i = 0; i < baseball.length; i++) {
			if (baseball[i][0] < 99 || baseball[i][0] > 999) return;
		}
		solution(baseball);
	}
	
	public static int solution(int[][] baseball) {
		LinkedList<String> list = new LinkedList<>();
		LinkedList<String> result = new LinkedList<>();
		boolean flag = true;
		for (int i = 123; i < 1000; i++) {
			String[] temp = (i + "").split("");
			if (!(temp[0].equals(temp[1]) || temp[0].equals(temp[2]) || temp[1].equals(temp[2]) || temp[1].equals("0") || temp[2].equals("0"))) {
				list.add(i + "");
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < baseball.length; j++) {
				int strike = strike(list.get(i), baseball[j][0] + "");
				int ball = ball(list.get(i), baseball[j][0] + "") - strike;
				if (strike != baseball[j][1] || ball != baseball[j][2]) flag = false;
			}
			if (flag) result.add(list.get(i));
			flag = true;
		}
		System.out.println(result.size());
		return result.size();
	}

	public static int strike(String num, String target) {
		int cnt = 0;
		for (int i = 0; i < target.length(); i++) {
			if (num.charAt(i) == target.charAt(i)) cnt++;
		}
		return cnt;
	}
	
	public static int ball(String num, String target) {
		int cnt = 0;
		for (int i = 0; i < target.length(); i++) {
			if (num.contains(target.charAt(i) + "")) cnt++;
		}
		return cnt;
	}
}
