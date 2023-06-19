package programmers.level1;

// 문자열 나누기
public class Solution59 {
    public static void main(String[] args) {
        String s = "banana"; // 3
        //String s = "abracadabra"; // 6
        //String s = "aaabbaccccabba"; // 3
        //String s = "baaa"; // 2

        if (s.length() < 1 || s.length() > 10000) return;

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;
        int aCnt = 0, bCnt = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(0) == s.charAt(i)) {
                aCnt++;
            } else {
                bCnt++;
            }

            if (aCnt == bCnt) {
                s = s.substring(aCnt + bCnt);
                aCnt = 0;
                bCnt = 0;
                i = -1;
                answer++;
            }
        }
        if (aCnt != 0 || bCnt != 0) answer++;

        return answer;
    }
}