package programmers.level1;

// 로또의 최고 순위와 최저 순위
public class Solution46 {
	public static void main(String[] args) {
		//int[] lottos = {44, 1, 0, 0, 31, 25};    // 3, 5
		//int[] win_nums = {31, 10, 45, 1, 6, 19};
		//int[] lottos = {0, 0, 0, 0, 0, 0};    // 1, 6
		//int[] win_nums = {38, 19, 20, 40, 15, 25};
		int[] lottos = {45, 4, 35, 20, 3, 9};    // 1, 1
		int[] win_nums = {20, 9, 3, 45, 4, 35};
		
		if (lottos.length != 6) return;
		for (int i = 0; i < lottos.length; i++) {
			if (lottos[i] < 0 || lottos[i] > 45) return;
		}
		if (win_nums.length != 6) return;
		for (int i = 0; i < win_nums.length; i++) {
			if (win_nums[i] < 0 || win_nums[i] > 45) return;
		}
		
		solution(lottos, win_nums);
	}
	
	public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int min = 0, max = 0;
        for (int i = 0; i < lottos.length; i++) {
        	if (lottos[i] == 0) {
        		max++;
        		continue;
        	}
        	for (int j = 0; j < win_nums.length; j++) {
        		if (lottos[i] == win_nums[j]) {
        			min++;
        			break;
        		}
        	}
        }
        
        answer[0] = gradeLottoLanking(min + max);
        answer[1] = gradeLottoLanking(min);
        
        for (int i = 0; i < answer.length; i++) {
        	System.out.println(answer[i]);
        }
        
        return answer;
    }
	
	private static int gradeLottoLanking(int number) {
		switch (number) {
			case 2:
				return 5;
			case 3:
				return 4;
			case 4:
				return 3;
			case 5:
				return 2;
			case 6:
				return 1;
			default:
				return 6;
		}
	}
}
