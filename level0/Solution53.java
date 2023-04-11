package programmers.level0;

// 문자열 정렬하기 (1)
public class Solution53 {
    public static void main(String[] args) {
        //String my_string = "hi12392"; // [1, 2, 2, 3, 9]
        //String my_string = "p2o4i8gj2"; // [2, 2, 4, 8]
        String my_string = "abcde0"; // [0]

        if (my_string.length() < 1 || my_string.length() > 100) return;

        int[] result = solution(my_string);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(String my_string) {
        return my_string.chars()
                .mapToObj(i -> (char) i)
                .filter(Character::isDigit)
                .map(String::valueOf)
                .mapToInt(Integer::valueOf)
                .sorted()
                .toArray();
    }
}