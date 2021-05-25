package programmers.level2;

// Ä«Æê
public class Solution20 {
	public static void main(String[] args) {
		int brown = 10;
		int red = 2;
		//int brown = 8;
		//int red = 1;
		//int brown = 24;
		//int red = 24;
		//int brown = 16;
		//int red = 9;
		if (brown < 8 || brown > 5000) return;
		if (red < 1 || red > 2000000) return;
		solution(brown, red);
	}
	
	public static int[] solution(int brown, int red) {
		int[] result = new int[2];
		int temp = 0;
		for (int i = 3; i <= Math.sqrt(brown + red); i++) {
			if ((brown + red) % i == 0) {
				temp = (brown + red) / i;
				if ((temp - 2) * (i - 2) == red) {
					result[0] = temp;
					result[1] = i;
				}
			}
		}
		System.out.println(result[0] + ", " + result[1]);
		return result;
	}
}
