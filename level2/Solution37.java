package programmers.level2;

// 영어 끝말잇기
public class Solution37 {
	public static void main(String[] args) {
		//int n = 3;
		//String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		//int n = 5;
		//String[] words = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
		//int n = 2;
		//String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "bot", "tank"};
		if (n < 2 || n > 10) return;
		if (words.length < n || words.length > 100) return;
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() < 2 || words[i].length() > 50) return;
			for (int j = 0; j < words[i].length(); j++) {
				if (words[i].charAt(j) < 'a' || words[i].charAt(j) > 'z') return;
			}
		}
		solution(n, words);
	}
	public static int[] solution(int n, String[] words) {
		int[] result = new int[2];
		boolean flag = false;
		int temp = 0, cnt = 0, index = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < i; j++) {
				if (words[j].equals(words[i])) {
					temp = i + 1;
					flag = true;
					break;
				}
			}
			if (flag) break;
			if (i == words.length - 1) break;
			if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
				temp = i + 2;
				flag = true;
				break;
			} 
			if (words[i].equals(words[i + 1])) {
				temp = i + 2;
				flag = true;
				break;
			}
		}
		if (flag) {
			System.out.println(temp);
			if (temp % n == 0) result[0] = n;
			else result[0] = temp % n;
			while (temp > 0) {
				temp -= n;
				cnt++;
			}
			result[1] = cnt;
		} else {
			result[0] = 0;
			result[1] = 0;
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		return result;
	}
}
