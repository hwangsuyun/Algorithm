package programmers.level1;

// 숫자 문자열과 영단어
public class Solution75 {
    public static void main(String[] args) {
        //String s = "one4seveneight"; // 1478
        //String s = "23four5six7"; // 234567
        //String s = "2three45sixseven"; // 234567
        String s = "123"; // 123

        if (s.length() < 1 || s.length() > 50) return;

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        return Integer.parseInt(s.replace("zero", "0")
                .replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9"));
    }
}