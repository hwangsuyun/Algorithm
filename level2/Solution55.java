package programmers.level2;

// 혼자서 하는 틱택토
public class Solution55 {
    public static void main(String[] args) {
        String[] board = {"O.X", ".O.", "..X"}; // 1
        //String[] board = {"OOO", "...", "XXX"}; // 0
        //String[] board = {"...", ".X.", "..."}; // 0
        //String[] board = {"...", "...", "..."}; // 1

        if (board.length != 3) return;
        for (int i = 0; i < board.length; i++) {
            if (board[i].length() != 3) return;
        }

        System.out.println(solution(board));
    }

    public static int solution(String[] board) {
        int answer = 0;

        // 1. O or X 가 이겼는지 체크
        boolean successO = isSucceed(board, 'O');
        boolean successX = isSucceed(board, 'X');

        // 2. O 와 X 의 개 수 세기
        int countO = totalCount(board, 'O');
        int countX = totalCount(board, 'X');

        // 3. O or X 가 이겼을 때 체크
        if (successO && !successX) {
            if (countO - countX == 1) answer = 1;
        }
        if (!successO && successX) {
            if (countO == countX) answer = 1;
        }

        // 4. 이긴 사람이 없을 때 체크
        if (!successO && !successX) {
            if (countO - countX == 1 || countO == countX) answer = 1;
        }

        return answer;
    }

    private static boolean isSucceed(String[] board, char value) {
        if (board[0].charAt(0) == value) {
            if (board[0].charAt(1) == value && board[0].charAt(2) == value) return true;
            if (board[1].charAt(0) == value && board[2].charAt(0) == value) return true;
            if (board[1].charAt(1) == value && board[2].charAt(2) == value) return true;
        }
        if (board[0].charAt(1) == value) {
            if (board[1].charAt(1) == value && board[2].charAt(1) == value) return true;
        }
        if (board[0].charAt(2) == value) {
            if (board[1].charAt(2) == value && board[2].charAt(2) == value) return true;
            if (board[1].charAt(1) == value && board[2].charAt(0) == value) return true;
        }
        if (board[1].charAt(0) == value) {
            if (board[1].charAt(1) == value && board[1].charAt(2) == value) return true;
        }
        if (board[2].charAt(0) == value) {
            if (board[2].charAt(1) == value && board[2].charAt(2) == value) return true;
        }
        return false;
    }

    private static int totalCount(String[] board, char value) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == value) {
                    count++;
                }
            }
        }
        return count;
    }
}