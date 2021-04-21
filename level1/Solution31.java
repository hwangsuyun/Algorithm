package programmers.level1;

// ÇÏ»þµå ¼ö
public class Solution31 {
	public static void main(String[] args) {
		int x = 11;
		//int x = 12;
		if (x < 1 || x > 10000) return;
		System.out.println(solution(x));
	}
	
	public static boolean solution(int x) {
		String str = x + "";
		int temp = 0;
		for (int i = 0; i < str.length(); i++) {
			temp += Integer.parseInt(str.charAt(i) + "");
		}
		return x % temp == 0 ? true : false;
	}
}
