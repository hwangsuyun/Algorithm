package programmers.level0;

// OX퀴즈
public class Solution12 {
    public static void main(String[] args) {
        //String[] quiz = {"3 - 4 = -3", "5 + 6 = 11"}; // "X", "O"
        //String[] quiz = {"19 - 6 = 13", "5 + 66 = 71", "5 - 15 = 63", "3 - 1 = 2"}; // "O", "O", "X", "O"
        String[] quiz = {"-1 - -3 = 2"}; // "O"

        if (quiz.length < 1 || quiz.length > 10) return;

        solution(quiz);
    }

    public static String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        String[] strArray = new String[quiz.length * 5];
        int index = 0;
        for (String str : quiz) {
            strArray = str.split(" ");
            if (strArray[1].equals("+")) {
                if (Integer.parseInt(strArray[0]) + Integer.parseInt(strArray[2])
                        == Integer.parseInt(strArray[4])) {
                    answer[index] = "O";
                } else {
                    answer[index] = "X";
                }
            } else {
                if (Integer.parseInt(strArray[0]) - Integer.parseInt(strArray[2])
                        == Integer.parseInt(strArray[4])) {
                    answer[index] = "O";
                } else {
                    answer[index] = "X";
                }
            }
            System.out.println(answer[index]);
            index++;
        }

        return answer;
    }
}
