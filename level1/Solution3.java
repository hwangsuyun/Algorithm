package programmers.level1;

public class Solution3 {
	public static void main(String[] args) {
		int length = 10000;
		//int length = 5;
		int[] answers = new int[length];
		int[] result = solution(answers);
		for (int i = 0; i < result.length; i++) {
			if (result[i] != 0) System.out.println(result[i]);
		}
		System.out.println(result.length);
	}	
	
	public static int[] solution(int[] answers) {
		int[] person1 = new int[answers.length];
		int[] person2 = new int[answers.length];
		int[] person3 = new int[answers.length];
		int p1Cnt = 0;
		int p2Cnt = 0;
		int p3Cnt = 0;
		int[] all = new int[3];		
		
		for (int i = 0; i < answers.length; i++) {
			answers[i] = (int) (Math.random() * 10) + 1;			
			if (answers[i] > 5) answers[i] -= 5;
			//answers[i] = i + 1;			
			person1[i] = (i + 1) % 5;
			if (person1[i] == 0) person1[i] = 5;			

			if (i % 2 == 0) person2[i] = 2;
			else if (i % 8  == 1) person2[i] = 1;
			else if (i % 8 == 3) person2[i] = 3;
			else if (i % 8 == 5) person2[i] = 4;
			else if (i % 8 == 7) person2[i] = 5;

			if (i % 10 == 0) person3[i] = 3;
			else if (i % 10 == 1) person3[i] = 3;
			else if (i % 10 == 2) person3[i] = 1;
			else if (i % 10 == 3) person3[i] = 1;
			else if (i % 10 == 4) person3[i] = 2;
			else if (i % 10 == 5) person3[i] = 2;
			else if (i % 10 == 6) person3[i] = 4;
			else if (i % 10 == 7) person3[i] = 4;
			else if (i % 10 == 8) person3[i] = 5;
			else if (i % 10 == 9) person3[i] = 5;

			if (answers[i] == person1[i]) p1Cnt++;
			if (answers[i] == person2[i]) p2Cnt++;
			if (answers[i] == person3[i]) p3Cnt++;
		}

		System.out.println(p1Cnt);
		System.out.println(p2Cnt);
		System.out.println(p3Cnt);

		int newAll[] = {};
		
		if (p1Cnt > p2Cnt) {
			if (p1Cnt > p3Cnt) {
				all[0] = 1;
				newAll = new int[1];
				newAll[0] = all[0];
				return newAll;
			} else if (p1Cnt == p3Cnt) {
				all[0] = 1;
				all[1] = 3;
				newAll = new int[2];
				newAll[0] = all[0];
				newAll[1] = all[1];
				return newAll;
			} else if (p1Cnt < p3Cnt) {
				all[0] = 3;
				newAll = new int[1];
				newAll[0] = all[0];
				return newAll;
			}
		} else if (p1Cnt == p2Cnt) {
			if (p1Cnt > p3Cnt) {
				all[0] = 1;
				all[1] = 2;
				newAll = new int[2];
				newAll[0] = all[0];
				newAll[1] = all[1];
				return newAll;
			} else if (p1Cnt < p3Cnt) {
				all[0] = 3;
				newAll = new int[1];
				newAll[0] = all[0];
				return newAll;
			} else if (p1Cnt == p3Cnt) {
				all[0] = 1;
				all[1] = 2;
				all[2] = 3;
				newAll = new int[3];
				newAll[0] = all[0];
				newAll[1] = all[1];
				newAll[2] = all[2];
				return newAll;
			}
		} else if (p1Cnt < p2Cnt) {
			if (p2Cnt > p3Cnt) {
				all[0] = 2;
				newAll = new int[1];
				newAll[0] = all[0];
				return newAll;
			} else if (p2Cnt == p3Cnt) {
				all[0] = 2;
				all[1] = 3;
				newAll = new int[2];
				newAll[0] = all[0];
				newAll[1] = all[1];
				return newAll;
			} else if (p2Cnt < p3Cnt) {
				all[0] = 3;
				newAll = new int[1];
				newAll[0] = all[0];
				return newAll;
			}
		}
		return newAll;
	}
}