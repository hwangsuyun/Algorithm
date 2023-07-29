package programmers.level2;

import java.util.*;

// 미로 탈출
public class Solution56 {
    public static void main(String[] args) {
        //String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"}; // 16
        //String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"}; // -1
        String[] maps = {"OOOOOL", "OXOXOO", "OOSXOX", "OXXXOX", "EOOOOX"}; // 14

        if (maps.length < 5 || maps.length > 100) return;
        for (int i = 0; i < maps.length; i++) {
            if (maps[i].length() < 5 || maps[i].length() > 100) return;
        }

        System.out.println(solution(maps));
    }

    public static int solution(String[] maps) {
        /*
        미로탈출
        1칸에 1초 최소 시간 -> bfs -> queue 구현
        특이사항
        L 레버를 당겨야 E(출구) 에서 탈출 가능
        = L 칸을 지나지 않으면 E 에서 탈출 불가
        = L 칸을 무조건 지나야 한다.
        = 지나간 길도 되돌아 갈 수 있다
        = Lever 까지의 거리를 구하고, Lever -> start 바꿔서 Exist 까지의 거리를 구한다.
        = 2번의 bfs 로 쪼갠다.
         */

        // 1.start 위치 찾기
        Queue<int[]> locate = new LinkedList<>();
        int startX = 0, startY = 0, endX = 0, endY = 0;
        for (; startX < maps.length; startX++) {
            startY = maps[startX].indexOf("S");
            if (startY != -1) {
                locate.add(new int[] {startX, startY});
                break;
            }
        }

        // 2. queue 를 순환하면서 lever 찾기
        int lever = moved(locate, maps, 'L');
        System.out.println("lever : " + lever);
        if (lever <= 0) return -1;

        // 3. queue 를 순환하면서 exist 찾기
        int exist = moved(locate, maps, 'E');
        if (exist <= 0) return -1;

        return lever + exist;
    }

    private static int moved(Queue<int[]> locate, String[] maps, char value) {
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        Map<int[], Integer> map = new HashMap<>();

        map.put(locate.peek(), 0);
        while (!locate.isEmpty()) {
            int[] point = locate.poll();
            int x = point[0];
            int y = point[1];

            if (maps[x].charAt(y) == value) {
                while (!locate.isEmpty()) locate.poll();

                locate.add(point);
                return map.get(point);
            }

            // 2.1 위아래좌우 체크
            int nextX = x - 1;
            int nextY = y;
            if (x > 0) {
                moving(maps, nextX,  nextY, locate, visited, map, point);
            }

            nextX = x + 1;
            nextY = y;
            if (x < maps.length - 1) {
                moving(maps, nextX,  nextY, locate, visited, map, point);
            }

            nextX = x;
            nextY = y - 1;
            if (y > 0) {
                moving(maps, nextX,  nextY, locate, visited, map, point);
            }

            nextX = x;
            nextY = y + 1;
            if (y < maps[0].length() - 1) {
                moving(maps, nextX,  nextY, locate, visited, map, point);
            }
        }
        return -1;
    }

    private static void moving(String[] maps, int nextX, int nextY, Queue<int[]> locate,
                               boolean[][] visited, Map<int[], Integer> map, int[] point) {
        if (maps[nextX].charAt(nextY) == 'O' || maps[nextX].charAt(nextY) == 'S'
                || maps[nextX].charAt(nextY) == 'L' || maps[nextX].charAt(nextY) == 'E') {
            int[] temp = {nextX, nextY};
            // 2.2 visited check
            if (!checkVisited(visited, temp)) {
                locate.add(temp);
                visited[temp[0]][temp[1]] = true;
                map.put(temp, map.get(point) + 1);
            }
        }
    }

    private static boolean checkVisited(boolean[][] visited, int[] temp) {
        if (visited[temp[0]][temp[1]]) {
            return true;
        }
        return false;
    }
}