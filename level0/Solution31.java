package programmers.level0;

// A로 B 만들기
public class Solution31 {
    public static void main(String[] args) {
        String before = "olleh";
        String after = "hello";
        // 1
        //String before = "allpe";
        //String after = "apple";
        // 0

        if (before.length() < 0 || before.length() > 1000) return;
        if (after.length() < 0 || after.length() > 1000) return;

        System.out.println(solution(before, after));
    }

    public static int solution(String before, String after) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < before.length(); i++) {
            sum1 += before.charAt(i);
            sum2 += after.charAt(i);
        }
        return sum1 == sum2 ? 1 : 0;
    }
}
