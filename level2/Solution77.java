package programmers.level2;

// N-Queen
public class Solution77 {
    static boolean[] row; // 각 행에 퀸을 이미 배치했는지 체크
    static boolean[] diagonalA; // / 대각선 방향으로 퀸을 배치했는지 체크
    static boolean[] diagonalB; // \ 대각선 방향으로 퀸을 배치했는지 체크
    static int[] pos; // 각 열에 있는 퀸의 위치
    static int count;

    public static void main(String[] args) {
        int n = 4;

        if (n < 0 || n > 12) return;
        solution(n);
    }

    public static int solution(int n) {
        row = new boolean[n]; // 각 행에 퀸을 이미 배치했는지 체크
        diagonalA = new boolean[n * 2 - 1]; // / 대각선 방향으로 퀸을 배치했는지 체크
        diagonalB = new boolean[n * 2 - 1]; // \ 대각선 방향으로 퀸을 배치했는지 체크
        pos = new int[n]; // 각 열에 있는 퀸의 위치

        set(0, n); // 0 열에 퀸을 배치
        System.out.println("count : " + count);
        return count;
    }

    // 재귀 함수 호출
    public static void set(int i, int n) { // i는 열
        for (int j = 0; j < n; j++) {
            if (!row[j]                   // 가로(j행)에 아직 배치하지 않음
                    && !diagonalA[i + j]        // / 대각선에 아직 배치하지 않음
                    && !diagonalB[i - j + n - 1]) { // \ 대각선에 아직 배치하지 않음
                pos[i] = j; // 퀸을 j행에 배치 (j는 행)
                if (i == n - 1) { // 모든 열에 배치
                    count++;
                } else {
                    row[j] = true;
                    diagonalA[j + i] = true;
                    diagonalB[i - j + n - 1] = true;
                    set(i + 1, n); // 다음 열에 퀸을 배치
                    row[j] = false;
                    diagonalA[j + i] = false;
                    diagonalB[i - j + n - 1] = false;
                }
            }
        }
    }
}