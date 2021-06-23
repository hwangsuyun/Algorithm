package programmers.level2;

import java.util.ArrayList;

// [1차] 뉴스 클러스터링
public class Solution45 {
	public static void main(String[] args) {
		String str1 = "FRANCE"; String str2 = "french"; // 16384
		//String str1 = "handshake"; String str2 = "shake hands"; // 65536
		//String str1 = "aa1+aa2"; String str2 = "AAAA12"; // 43690
		//String str1 = "E=M*C^2"; String str2 = "e=m*c^2"; // 65536
		
		if (str1.length() < 2 || str1.length() > 1000) return;
		if (str2.length() < 2 || str2.length() > 1000) return;
		
		System.out.println(solution(str1, str2));
	}
	
	public static int solution(String str1, String str2) {
		ArrayList<String> strArray1 = step1(str1);
		ArrayList<String> strArray2 = step1(str2);
		
		for (String s : strArray1) {
			System.out.print(s + ", ");
		}
		System.out.println();
		for (String s : strArray2) {
			System.out.print(s + ", ");
		}
		System.out.println();
		
		return step2(strArray1, strArray2);
	}
	
	private static ArrayList<String> step1(String str) {
		ArrayList<String> strArray = new ArrayList<>();
		String temp = "";
		
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z')) {
				temp += str.charAt(i);
			} else {
				temp = "";
				continue;
			}
			
			if (temp.length() == 2) {
				strArray.add(temp.toUpperCase());
				temp = str.charAt(i) + "";
			}
		}
		
		return strArray;
	}
	
	private static int step2(ArrayList<String> strArray1, ArrayList<String> strArray2) {
		double cup = strArray1.size() + strArray2.size();
		double cap = 0;
		
		for (String str1 : strArray1) {
			for (String str2 : strArray2) {
				if (str1.equals(str2)) {
					cap++;
					strArray2.remove(str2);
					break;
				}
			}
		}	
		
		cup -= cap;
		System.out.println("cap : " + cap);
		System.out.println("cup : " + cup);
		System.out.println("cap / cup : " + cap / cup);
		
		if (cap == 0 && cup == 0) return 65536;
		else return (int) ((cap / cup) * 65536);
	}
}
