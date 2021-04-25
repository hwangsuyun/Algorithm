package programmers.level1;

import java.util.Scanner;

// 직사각형 별찍기
public class Solution35 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if (a < 1 || a > 1000) return;
		if (b < 1 || b > 1000) return;
		
		
		for (int i = 0; i < b; i++) {
			for (int j = 0; j < a; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//System.out.println(a + b);		
	}
	
}
