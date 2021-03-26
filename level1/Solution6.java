package programmers.level1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Solution6 {
	public static void main(String[] args) {
		int a = 5;
		int b = 24;
		
		solution(a, b);
	}
	
	public static String solution(int a, int b) {
		if (a < 1 || a > 12) return null;
		if (b < 1) return null;
		if (a == 2) {
			if (b > 29) return null;
		}
		else if (a != 2 && a < 8 && a % 2 == 1) {
			if (b > 31) return null;
		} else if (a != 2 && a >= 8 && a % 2 == 1) {
			if (b > 30) return null;
		} else if (a != 2 && a < 8 && a % 2 == 0) {
			if (b > 30) return null;
		} else if (a != 2 && a >= 8 && a % 2 == 0) {
			if (b > 31) return null;
		}
		
		String mon = "";
		String day = b + "";
		if (a < 10) mon = "0" + a;
		else mon = "" + a;
		String answer = "";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		try {
			Date date =  sdf.parse("2016" + mon + day);
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int dayOfTheWeek = cal.get(Calendar.DAY_OF_WEEK);
			System.out.println(dayOfTheWeek);
			switch (dayOfTheWeek) {
			case 1:
				answer = "SUN";
				break;
			case 2:
				answer = "MON";
				break;
			case 3:
				answer = "TUE";
				break;
			case 4:
				answer = "WED";
				break;
			case 5:
				answer = "THU";
				break;
			case 6:
				answer = "FRI";
				break;
			case 7:
				answer = "SAT";
				break;
			default:
				break;
			}	
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(answer);
		return answer;
	}
}
