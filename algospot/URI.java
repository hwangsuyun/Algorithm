package algospot.lowquestion;

import java.util.Scanner;

public class URI {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		if (cases < 1 || cases > 100 ) {
			System.exit(0);
		}
		
		while (cases-- > 0) {
			String temp = sc.next();

			for (int i = 0; i < temp.length(); i++) {
				if (temp.contains("%2")) {
					temp = temp.replace("%20", " ");
					temp = temp.replace("%21", "!");
					temp = temp.replace("%24", "$");
					temp = temp.replace("%25", "%");
					temp = temp.replace("%28", "(");
					temp = temp.replace("%29", ")");
					temp = temp.replace("%2a", "*");
				}
			}
			System.out.println(temp);			
		}
		
	}
}
