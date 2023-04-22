package programmers.level0;

import java.math.BigInteger;

// 구슬을 나누는 경우의 수
public class Solution63 {
    public static void main(String[] args) {
        //int balls = 3;
        //int share = 2;
        // 3
        int balls = 5;
        int share = 3;
        // 10

        if (balls < 1 || balls > 30) return;
        if (share < 1 || share > 30) return;
        if (share > balls) return;

        System.out.println(solution(balls, share));
    }

    public static BigInteger solution(int balls, int share) {
        BigInteger n = BigInteger.valueOf(balls);
        BigInteger m = BigInteger.valueOf(share);
        BigInteger k = BigInteger.valueOf(balls - share);
        return getFactorial(n).divide(getFactorial(k).multiply(getFactorial(m)));
    }

    private static BigInteger getFactorial(BigInteger n) {
        BigInteger result = new BigInteger("1");
        for (int i = 1; i <= n.intValue(); i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }
}