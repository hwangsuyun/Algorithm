package programmers.level0;

// 특정 문자 제거하기
public class Solution74 {
    public static void main(String[] args) {
        //String my_stirng = "abcdef";
        //String letter = "f";
        // "abcde"
        String my_stirng = "BCBdbe";
        String letter = "B";
        // "Cdbe"

        if (my_stirng.length() < 1 || my_stirng.length() > 100) return;
        if (letter.length() != 1) return;

        System.out.println(solution(my_stirng, letter));
    }

    public static String solution(String my_string, String letter) {
        return my_string.replace(letter, "");
    }
}