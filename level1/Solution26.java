package programmers.level1;

// 제일 작은 수 제거하기
public class Solution26 {
	public static void main(String[] args) {
		//int[] arr = {4, 3, 2, 1};
		int[] arr = {1, 2, 3, 4};
		//int[] arr = {10};
		if (arr.length < 1) return;
		solution(arr);
	}
	
	public static int[] solution(int[] arr) {
		int[] answer = {};
		if (arr.length == 1) {
			answer = new int[1];
			answer[0] = -1;
		} else {
			int count = 0;
			int index = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					if (arr[i] < arr[j]) count++;
					if (count == arr.length - 1) index = i;
				}
				count = 0;
			}
			answer = new int[arr.length - 1];
			int x = 0;
			for (int i = 0; i < arr.length; i++) {
				if (index == i) continue;
				answer[x] = arr[i];
				x++;
			}
		}
		for (int i : answer) {
			System.out.println(i);
		}
		return answer;
	}
}
