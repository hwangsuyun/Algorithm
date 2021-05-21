package programmers.level2;

// 전화번호 목록
public class Solution15 {
	public static void main(String[] args) {
		//String[] phone_book = {"119", "97674223", "1195524421"};
		//String[] phone_book = {"123", "456", "789"};
		//String[] phone_book = {"12", "123", "1235", "567", "88"};
		//String[] phone_book = {"12232332", "12", "222222"};
		//String[] phone_book = {"911", "97625999", "91125426"};
		String[] phone_book = {"113", "12340", "123440", "12345", "98346"};
		if (phone_book.length < 1 || phone_book.length > 1000000) return;
		for (int i = 0; i < phone_book.length; i++) {
			if (phone_book[i].length() < 1 || phone_book[i].length() > 20) return;
		}
		solution(phone_book);
	}
	
	public static boolean solution(String[] phone_book) {
		boolean flag = true;		
		for (int i = 0; i < phone_book.length; i++) {
			String temp = phone_book[i];
			for (int j = 0; j < phone_book.length; j++) {
				if (temp.equals(phone_book[j]) || temp == phone_book[j]) continue;
				if (temp.length() > phone_book[j].length()) continue;
				if (temp.equals(phone_book[j].substring(0, temp.length()))) {
					flag = false;
					break;
				}
			}
			if (!flag) break;
		}
		System.out.println(flag);
		return flag;
	}
}
