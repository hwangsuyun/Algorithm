package algospot.lowestquestion;
import java.util.Scanner;

public class Convert {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();

		for (int i = 1; i <= cases; i++) {
			double name = sc.nextDouble();
			double result = 0;

			String before = sc.next();
			String after = "";
			
			if (before.equals("kg")) {
				after = "lb";
				result = name * 2.2046;
			} else if (before.equals("l")) {
				after = "g";
				result = name * 0.2642;
			} else if (before.equals("lb")) {
				after = "kg";
				result = name * 0.4536;
			} else if (before.equals("g")) {
				after = "l";
				result = name * 3.7854;
			}
			//result = Math.round(result * 10000.0) / 10000.0;
			String temp = String.format("%.4f", result);
			System.out.println(i + " " + temp + " " + after);
		}

	}
}

