package programmers.level1;

public class Solution5 {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = {2, 3, 4};
		int[] reserve = {3, 4, 5};

		solution(n, lost, reserve);
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int cnt = 0;
		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				if (reserve[i] == lost[j]) {
					reserve[i] = -1;
					lost[j] = -1;
				}
			}
		}
		
		for (int i = 0; i < reserve.length; i++) {
			for (int j = 0; j < lost.length; j++) {
				if (reserve[i] == lost[j] + 1 || reserve[i] == lost[j] - 1) {
					reserve[i] = -1;
					lost[j] = -1;
				}
			}
		}

		for (int i = 0; i < lost.length; i++) {
			if (lost[i] != -1) cnt++;
		}
		System.out.println(n - cnt);

		return n - cnt;
	}	
}