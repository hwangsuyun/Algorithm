package programmers.level1;

// 자연수 뒤집어 배열로 만들기
public class Solution23 {
	public static void main(String[] args) {
		long n = 12345;
		solution(n);
	}
	
	public static int[] solution(long n) {
		String str = n + "";
		long[] temp = new long[str.length()];
		int[] answer = new int[str.length()];
		int index = 0;
		while (n > 0) {
			temp[index] = n % 10;
			answer[index] = Math.toIntExact(temp[index]);
			System.out.println(answer[index]);
			index++;
			n = n / 10;
		}
		return answer;
	}
}
