package programmers.level0;

// 캐릭터의 좌표
public class Solution47 {
    public static void main(String[] args) {
        //String[] keyinput = {"left", "right", "up", "right", "right"};
        //int[] board = {11, 11};
        // [2, 1]
        String[] keyinput = {"down", "down", "down", "down", "down"};
        int[] board = {7, 9};
        // [0, -4]

        if (keyinput.length < 0 || keyinput.length > 50) return;
        if (board[0] < 1 || board[0] > 99) return;
        if (board[1] < 1 || board[1] > 99) return;
        for (int i = 0; i < keyinput.length; i++) {
            if (!keyinput[i].equals("up") &&
                !keyinput[i].equals("down") &&
                !keyinput[i].equals("left") &&
                !keyinput[i].equals("right")) return;
        }

        solution(keyinput, board);
    }

    public static int[] solution(String[] keyinput, int[] board) {
        int[] answer = {0, 0};
        for (int i = 0; i < keyinput.length; i++) {
            if (keyinput[i].equals("left")) {
                if (Math.abs(answer[0] - 1) <= board[0] / 2) {
                    answer[0] -= 1;
                }
            } else if (keyinput[i].equals("right")) {
                if (Math.abs(answer[0] + 1) <= board[0] / 2) {
                    answer[0] += 1;
                }
            } else if (keyinput[i].equals("up")) {
                if (Math.abs(answer[1] + 1) <= board[1] / 2) {
                    answer[1] += 1;
                }
            } else if (keyinput[i].equals("down")) {
                if (Math.abs(answer[1] - 1) <= board[1] / 2) {
                    answer[1] -= 1;
                }
            }
        }

        System.out.println("answer[0] : " + answer[0]);
        System.out.println("answer[1] : " + answer[1]);
        return answer;
    }
}