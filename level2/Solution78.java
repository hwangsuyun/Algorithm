package programmers.level2;

// 하노이의 탑
public class Solution78 {
    private static int[][] temp = new int[100000][];
    private static int count;
    public static void main(String[] args) {
        int n = 2;
        if (n < 0 || n > 15) return;
        solution(n);
    }

    public static int[][] solution(int n) {
        move(n, 1, 3);

        int[][] answer = new int[count][];
        int index = 0;

        for (int[] tmp : temp) {
            if (index < count) {
                answer[index] = tmp;
                index++;
            } else {
                break;
            }
        }

        return answer;
    }

    public static void move(int no, int x, int y) {
        if (no > 1) {
            move(no - 1, x, 6 - x - y);
        }
        temp[count] = new int[]{x, y};
        count++;

        if (no > 1) {
            move(no - 1, 6 - x - y, y);
        }
    }
}