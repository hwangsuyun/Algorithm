package programmers.level1;

// ���￡�� �輭�� ã��
public class Solution15 {
	public static void main(String[] args) {
		String[] seoul = {"Jane", "Kim"};
		if (seoul.length < 1 || seoul.length > 1000) return;
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].length() < 1 || seoul[i].length() > 20) return; 
		}
		solution(seoul);
	}
	
	public static String solution(String[] seoul) {
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equals("Kim")) return "�輭���� " + i + "�� �ִ�";
		}
		return "";
	}
}
