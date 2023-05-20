package programmers.level0;

// 분수의 덧셈
public class Solution92 {
    public static void main(String[] args) {
        //int numer1 = 1;
        //int denom1 = 2;
        //int numer2 = 3;
        //int denom2 = 4;
        //[5,4]
        //int numer1 = 9;
        //int denom1 = 2;
        //int numer2 = 1;
        //int denom2 = 3;
        //[29,6]
        //int numer1 = 512;
        //int denom1 = 512;
        //int numer2 = 512;
        //int denom2 = 512;
        //[2,1]
        int numer1 = 1;
        int denom1 = 2;
        int numer2 = 1;
        int denom2 = 2;
        //[1,1]

        if (numer1 <= 0 || numer1 > 1000) return;
        if (denom1 <= 0 || denom1 > 1000) return;
        if (numer2 <= 0 || numer2 > 1000) return;
        if (denom2 <= 0 || denom2 > 1000) return;

        int[] result = solution(numer1, denom1, numer2, denom2);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int numer1, int denom1, int numer2, int denom2) {
        numer1 *= denom2;
        numer2 *= denom1;
        denom1 *= denom2;
        denom2 = denom1;

        int answer1 = numer1 + numer2;
        int answer2 = denom2;
        int max = 0;

        for (int i = 2; i <= answer1; i++) {
            if (answer1 % i == 0 && answer2 % i == 0) {
                max = i;
            }
        }

        answer1 = max != 0 ? answer1 / max : answer1;
        answer2 = max != 0 ? answer2 / max : answer2;

        return new int[] {answer1, answer2};
    }
}