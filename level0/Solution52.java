package programmers.level0;

// 숨어있는 숫자의 덧셈 (1)
public class Solution52 {
    public static void main(String[] args) {
        //String my_string = "aAb1B2cC34oOp"; // 10;
        String my_string = "1a2b3c4d123"; // 16;

        if (my_string.length() < 1 || my_string.length() > 1000) return;

        System.out.println(solution(my_string));
    }

    public static int solution(String my_string) {
        int sum = 0;
        char[] cArrays = my_string.toCharArray();
        for (char ch : cArrays) {
            if (Character.getNumericValue(ch) >= 1 && Character.getNumericValue(ch) <= 9) sum += Character.getNumericValue(ch);
        }
        return sum;
    }
}