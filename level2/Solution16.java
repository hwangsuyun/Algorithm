package programmers.level2;

import java.util.regex.Pattern;

// ¿ß¿Â
public class Solution16 {
	public static void main(String[] args) {
		//String[][] clothes = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"},  {"green_turban", "headgear"}};
		//String[][] clothes = {{"crow_mask", "face"}, {"blue_sunglasses", "face"}, {"smoky_makeup", "face"}};
		String[][] clothes = {{"maska", "a"}, {"maskb", "a"}, {"maskc", "a"}, {"bodya", "b"}, {"bodyb", "b"}, {"pantsa", "c"}};
		for (int i = 0; i < clothes.length; i++) {
			if (clothes[i][0].length() < 1 || clothes[i][0].length() > 20) return;
			if (!Pattern.matches("^[a-z_]+$", clothes[i][0])) return;
			for (int j = i + 1; j <= clothes.length - 1; j++) {
				if (clothes[i].length < 1 || clothes[i].length > 30) return;
				if (clothes[i][0].equals(clothes[j][0])) return;
			}
		}
		solution(clothes);
	}
	
	public static int solution(String[][] clothes) {
		int[][] array = new int[clothes.length][1];
		int count = 1, result = 1;
		for (int i = 0; i < clothes.length; i++) {
			String key = clothes[i][1];
			if (key.equals("-9")) continue;
			for (int j = i + 1; j <= array.length; j++) {
				if (j == array.length) {
					array[i][0] = count;
					break;
				}
				if (key.equals(clothes[j][1])) {
					clothes[j][1] = "-9";
					count++;
				}
				array[i][0] = count;
			}
			count = 1;
		}
		
		for (int i = 0; i < array.length; i++) {
			if (array[i][0] != 0) {
				System.out.println(array[i][0]);
				result *= array[i][0] + 1;
			}
		}
		result -= 1;
		System.out.println("result : " + result);
		return result;
	}
}
