package oncoder;

// �Ҽ��� �� ����
import java.util.ArrayList;
public class Solution2 {
	public static void main(String[] args) {
		//int A = 3328, B = 4100; // 4��
		//int A = 10, B = 1000; //0��
		int A = 97001, B = 97691; //89��
				
		long before = System.currentTimeMillis();
		System.out.println(solution(A, B));
		long after = System.currentTimeMillis();
		System.out.println(after - before);
	}
	
	public static int solution(int A, int B) {
		boolean flag = false;
		ArrayList<Integer> list = new ArrayList<>();
		int count = 0;
		
		for (int i = A; i <= B; i++) {
			flag = false;
			for (int j = i - 10; j <= i + 10; j++) {
				for (int k = 2; k <= Math.sqrt(j); k++) {
					if (j != k && j % k == 0) {
						// �Ҽ��� �ƴ�
						count++;
						flag = false;
						break;
					} else {
						// �Ҽ�
						flag = true;
					}
				}
				if (flag) {
					count = 0;
					break;
				}
			}
			
			if (count >= 21) {
				list.add(i);
				System.out.println("i : " + i);
			}				
		}
		
        return list.size();
    }
}
