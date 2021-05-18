package programmers.level1;

// 음양 더하기
public class Solution47 {
	public static void main(String[] args) {
		//int[] absolutes = {4, 7, 12};    // 9
		//boolean[] signs = {true, false, true};
		int[] absolutes = {1, 2, 3};    // 0
		boolean[] signs = {false, false, true};
		
		if (absolutes.length < 1 || absolutes.length > 1000) return;
		for (int i = 0; i < absolutes.length; i++) {
			if (absolutes[i] < 1 || absolutes[i] > 1000) return;
		}
		if (signs.length < 1 || signs.length > 1000) return;
		
		System.out.println(solution(absolutes, signs));
	}
	
	public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        for (int i = 0; i < absolutes.length; i++) {
        	if (signs[i] == true) {
        		answer += absolutes[i];
        	}
        	else if (signs[i] == false) {
        		answer += absolutes[i] * -1;
        	}
        }
        return answer;
    }
}
