package programmers.level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// ¿ÀÇÂÃ¤ÆÃ¹æ
public class Solution40 {
	public static void main(String[] args) {
		String[] record = {
				"Enter uid1234 Muzi", "Enter uid4567 Prodo",
				"Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"
				};
		
		if (record.length < 1 || record.length > 100000) return;
		
		solution(record);
	}
	
	public static String[] solution(String[] record) {
		HashMap<String, String> user = new HashMap<>();
		String[][] input = new String[record.length][3];
		List<String> temp = new ArrayList<>();

		for (int i = 0; i < record.length; i++) {
			input[i] = record[i].split(" ");
			if (input[i].length == 3) {
				user.put(input[i][1], input[i][2]);
			}
		}
		
		for (int i = 0; i < record.length; i++) {
			input[i] = record[i].split(" ");
			
			if (input[i][0].equals("Enter")) {
				temp.add(user.get(input[i][1]) + "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
			}
			else if (input[i][0].equals("Leave")) {
				temp.add(user.get(input[i][1]) + "´ÔÀÌ ³ª°¬½À´Ï´Ù.");
			}
		}
		
		String[] output = new String[temp.size()];
		for (int i = 0; i < temp.size(); i++) {
			output[i] = temp.get(i);
			System.out.println(output[i]);
		}
		
		return output;
    }
	
	
}
