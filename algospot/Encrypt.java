package algospot.lowestquestion;
import java.util.Scanner;


public class Encrypt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while (cases-- > 0) {
			String name = sc.next();
			
			String hol = "";
			String jjac = "";
			for (int i = 0; i < name.length(); i++) {
				char ch = name.charAt(i);
				if (i % 2 == 0) {
					jjac += ch;
				} else {
					hol += ch;
				}
			}
			System.out.println(jjac+hol);
		}

	}

}
