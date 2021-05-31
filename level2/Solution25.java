package programmers.level2;

import java.util.Arrays;

// ¶¥µû¸Ô±â
public class Solution25 {
	static int sum = 0;
	public static void main(String[] args) {
		//int[][] land = {{1, 2, 3, 5}, {5, 6, 7, 8}, {4, 3, 2, 1}}; // 16
		int[][] land = {{9, 5, 2, 3}, {9, 8, 6, 7}, {8, 9, 7, 1}, {100, 9, 8, 1}}; // 125
		if (land.length < 1 || land.length > 100000) return;
		for (int i = 0; i < land.length; i++) {
			if (land[i].length != 4) return;
		}
		solution(land);
	}
	
	public static int solution(int[][] land) {
		int result = 0;
		for (int i = 0; i < land.length - 1; i++) {
			land[i + 1][0] += Math.max(land[i][1], Math.max(land[i][2], land[i][3]));
			System.out.println(land[i + 1][0]);
			land[i + 1][1] += Math.max(land[i][0], Math.max(land[i][2], land[i][3]));
			System.out.println(land[i + 1][1]);
			land[i + 1][2] += Math.max(land[i][0], Math.max(land[i][1], land[i][3]));
			System.out.println(land[i + 1][2]);
			land[i + 1][3] += Math.max(land[i][0], Math.max(land[i][1], land[i][2]));
			System.out.println(land[i + 1][3]);
		}
		Arrays.sort(land[land.length - 1]);
		result = land[land.length - 1][land[0].length - 1];
		System.out.println(result);
		return result;
	}
}
