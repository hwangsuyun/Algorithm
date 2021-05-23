package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;

// 구명보트
public class Solution17 {
	public static void main(String[] args) {
		//int[] people = {70, 50, 80, 50};
		//int[] people = {70, 80, 50};
		//int[] people = {50, 80, 50, 50, 60, 40};
		//int[] people = {40, 40, 40};
		int[] people = {10, 20, 30, 40, 50, 60, 70, 80, 90};
		//int[] people = {10, 10, 10};
		int limit = 100;
		if (people.length < 1 || people.length > 50000) return;
		for (int i : people) {
			//if (i < 40 || i > 240) return;
			if (i > limit) return;
		}
		if (limit < 40 || limit > 240) return;
		solution(people, limit);
	}
	
	public static int solution(int[] people, int limit) {
		int result = 0;
		int index = people.length - 1;
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < people.length; i++) {
			list.add(people[i]);
		}
		Collections.sort(list, Collections.reverseOrder());

		for (int i = 0; i < list.size(); i++) {
			int weight = list.get(i);
			if (weight + list.get(index) <= limit) {
				list.remove(index);
				index--;
			}
			result++;
		}
		System.out.println(result);
		return result;
	}
}
