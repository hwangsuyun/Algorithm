package programmers.level1;

import java.util.Arrays;

public class Solution4 {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		solution(array, commands);
	}

	public static int[] solution(int[] array, int[][] commands) {
		if (array.length < 1 || array.length > 100) return null;
		for (int i = 0; i < array.length; i++) if (array[i] < 1 || array[i] > 100) return null;
		if (commands.length < 1 || commands.length > 50) return null;
		for (int i = 0; i < commands.length; i++) if (commands[i].length != 3) return null;
		
		int[] temp = {};
		int[] result= new int[commands.length];
		for (int i = 0; i < commands.length; i ++) {
			temp = Arrays.copyOfRange(Arrays.copyOf(array, commands[i][1]), commands[i][0] -1, commands[i][1]);
			Arrays.sort(temp);
			result[i] = temp[commands[i][2] - 1];
			System.out.println(result[i]);
		}
		return result;
	}
}