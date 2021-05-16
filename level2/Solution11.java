package programmers.level2;

// 조이스틱
public class Solution11 {
	public static void main(String[] args) {
		//String name = "JEROEN";        // 56
		String name = "JAN";           // 23
		//String name = "ABABAAAAAAABA"; // 10
		//String name = "ABAAAAAAAAABB"; // 7
		//String name = "AAABAAAA";      // 4
		//String name = "AAABAAAAB";     // 7
		//String name = "CANAAAAANAN";   // 48
		//String name = "AAABBAAA";   // 6
		//String name = "AAABABAA";   // 7
		//String name = "AAABAABA";   // 7
		//String name = "AAABAAAB";   // 7
		//String name = "AAAABAAAB";    // 7
		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) < 'A' || name.charAt(i) > 'Z') return;
		}
		if (name.length() < 1 || name.length() > 20) return;
		solution(name);
	}
	
	public static int solution(String name) {
		int upDown = 0, leftCnt = 0, rightCnt = 0, tempCnt = 0, result = 0;
		boolean flag = false;
		// 1. move UP or DOWN + rightCnt 
		for (int i = 0; i < name.length(); i++) {
			// rightCnt (오른쪽으로 이동하는게 최적일 경우)
			if (name.charAt(i) != 'A') {
				if (name.charAt(i) <= 'N') {
					upDown += name.charAt(i) - 'A';
				} else {
					upDown += 'Z' + 1 - name.charAt(i);	
				}
				rightCnt = i;
			} else flag = true;
		}
		// 2. leftCnt (왼 쪽으로 이동하는게 최적일 경우)
		for (int i = name.length() - 1; i >= 0; i--) {
			if (i != 0 && name.charAt(i) != 'A') leftCnt = name.length() - i;
		}
		// 왼쪽과 오른쪽 비교하여 최적의 수 찾기
		if (leftCnt >= rightCnt) result = rightCnt;
		else result = leftCnt;
		
		// 3. leftCnt + rightCnt (좌우로 이동하면서 찾는게 최적일 경우) 
		tempCnt = result;
		leftCnt = 0; rightCnt = 0;
        
		for (int i = 0; i < name.length(); i++) {
			if (flag) {
				if (i < name.length() / 2) {
					if (name.charAt(i) != 'A') leftCnt = i;
				} else {
					if (name.charAt(i) != 'A') {
						rightCnt = name.length() - i;
						break;
					}
				}
			} else leftCnt = name.length() - 1;
			System.out.print(name.charAt(i) + ", ");
		}
		if (leftCnt >= rightCnt) result = (rightCnt * 2) + leftCnt; 
		else result = (leftCnt * 2) + rightCnt;
        
		// 한 방향으로만 이동한 수와 좌우로 이동한 수 비교하여 최적의 수 찾기
		if (tempCnt > result) result += upDown;
		else result = tempCnt + upDown;
        
		return result;
	}
}
