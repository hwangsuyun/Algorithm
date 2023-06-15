package programmers.level1;

// 크기가 작은 부분 문자열
public class Solution56 {
    public static void main(String[] args) {
        String t = "3141592";
        String p = "271";
        // 2
        //String t = "500220839878";
        //String p = "7";
        // 8
        //String t = "10203";
        //String p = "15";
        // 3

        if (t.length() < p.length() || t.length() > 10000) return;
        if (p.length() < 1 || p.length() > 18) return;

        System.out.println(solution(t, p));
    }

    public static int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i <= t.length() - p.length(); i++) {
            String str = t.substring(i, i + p.length());
            if (Long.parseLong(str) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}