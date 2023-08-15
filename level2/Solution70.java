package programmers.level2;

import java.util.*;

// 우박 수열 정적분
public class Solution70 {
    public static void main(String[] args) {
        int k = 5;
        int[][] ranges = {{0, 0}, {0, -1}, {2, -3}, {3, -3}};
        // [33.0,31.5,0.0,-1.0]

        if (k < 2 || k > 10000) return;
        if (ranges.length < 1 || ranges.length > 10000) return;
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i][0] < 0 || ranges[i][0] > 200) return;
            if (ranges[i][1] < -200 || ranges[i][1] > 0) return;
        }

        double[] result = solution(k, ranges);
        for (double d : result) System.out.println(d);
    }

    public static double[] solution(int k, int[][] ranges) {
        // 1. 콜라츠 추측 실행
        // 1-1. 입력된 수가 짝수라면 2로 나눕니다.
        // 1-2. 입력된 수가 홀수라면 3을 곱하고 1을 더합니다.
        // 1.3. 결과로 나온 수가 1보다 크다면 1-1번 작업을 반복합니다.
        // 2. 결과를 좌표 평면으로 옮기기
        // 3. 각 범위의 넓이 구하기 (사각형 + 삼각형)
        // 4. 누적합 구하기
        // 5. 범위에서 좌측 값보다 우측 값이 크면 -1 반환 하기

        double[] answer = new double[ranges.length];

        // 1. 콜라츠 추측 실행
        // 2. 결과를 좌표 평면으로 옮기기
        List<int[]> collatz = getCollatz(k);

        // 3. 각 범위의 넓이 구하기 (사각형 + 삼각형)
        List<Double> size = getSize(collatz);

        // 4. 누적합 구하기
        return getAccumulatedSum(size, k, ranges);
    }

    private static List<int[]> getCollatz(int k) {
        List<int[]> list = new ArrayList<>();
        int index = 0;

        while (k > 1) {
            list.add(new int[] {index, k});
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k *= 3;
                k += 1;
            }
            index++;
        }
        list.add(new int[] {index, k});
        return list;
    }

    private static List<Double> getSize(List<int[]> collatz) {
        List<Double> list = new ArrayList<>();

        for (int i = 0; i <= collatz.size() - 2; i++) {
            double x = collatz.get(i + 1)[0] - collatz.get(i)[0];
            double y = collatz.get(i + 1)[1] - collatz.get(i)[1];
            double square = x * collatz.get(i)[1];
            double triangle = x * y / 2;

            //if (i == 0) list.add(square + triangle);
            //else list.add(list.get(i - 1) + square + triangle);
            list.add(square + triangle);
        }
        return list;
    }

    private static double[] getAccumulatedSum(List<Double> size, int k, int[][] ranges) {
        double[] result = new double[ranges.length];
        int index = 0;

        for (int[] range : ranges) {
            double sum = 0;
            int x = range[0];
            int y = range[1] + size.size();

            if (x > y) {
                sum = -1;
            } else if (x == y) {
                sum = 0;
            } else {
                y--;
                for (int i = x; i <= y; i++) {
                    sum += size.get(i);
                }
            }
            result[index] = sum;
            index++;
        }
        return result;
    }
}