package programmers.level2;

import java.util.LinkedList;

// �踷���
public class Solution8 {
	public static void main(String[] args) {
		String arrangement = "()(((()())(())()))(())";
		if (arrangement.length() > 100000) return;
		solution(arrangement);
	}
	
	// 0, 1, 1, 1, 0, 0, -1, 1, 0, -1, 0, -1, -1, 1, 0, -1
	public static int solution(String arrangement) {
		String temp[] = arrangement.split("");
		LinkedList<Integer> list = new LinkedList<>();
		int peek = 0, stick = 0, result = 0;
		/*
		 * ���ڿ����� �踷���� �������� �����Ͽ� ť�� ��� 
		 * (�踷������ : 1, �踷��ⳡ : -1, ������ : 0)
		 */
		for (int i = 0; i < temp.length; i++) {
			if (i == temp.length - 1) break;
			if (temp[i].equals("(") && temp[i + 1].equals(")")) {
				list.offer(0);
			} else if (temp[i].equals("(") && temp[i + 1].equals("(")) {
				list.offer(1);
			} else if (temp[i].equals(")") && temp[i + 1].equals(")")) {
				list.offer(-1);
			}
		}

		while (!list.isEmpty()) {
			peek = list.poll();
			if (stick == 0 && peek == 0) continue;
			if (peek == 1) {
				stick++;
				result++;
			} else if (peek == 0) {
				result += stick;
			} else if (peek == -1) {
				stick--;
			}
		}
		System.out.println(result);
		return result;
	}
}
