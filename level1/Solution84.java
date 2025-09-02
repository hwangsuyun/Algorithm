public class Solution84 {
    public static void main(String[] args) {
        //int n = 22;
        //int w = 6;
        //int num = 8;
        // 3
        //int n = 13;
        //int w = 3;
        //int num = 6;
        // 4
        int n = 10;
        int w = 3;
        int num = 2;
        // 3
        System.out.println(solution(n, w, num));
    }

    public static int solution(int n, int w, int num) {
        int answer = 0;
        int[][] array = fillArray(n, w);

        for (int j = 0; j < w; j++) {
            answer = 0;
            for (int i = n / w; i >= 0; i--) {
                if (array[i][j] != 0) answer++;
                if (array[i][j] == num) {
                    return answer;
                }
            }
        }

        return answer;
    }

    private static int[][] fillArray(int n, int w) {
        int[][] array = new int[n / w + 1][w];
        int count = 1;

        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                for (int j = w - 1; j >= 0; j--) {
                    if (count > n) break;
                    array[i][j] = count;
                    count++;
                }
            } else {
                for (int j = 0; j < array[i].length; j++) {
                    if (count > n) break;
                    array[i][j] = count;
                    count++;
                }
            }
        }

        return array;
    }
}
