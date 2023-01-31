package programmers.level0;

// 문자열안에 문자열
public class Solution11 {
    public static void main(String[] args) {
        //String str1 = "ab6CDE443fgh22iJKlmn1o", str2 = "6CD"; // 1
        String str1 = "ppprrrogrammers", str2 = "pppp"; // 2

        if (str1.length() < 1 || str1.length() > 100) return;
        if (str2.length() < 1 || str2.length() > 100) return;

        System.out.println(solution(str1, str2));
    }

    public static int solution(String str1, String str2) {
        return str1.contains(str2) ? 1 : 2;
    }
}
