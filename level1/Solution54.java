package programmers.level1;

// 둘만의 암호
public class Solution54 {
    public static void main(String[] args) {
        //String s = "aukks";
        //String skip = "wbqd";
        //int index = 5;
        // happy
        String s = "ybcde";
        String skip = "az";
        int index = 1;
        // bcdef
        //String s = "z";
        //String skip = "abcdefghij";
        //int index = 20;
        // n

        if (s.length() < 5 || s.length() > 50) return;
        if (skip.length() < 1 || skip.length() > 10) return;
        if (index < 1 || index > 20) return;

        System.out.println(solution(s, skip, index));
    }

    public static String solution(String s, String skip, int index) {
        int count = index;
        String answer = "";

        for (char ch : s.toCharArray()) {
            for (int i = 0; i < count; i++) {
                ch++;
                if (ch > 122) ch -= 26;
                if (skip.contains(String.valueOf(ch))) {
                    count++;
                }
            }
            answer += (char) ch;
            count = index;
        }

        return answer;
    }
}