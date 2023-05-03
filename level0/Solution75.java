package programmers.level0;

// 문자 반복 출력하기
public class Solution75 {
    public static void main(String[] args) {
        String my_stirng = "hello";
        int n = 3;
        // "hhheeellllllooo"

        if (my_stirng.length() < 2 || my_stirng.length() > 5) return;
        if (n < 2 || n > 10) return;

        System.out.println(solution(my_stirng, n));
    }

    public static String solution(String my_string, int n) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            for (int j = 0; j < n; j++) {
                answer += my_string.charAt(i);
            }
        }
        return answer;
    }
}