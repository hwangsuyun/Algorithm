package algospot.lowquestion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Xhaeneung {
	
	private static boolean check = false;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();

		while (cases-- > 0) {
			String temp1 = sc.next();
			String temp2 = sc.next();
			String temp3 = sc.next();
			String temp4 = sc.next();
			String temp5 = sc.next();
			
			check = operationResult(temp1, temp2, temp3, temp5);
			if (check == true) {
				System.out.println("Yes");
			} else {
				System.out.println("No");
			}
			
		}
		
	}
	
	public static int converToNum(String value) {
		int num = 0;
		if (value.equals("zero")) {
			num = 0;
		} else if (value.equals("one")) {
			num = 1;
		} else if (value.equals("two")) {
			num = 2;
		} else if (value.equals("three")) {
			num = 3;
		} else if (value.equals("four")) {
			num = 4;
		} else if (value.equals("five")) {
			num = 5;
		} else if (value.equals("six")) {
			num = 6;
		} else if (value.equals("seven")) {
			num = 7;
		} else if (value.equals("eight")) {
			num = 8;
		} else if (value.equals("nine")) {
			num = 9;
		} else if (value.equals("ten")) {
			num = 10;
		}
		return num;
	}
	
	public static String converToString(int num) {
		String value = "";
		if (num == 0) {
			value = "zero";
		} else if (num == 1) {
			value = "one";
		} else if (num == 1) {
			value = "two";
		} else if (num == 3) {
			value = "three";
		} else if (num == 4) {
			value = "four";
		} else if (num == 5) {
			value = "five";
		} else if (num == 6) {
			value = "six";
		} else if (num == 7) {
			value = "seven";
		} else if (num == 8) {
			value = "eight";
		} else if (num == 9) {
			value = "nine";
		} else if (num == 10) {
			value = "ten";
		} 
		return value;
	}
	
	public static boolean sortString(String A, String B) {
		ArrayList list1 = new ArrayList();
		ArrayList list2 = new ArrayList();
		int cnt = 0;
		
		for (int i = 0; i < A.length(); i++) {
			char ch = A.charAt(i);
			list1.add(ch);
		}
		
		for (int i = 0; i < B.length(); i++) {
			char ch = B.charAt(i);
			list2.add(ch);
		}
		
		Collections.sort(list1);
		Collections.sort(list2);
		
		
		for (int i = 0; i < list1.size(); i++) {
			if (list1.get(i) == list2.get(i)) {
				cnt++;
			}
		}
		
		if (cnt == list1.size()) {
			return true;
		}
		return false;
	}
	
	public static boolean operationResult(String A, String B, String C, String D) {
		int numA = converToNum(A);
		int numC = converToNum(C);

		int value = 0;
		String temp = "";
		int cnt = 0;
		
		if (B.equals("+")) {
			value = numA + numC;
		} else if (B.equals("-")) {
			value = numA - numC;
		} else if (B.equals("*")) {
			value = numA * numC;
		} else if (B.equals("/")) {
			value = numA / numC;
		}
		
		if (value < 0 || value > 10) {
			return false;
		}
		
		temp = converToString(value);

		if (temp.length() != D.length()) {
			return false;
		}
		
		check = sortString(temp, D);
		
		return check;
	}
}
