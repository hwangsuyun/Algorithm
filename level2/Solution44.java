package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// ���� �� �ִܰŸ�
public class Solution44 {
	static int[][] dp;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
	public static void main(String[] args) {
		int[][] maps = {
				{1, 0, 1, 1, 1}, 
				{1, 0, 1, 0, 1},
				{1, 0, 1, 1, 1},
				{1, 1, 1, 0, 1},
				{0, 0, 0, 0, 1}
			}; // 11
		/*
		int[][] maps = {
				{1, 0, 1, 1, 1},
				{1, 0, 1, 0, 1},
				{1, 0, 1, 1, 1},
				{1, 1, 1, 0, 0},
				{0, 0, 0, 0, 1}
				
			}; // -1
		*/
		
		for (int i = 0; i < maps.length; i++) {
			for (int j = 0; j < maps[i].length; j++) {
				if (maps[i][j] != 1 && maps[i][j] != 0) return;
				if (maps.length == 1 && maps[i].length == 1) return;
			}
		}
		
		System.out.println(solution(maps));
	}
	
	public static int solution(int[][] maps) {
		int row = maps.length;
        int column = maps[0].length;
        visited = new boolean[row][column];
        dp = new int[row][column];
        for (int[] ints : dp) {
            //Arrays.fill(ints, -1);
        }

        bfs(0,0, maps);

        return dp[row - 1][column - 1];
	}
	
	private static void bfs(int x, int y, int[][] maps) {
        Queue<Dot> q = new LinkedList<>();
        q.offer(new Dot(x, y));
        visited[x][y] = true;
        dp[x][y] = 1;

        while (!q.isEmpty()) {
            Dot now = q.poll();

            for (int i = 0 ; i < 4; i++) {
                int tx = now.x + dx[i];
                int ty = now.y + dy[i];

                // ������ ���� ���� ���
                if(tx < 0 || tx >= maps.length || ty < 0 || ty >= maps[0].length) continue;

                // ���� ���
                if(maps[tx][ty] == 0) continue;

                // �̹湮�� ��� �湮 ó�� �� dp �� ����
                if(!visited[tx][ty]) {
                	System.out.println("tx : " + tx + ", ty : " + ty);
                	
                    visited[tx][ty] = true;
                    dp[tx][ty] = dp[now.x][now.y] + 1;
                    q.offer(new Dot(tx, ty));
                }
            }
        }
    }	
}

class Dot {
    int x;
    int y;

    public Dot(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
