package programmers.level2;

import java.util.*;

// 리코쳇 로봇
public class Solution53 {
    public static void main(String[] args) {
        //String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."}; // 7
        String[] board = {".D.R", "....", ".G..", "...D"}; // -1

        if (board.length < 3 || board.length > 100) return;
        for (int i = 0; i < board.length; i++) {
            if (board[i].length() < 0 || board[i].length() > 100) return;
        }

        System.out.println(solution(board));
    }

    public static int solution(String[] board) {
        /*
        "...D..R"
        ".D.G..."
        "....D.D"
        "D....D."
        "..D...."
         */
        int up = 0, down = 0, left = 0, right = 0;
        boolean isVisited = false;
        List<Integer> result = new ArrayList<>();
        Map<int[], Integer> map = new HashMap<>();
        Set<int[]> visited = new HashSet<>();
        Queue<int[]> location = new LinkedList<>();

        // 1. start 위치 찾기
        for (int i = 0; i < board.length; i++) {
            if (board[i].contains("R")) {
                location.add(new int[] {i, board[i].indexOf("R")});
            }
        }

        // 2. BFS 찾기
        map.put(location.peek(), 0);
        while (!location.isEmpty()) {
            int[] start = location.poll();
            visited.add(start);
            if (board[start[0]].charAt(start[1]) == 'G') {
                result.add(map.get(start));
                continue;
            }

            // 2.1 up
            while (start[0] - up - 1 >= 0
                    && board[start[0] - up - 1].charAt(start[1]) != 'D') {
                up++;
            }
            if (up != 0) {
                int[] temp = new int[] {start[0] - up, start[1]};
                for (int[] vi : visited) {
                    if (vi[0] == temp[0] && vi[1] == temp[1]) {
                        isVisited = true;
                        break;
                    }
                }
                if (!isVisited) {
                    location.add(temp);
                    visited.add(temp);
                    map.put(temp, map.get(start) + 1);
                }
                up = 0;
            }
            isVisited = false;
            // 2.2 down
            while (start[0] + down + 1 <= board.length - 1
                    && board[start[0] + down + 1].charAt(start[1]) != 'D') {
                down++;
            }
            if (down != 0) {
                int[] temp = new int[] {start[0] + down, start[1]};
                for (int[] vi : visited) {
                    if (vi[0] == temp[0] && vi[1] == temp[1]) {
                        isVisited = true;
                        break;
                    }
                }
                if (!isVisited) {
                    location.add(temp);
                    visited.add(temp);
                    map.put(temp, map.get(start) + 1);
                }
                down = 0;
            }
            isVisited = false;
            // 2.3 left
            while (start[1] - left - 1 >= 0
                    && board[start[0]].charAt(start[1] - left - 1) != 'D') {
                left++;
            }
            if (left != 0) {
                int[] temp = new int[] {start[0], start[1] - left};
                for (int[] vi : visited) {
                    if (vi[0] == temp[0] && vi[1] == temp[1]) {
                        isVisited = true;
                        break;
                    }
                }
                if (!isVisited) {
                    location.add(temp);
                    visited.add(temp);
                    map.put(temp, map.get(start) + 1);
                }
                left = 0;
            }
            isVisited = false;
            // 2.4 right
            while (start[1] + right + 1 <= board[0].length() - 1
                    && board[start[0]].charAt(start[1] + right + 1) != 'D') {
                right++;
            }
            if (right != 0) {
                int[] temp = new int[] {start[0], start[1] + right};
                for (int[] vi : visited) {
                    if (vi[0] == temp[0] && vi[1] == temp[1]) {
                        isVisited = true;
                        break;
                    }
                }
                if (!isVisited) {
                    location.add(temp);
                    visited.add(temp);
                    map.put(temp, map.get(start) + 1);
                }
                right = 0;
            }
            isVisited = false;
        }

        Collections.sort(result);
        return result.size() > 0 ? result.get(0) : -1;
    }
}