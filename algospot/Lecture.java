package algospot.lowestquestion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while (cases-- > 0) {
			String name = sc.next();
			
			String temp = "";
			ArrayList<String> list = new ArrayList<String>();
			
			for (int i = 0; i < name.length(); i += 2) {
				if (i + 2 > name.length())
				{
					list.add(name.substring(i, i + 1));
				} else list.add(name.substring(i, i + 2));
			}
			
			Collections.sort(list);
			for (String s : list) {
				System.out.print(s);
			}
			System.out.println("");
			
		}
			
	}

}
