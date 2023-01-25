package programmers.level0;

// 잘라서 배열로 저장하기
public class Solution6 {
    public static void main(String[] args) {
        //String my_str = "abc1Addfggg4556b";
        //int n = 6;
        // ["abc1Ad", "dfggg4", "556b"]
        String my_str = "abcdef123";
        int n = 3;
        // ["abc", "def", "123"]

        if (my_str.length() < 1 || my_str.length() > 100) return;
        if (n < 1 || n > my_str.length()) return;

        solution(my_str, n);
    }

    public static String[] solution(String my_str, int n) {
        int size = my_str.length() % n == 0 ? my_str.length() / n : my_str.length() / n + 1;
        String[] answer = new String[size];
        int start = 0, index = 0;

        while (start < my_str.length()) {
            if (start + n <= my_str.length()) {
                answer[index] = my_str.substring(start, start + n);
            } else {
                answer[index] = my_str.substring(start);
            }
            System.out.println(answer[index]);
            start += n;
            index++;
        }

        return answer;
    }
}
