package programmers.level0;

// 문자열 밀기
public class Solution5 {
    public static void main(String[] args) {
        //String A = "hello", B = "ohell"; // 1
        String A = "apple", B = "elppa"; // -1

        if (A.length() != B.length()) return;
        if (A.length() < 0) return;
        if (A.length() > 100) return;

        System.out.println(solution(A, B));
    }

    public static int solution(String A, String B) {
        int answer = 0;
        String temp1 = "", temp2 = A;

        if (A.equals(B)) return answer;
        while (!A.equals(temp1)) {
            temp1 = temp2.substring(temp2.length() - 1) + temp2.substring(0, temp2.length() - 1);
            answer++;
            if (temp1.equals(B)) {
                return answer;
            }
            temp2 = temp1;
        }
        return -1;
    }
}
