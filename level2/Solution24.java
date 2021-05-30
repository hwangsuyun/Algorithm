package programmers.level2;

//다음 큰 숫자
public class Solution24 {
	public static void main(String[] args) {
		int n = 78;
		//int n = 15;
		if (n < 1 || n > 1000000) return;
		solution(n);
	}
	public static int solution(int n) {
		int nCnt = 0, result = 0;
		String temp = Integer.toBinaryString(n);
		System.out.println(temp);
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == '1') nCnt++;
		}
		
		for (int i = n + 1; i < 1000000; i++) {
			int cnt = 0;
			temp = Integer.toBinaryString(i);
			System.out.println(temp);
			for (int j = 0; j < temp.length(); j++) {
				if (temp.charAt(j) == '1') cnt++;
			}
			if (cnt == nCnt) {
				result = i;
				break;
			}
		}
		System.out.println(result);
		return result;
	}
}
