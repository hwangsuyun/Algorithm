package algospot.lowestquestion;
import java.util.Scanner;

public class HotSummer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while (cases-- > 0) {
			int name = sc.nextInt();
			
			int num = 0;
			String temp = "";
			
			for (int i = 0; i < 9; i++) {
				int check = sc.nextInt();
				if (check >= 0 || check <= 1000) {
					num += check;
				}
			}
			
			if (num <= name) {
				temp = "YES";
			} else {
				temp = "NO";
			}
			
			System.out.println(temp);			
		}
	}
}

