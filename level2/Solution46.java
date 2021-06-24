package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 메뉴 리뉴얼
public class Solution46 {
	static int result = 0;
	static ArrayList<String> list = new ArrayList<>();
	static ArrayList<String> answer = new ArrayList<>();
	public static void main(String[] args) {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2, 3, 4};
		// ["AC", "ACDE", "BCFG", "CDE"]
		
		//String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
		//int[] course = {2, 3, 5};
		// ["ACD", "AD", "ADE", "CD", "XYZ"]
		
		//String[] orders = {"XYZ", "XWY", "WXA"};
		//int[] course = {2, 3, 4};
		// ["WX", "XY"]
		
		if (orders.length < 2 || orders.length > 20) return;
		for (String s : orders) {
			if (s.length() < 2 || s.length() > 10) return;
		}
		
		if (course.length < 1 || course.length > 10) return;
		for (int i : course) {
			if (i < 2 || i > 10) return;
		}
		
		solution(orders, course);
	}
	
	public static String[] solution(String[] orders, int[] course) {
		String[] sortedOrders = new String[orders.length]; 

		// 1.order 정렬
		for (int i = 0; i < orders.length; i++) {
			char[] chars = orders[i].toCharArray();
			Arrays.sort(chars);
			String temp = String.valueOf(chars);
			sortedOrders[i] = temp;
		}
		
		// 2.course별 찾기
		for (int i = 0; i < course.length; i++) {			
			for (int j = 0; j < sortedOrders.length; j++) {				
				char[] chars = sortedOrders[j].toCharArray();
				perm(0, course[i], chars, sortedOrders);
			}
			result = 0;
			Collections.sort(list);
			// 3.최대값 찾기
			searchMaxCount();
		}
		
		// 4.String Array 에 담기
		Collections.sort(answer);
		String[] total = new String[answer.size()];
		for (int i = 0; i < answer.size(); i++) {
			total[i] = answer.get(i);
			System.out.println("total : " + total[i]);
		}
		return total;
	}
	
	private static void perm(int depth, int course, char[] chars, String[] sortedOrders) {
		if(depth == course){
			check(chars, course, sortedOrders);
			return;
		}
		
		for(int i = depth; i < chars.length; i++){
			swap(chars, i, depth);
			perm(depth + 1, course, chars, sortedOrders);
			swap(chars, i, depth);
		}
	}
	
	private static void swap(char[] list, int i, int j) {
		char temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	private static void check(char[] arr, int course, String[] sortedOrders){
		String temp = "";
		int count = 0;
		boolean flag = false;
        char ch = arr[0];
		for (int i = 0; i < course; i++) {
            if (ch < arr[i]) return;
            ch = arr[i];
			temp += arr[i];
		}
		 
        char[] chars = temp.toCharArray();
		Arrays.sort(chars);
		temp = String.valueOf(chars);
        
		for (int i = 0; i < sortedOrders.length; i++) {
			for (int j = 0; j < temp.length(); j++) {
				if (sortedOrders[i].contains(temp.charAt(j) + "")) {
					flag = true;
				} else {
					flag = false;
					break;
				}
			}
			
			if (flag) {
				count++;
			}
		}
		
		if (result <= count && count != 1) {
			result = count;
			list.add(temp);
		} 
	}
	
	private static void searchMaxCount() {
		int count = 0, max = 0;
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) break;
			if (list.get(i).equals(list.get(i + 1))) {
				count++;
				if (max < count) {
					max = count;
				}
			} else {
				count = 0;
			}	
		}
		
		count = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if (i == list.size() - 1) break;
			if (list.get(i).equals(list.get(i + 1))) {
				count++;
				if (max == count) {
					answer.add(list.get(i));
					count = 0;
				}
			} else {
				count = 0;
			}
		}
		
		while (list.size() > 0) {
			list.remove(0);
		}
	}
}
