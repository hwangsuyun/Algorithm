package algospot.lowquestion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class WeeklyCalendar {
	static HashMap<String, Integer> map = new HashMap<>();
	static ArrayList list = new ArrayList();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cases = sc.nextInt();
		
		while (cases-- > 0) {
			int month = sc.nextInt();
			int day = sc.nextInt();
			String dayOfTheWeek = sc.next();
			
			map.put("Sunday", 0);
			map.put("Monday", 1);
			map.put("Tuesday", 2);
			map.put("Wednesday", 3);
			map.put("Thursday", 4);
			map.put("Friday", 5);
			map.put("Saturday", 6);
			
			int result = map.get(dayOfTheWeek);
			int day2 = day;
			
			for (int i = 0; i < 7; i++) {
				if (result == 1) {
					day -= 1;
				} else if (result == 2) {
					day -= 2;
				} else if (result == 3) {
					day -= 3;
				} else if (result == 4) {
					day -= 4;
				} else if (result == 5) {
					day -= 5;
				} else if (result == 6) {
					day -= 6;
				}
				checkDate(month, day);
				list.add(day);
				day = day2;
				day2++;
				day++;
				System.out.println(list.get(i));
			}
			 
		}
		
	} // end of main

	public static int[] checkDate(int month, int day) {
		int[] temp = null;
		if (day < 0) {
			switch (day) {
			case -5:
				if (month == 1) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 2) {
					temp = new int[]{26, 27, 28, 1, 2, 3, 4};
				} else if (month == 3) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 4) {
					temp = new int[]{26, 27, 28, 29, 30, 1, 2};
				} else if (month == 5) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 6) {
					temp = new int[]{26, 27, 28, 29, 30, 1, 2};
				} else if (month == 7) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 8) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 9) {
					temp = new int[]{26, 27, 28, 29, 30, 1, 2};
				} else if (month == 10) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 11) {
					temp = new int[]{26, 27, 28, 29, 30, 1, 2};
				} else if (month == 12) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				}
				break;
			case -4:
				if (month == 1) {
					temp = new int[]{27, 28, 29, 30, 31, 1, 2};
				} else if (month == 2) {
					temp = new int[]{27, 28, 1, 2, 3, 4, 5};
				} else if (month == 3) {
					temp = new int[]{27, 28, 29, 30, 31, 1, 2};
				} else if (month == 4) {
					temp = new int[]{27, 28, 29, 30, 1, 2, 3};
				} else if (month == 5) {
					temp = new int[]{27, 28, 29, 30, 31, 1, 2};
				} else if (month == 6) {
					temp = new int[]{27, 28, 29, 30, 1, 2, 3};
				} else if (month == 7) {
					temp = new int[]{27, 28, 29, 30, 31, 1, 2};
				} else if (month == 8) {
					temp = new int[]{27, 28, 29, 30, 31, 1, 2};
				} else if (month == 9) {
					temp = new int[]{27, 28, 29, 30, 1, 2, 3};
				} else if (month == 10) {
					temp = new int[]{27, 28, 29, 30, 31, 1, 2};
				} else if (month == 11) {
					temp = new int[]{27, 28, 29, 30, 1, 2, 3};
				} else if (month == 12) {
					temp = new int[]{27, 28, 29, 30, 31, 1, 2};
				}
				break;
			case -3:
				if (month == 1) {
					temp = new int[]{28, 29, 30, 31, 1, 2, 3};
				} else if (month == 2) {
					temp = new int[]{28, 1, 2, 3, 4, 5, 6};
				} else if (month == 3) {
					temp = new int[]{28, 29, 30, 31, 1, 2, 3};
				} else if (month == 4) {
					temp = new int[]{28, 29, 30, 1, 2, 3, 4};
				} else if (month == 5) {
					temp = new int[]{28, 29, 30, 31, 1, 2, 3};
				} else if (month == 6) {
					temp = new int[]{28, 29, 30, 1, 2, 3, 4};
				} else if (month == 7) {
					temp = new int[]{28, 29, 30, 31, 1, 2, 3};
				} else if (month == 8) {
					temp = new int[]{28, 29, 30, 31, 1, 2, 3};
				} else if (month == 9) {
					temp = new int[]{28, 29, 30, 1, 2, 3, 4};
				} else if (month == 10) {
					temp = new int[]{28, 29, 30, 31, 1, 2, 3};
				} else if (month == 11) {
					temp = new int[]{28, 29, 30, 1, 2, 3, 4};
				} else if (month == 12) {
					temp = new int[]{28, 29, 30, 31, 1, 2, 3};
				}
				break;
			case -2:
				if (month == 1) {
					temp = new int[]{29, 30, 31, 1, 2, 3, 4};
				} else if (month == 2) {
					temp = new int[]{1, 2, 3, 4, 5, 6, 7};
				} else if (month == 3) {
					temp = new int[]{29, 30, 31, 1, 2, 3, 4};
				} else if (month == 4) {
					temp = new int[]{29, 30, 1, 2, 3, 4, 5};
				} else if (month == 5) {
					temp = new int[]{29, 30, 31, 1, 2, 3, 4};
				} else if (month == 6) {
					temp = new int[]{29, 30, 1, 2, 3, 4, 5};
				} else if (month == 7) {
					temp = new int[]{29, 30, 31, 1, 2, 3, 4};
				} else if (month == 8) {
					temp = new int[]{29, 30, 31, 1, 2, 3, 4};
				} else if (month == 9) {
					temp = new int[]{29, 30, 1, 2, 3, 4, 5};
				} else if (month == 10) {
					temp = new int[]{29, 30, 31, 1, 2, 3, 4};
				} else if (month == 11) {
					temp = new int[]{29, 30, 1, 2, 3, 4, 5};
				} else if (month == 12) {
					temp = new int[]{29, 30, 31, 1, 2, 3 ,4};
				}
				break;
			// ?—¬ê¸°ë??„° ?•´?•¼?¨
			case -1:
				if (month == 1) {
					temp = new int[]{30, 31, 1, 2, 3, 4, 5};
				} else if (month == 2) {
					temp = new int[]{27, 28, 1, 2, 3, 4, 5};
				} else if (month == 3) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 4) {
					temp = new int[]{26, 27, 28, 29, 30, 1, 2};
				} else if (month == 5) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 6) {
					temp = new int[]{26, 27, 28, 29, 30, 1, 2};
				} else if (month == 7) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 8) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 9) {
					temp = new int[]{26, 27, 28, 29, 30, 1, 2};
				} else if (month == 10) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 11) {
					temp = new int[]{26, 27, 28, 29, 30, 1, 2};
				} else if (month == 12) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				}
				break;
			case 0:
				if (month == 1) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 2) {
					temp = new int[]{27, 28, 1, 2, 3, 4, 5};
				} else if (month == 3) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 4) {
					temp = new int[]{26, 27, 28, 29, 30, 1, 2};
				} else if (month == 5) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 6) {
					temp = new int[]{26, 27, 28, 29, 30, 1, 2};
				} else if (month == 7) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 8) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 9) {
					temp = new int[]{26, 27, 28, 29, 30, 1, 2};
				} else if (month == 10) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				} else if (month == 11) {
					temp = new int[]{26, 27, 28, 29, 30, 1, 2};
				} else if (month == 12) {
					temp = new int[]{26, 27, 28, 29, 30, 31, 1};
				}
				break;
			default:
				break;
			}
		}
		return temp;
	}
	
	

}
