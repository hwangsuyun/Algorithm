package programmers.level1;

// ���ڼ��ڼ��ڼ��ڼ��ڼ�?
public class Solution17 {
	public static void main(String[] args) {
		int n = 5;
		if (n < 1 || n > 10000) return;
		solution(n);
	}
	
	public static String solution(int n) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			// ���ǹ�
			if (i % 2 == 0) sb.append("��");
			else sb.append("��");
			// ���� ������
			// sb.append(i % 2 == 0 ? "��" : "��"); 
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
}
