package programmers.level1;

import java.util.Arrays;

// �������� ���� ����
public class Solution1 {
	public static void main(String[] args) {
		// String participant[] = {"marina", "josipa", "nikola", "vinko",
		// "filipa"};
		// String completion[] = {"marina", "josipa", "nikola", "vinko"};
		// String participant[] = {"leo", "kiki", "eden"};
		// String completion[] = {"eden", "kiki"};

		String participant[] = {"mislav", "stanko", "mislav", "ana"};
		String completion[] = {"stanko", "ana", "mislav"};
		String result = solution(participant, completion);
		System.out.println(result);
	}
	public static String solution(String[] participant, String[] completion) {
		String answer = "";
		int i;
		Arrays.sort(participant);
		Arrays.sort(completion);
		for (i = 0; i < participant.length; i++) {
			if (i == completion.length) {
				answer = participant[i];
				break;
			}
			if (!participant[i].equals(completion[i])) {
				answer = participant[i];
				break;
			}
		}
		/* 
		�迭�� ������ ���� �� ��� ȿ���� �κп��� ������ �ȳ���... 
		for (i = 0; i < participant.length; i++) {
			boolean isChecked = false;
			for (j = 0; j < completion.length; j++) {
		 		if (participant[i].equals(completion[j])) {
		 			isChecked = true;
		 			completion[j] = "";
		 			break;
				}
			}
			if (!isChecked) answer = participant[i];
		}
	    */
		return answer;
	}
}