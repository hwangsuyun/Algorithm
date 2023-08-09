package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 테이블 해시 함수
public class Solution65 {
    public static void main(String[] args) {
        int[][] data = {{2, 2, 6}, {1, 5, 10}, {4, 2, 9}, {3, 8, 3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        // 4;

        if (data.length < 1 || data.length > 2500) return;
        for (int i = 0; i < data.length; i++) {
            if (data[i].length < 1 || data[i].length > 500) return;
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] < 1 || data[i][j] > 1000000) return;
            }
        }
        if (col < 1 || col > data[0].length) return;
        if (row_begin < 1 || row_begin > row_end) return;
        if (row_end < row_begin || row_end > data.length) return;

        System.out.println(solution(data, col, row_begin, row_end));
    }

    public static int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        /*
         1.테이블의 튜플을 col번째 컬럼의 값을 기준으로 오름차순 정렬을 하되,
         만약 그 값이 동일하면 기본키인 첫 번째 컬럼의 값을 기준으로 내림차순 정렬합니다.
         2.정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의합니다.
         3.row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환합니다.
        */

        // 1. col 번째 컬럼의 값을 기준으로 오름차순 정렬, 동일 키의 경우 컷 번째 컬럼 기준 내림차순 정렬
        Arrays.sort(data, (o1, o2) -> {
            return o1[col - 1] == o2[col - 1] ? o2[0] - o1[0] : o1[col - 1] - o2[col - 1];
        });

        // 2.정렬된 데이터에서 S_i를 i 번째 행의 튜플에 대해 각 컬럼의 값을 i 로 나눈 나머지들의 합으로 정의
        int reminder = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = row_begin; i <= row_end; i++) {
            for (int j = 0; j < data[i - 1].length; j++) {
                reminder += data[i - 1][j] % i;
            }
            list.add(reminder);
            reminder = 0;
        }

        //3.row_begin ≤ i ≤ row_end 인 모든 S_i를 누적하여 bitwise XOR 한 값을 해시 값으로서 반환.
        for (int i : list) {
            answer ^= i;
        }

        return answer;
    }

}