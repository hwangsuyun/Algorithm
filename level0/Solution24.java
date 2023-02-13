package programmers.level0;

// 대문자와 소문자
public class Solution24 {
    public static void main(String[] args) {
        //String my_string = "cccCCC"; // CCCccc
        String my_string = "abCdEfghIJ"; // ABcDeFGHij

        if (my_string.length() < 1 || my_string.length() > 1000) return;

        System.out.println(solution(my_string));
    }

    public static String solution(String my_string) {
        char[] chArray = my_string.toCharArray();
        String answer = "";
        for (char ch : chArray) {
            answer += Character.isLowerCase(ch) ? (char) (ch - 32) : (char) (ch + 32);
        }
        return answer;
    }
}
