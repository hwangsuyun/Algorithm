package com.example.algorithm.level1;

// [PCCE 기출문제] 9번 / 이웃한 칸
public class Solution82 {
    public static void main(String[] args) {
        String[][] board = {{"blue", "red", "orange", "red"},
                {"red", "red", "blue", "orange"},
                {"blue", "orange", "red", "red"},
                {"orange", "orange", "red", "blue"}};
        int h = 1;
        int w = 1;
        // 2
        //String[][] board = {{"yellow", "green", "blue"}, {"blue", "green", "yellow"}, {"yellow", "blue", "blue"}};
        //int h = 0;
        //int w = 1;
        // 1

        System.out.println(solution(board, h, w));
    }

    public static int solution(String[][] board, int h, int w) {
        /*
        1. 정수를 저장할 변수 n을 만들고 board의 길이를 저장합니다.
        2. 같은 색으로 색칠된 칸의 개수를 저장할 변수 count를 만들고 0을 저장합니다.
        3. h와 w의 변화량을 저장할 정수 리스트 dh, dw를 만들고 각각 [0, 1, -1, 0], [1, 0, 0, -1]을 저장합니다.
        4. 반복문을 이용해 i 값을 0부터 3까지 1 씩 증가시키며 아래 작업을 반복합니다.
            4-1. 체크할 칸의 h, w 좌표를 나타내는 변수 h_check, w_check를 만들고 각각 h + dh[i], w + dw[i]를 저장합니다.
            4-2. h_check가 0 이상 n 미만이고 w_check가 0 이상 n 미만이라면 다음을 수행합니다.
                4-2-a. board[h][w]와 board[h_check][w_check]의 값이 동일하다면 count의 값을 1 증가시킵니다.
        5. count의 값을 return합니다.
         */
        int n = board.length;
        int count = 0;
        int[] dh = {0, 1, -1, 0};
        int[] dw = {1, 0, 0, -1};
        for (int i = 0; i <= 3; i++) {
            int h_check = h + dh[i];
            int w_check = w + dw[i];
            if (h_check >= 0 && h_check < n && w_check >= 0 && w_check < n) {
                if (board[h][w].equals(board[h_check][w_check])) {
                    count++;
                }
            }
        }
        return count;
    }

    public static int solution2(String[][] board, int h, int w) {
        int answer = 0;
        String sC = board[h][w];

        if(h > 0 && sC.equals(board[h-1][w])) answer++;
        if(h < board.length - 1 && sC.equals(board[h+1][w])) answer++;
        if(w > 0 && sC.equals(board[h][w-1])) answer++;
        if(w < board[h].length - 1 && sC.equals(board[h][w+1])) answer++;
        return answer;
    }
}