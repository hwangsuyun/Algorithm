package programmers.level1;

// 소수 찾기
public class Solution16 {
	public static void main(String[] args) {
		//int n = 100000;
		int n = 10;
		if (n < 2 || n > 1000000) return;
		long before = System.currentTimeMillis();
		solution(n);
		long after = System.currentTimeMillis();
		System.out.println(after - before);
	}
	
	public static int solution(int n) {
		int primeNumber = 0, count = 0;
		for (int i = 2; i <= n; i++) {
			if (i != 2 && i % 2 == 0) continue;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				//if (j != 2 && j % 2 == 0) continue;
				if (i != j && i % j == 0) {
					count++;
					break;
				}
				System.out.println("i : " + i);
				System.out.println("j : " + j);
				System.out.println();
			}
			if (count == 0) primeNumber++;
			count = 0;
		}
		
		return primeNumber;
	}
}
