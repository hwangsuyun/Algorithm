package algospot.lowquestion;

import java.util.Scanner;

public class Weird {
	
	static int[] total = new int[1000];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while (cases-- > 0) {
			int num = sc.nextInt();
			
			int cnt = 0;
			int checkNum = 0;
			for (int i = 1; i < num; i++) {
				if (num % i == 0) {
					total[cnt] = i;
					cnt++;
					checkNum += i;
				}
			}
			
			boolean check = false;
			if (checkNum == num) check = true;
			else if (checkNum > num) {
				check = checkWeird(num, cnt - 1);
			} else {
				check = true;
			}
			
			if (check)
				System.out.println("not weird");
			else
				System.out.println("weird");
		}
	
	
	}
	
	public static boolean checkWeird(int num, int cnt) {
		int i;
		for (i = cnt; i >= 0; i--) {
			if (total[i] <= num)
				break;
		}
		
		if (i < 0)
			return false;
		
		if (num - total[i] == 0)
			return true;
		
		if (checkWeird(num - total[i], i - 1))
			return true;
		else
			return checkWeird(num, i - 1);
	}
	
}
