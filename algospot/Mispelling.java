package algospot.lowestquestion;
import java.util.Scanner;


public class Mispelling {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while (cases-- > 0) {
			String name = sc.next();
			String temp = sc.next();
			
			String str = "";
			int num = Integer.parseInt(name.substring(0, 1));
			
			str = temp.substring(0, num - 1);
			str += temp.substring(num, temp.length());
			
			System.out.println(name + " " + str);
			
		}
	}

}
