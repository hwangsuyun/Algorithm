package programmers.level1;

// 가장 가까운 같은 글자
public class Solution58 {
    public static void main(String[] args) {
        //String s = "banana"; // [-1, -1, -1, 2, 2, 2]
        String s = "foobar"; // [-1, -1, 1, -1, -1, -1]

        if (s.length() < 1 || s.length() > 10000) return;

        int[] result = solution(s);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(String s) {
        int[] answer = new int[s.length()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = -1;
        }

        for (int i = 0; i < s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    answer[i] = i - j;
                    break;
                }
            }
        }

        return answer;
    }
}