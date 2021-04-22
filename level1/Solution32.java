package programmers.level1;

// 핸드폰 번호 가리기
public class Solution32 {
	public static void main(String[] args) {
		//String phone_number = "01033334444";
		String phone_number = "027778888";
		if (phone_number.length() < 4 || phone_number.length() > 20) return;
		System.out.println(solution(phone_number));
	}
	
	public static String solution(String phone_number) {
		return phone_number.substring(0, phone_number.length() - 4).replaceAll("[0-9]", "*") 
				+ phone_number.substring(phone_number.length() - 4);
	}
}
