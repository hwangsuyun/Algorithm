package programmers.level2;

import java.util.*;

// 무인도 여행
public class Solution58 {
    public static void main(String[] args) {
        //String[] maps = {"X591X","X1X5X","X231X", "1XXX1"}; // [1, 1, 27]
        String[] maps = {"XXX","XXX","XXX"}; // [-1]

        if (maps.length < 3 || maps.length > 100) return;
        for (int i = 0; i < maps.length; i++) {
            if (maps[i].length() < 3 || maps[i].length() > 100) return;
        }

        int[] result = solution(maps);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(String[] maps) {
        /*
        1. maps 배열을 순회하면서 X 가 아닌 값을 찾는다.
        1.1 최초 찾은 값을 더하고, visited 를 체크한다.
        2. X 가 아니면 DFS 탐색하면서 위아래좌우 값을 찾는다.
        2.1 탐색한 곳은 visited 에 기록, stack 에 담고 값을 더한다.
        3. 탐색이 종료되면 더한 값을 배열에 담는다.
        4. 1번부터 다시 반복한다.
        4.1 탐색한 곳 visited 는 제외한다.
        "X591X"
        "X1X5X"
        "X231X"
        "1XXX1"
        */
        List<Integer> answer = new ArrayList<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Stack<int[]> stack = new Stack<>();
        int sum = 0;
        int[] nx = {-1, 1, 0, 0};
        int[] ny = {0, 0, -1, 1};

        //1. maps 배열을 순회하면서 X 가 아닌 값을 찾는다.
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {
                if (maps[i].charAt(j) != 'X' && !visited[i][j]) {
                    // 1.1 최초 찾은 값을 더하고, visited 를 체크한다.
                    sum += Integer.parseInt(maps[i].charAt(j) + "");
                    visited[i][j] = true;

                    // 2. X 가 아니면 DFS 탐색하면서 위아래좌우 값을 찾는다.
                    stack.push(new int[] {i, j});
                    while (!stack.isEmpty()) {
                        int[] point = stack.pop();
                        int x = point[0];
                        int y = point[1];

                        for (int k = 0; k < 4; k++) {
                            int nextX = x;
                            int nextY = y;
                            nextX += nx[k];
                            nextY += ny[k];

                            if (nextX > -1 && nextX < maps.length && nextY > -1 && nextY < maps[0].length()) {
                                if (!visited[nextX][nextY] && maps[nextX].charAt(nextY) != 'X') {
                                    // 2.1 탐색한 곳은 visited 에 기록, stack 에 담고 값을 더한다.
                                    stack.push(new int[] {nextX, nextY});
                                    visited[nextX][nextY] = true;
                                    sum += Integer.parseInt(maps[nextX].charAt(nextY) + "");
                                }
                            }
                        }
                    }
                    // 3. 탐색이 종료되면 더한 값을 배열에 담는다.
                    answer.add(sum);
                    sum = 0;
                }
            }
        }

        if (answer.size() == 0) answer.add(-1);
        else Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }

}