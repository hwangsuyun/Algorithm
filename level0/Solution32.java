package programmers.level0;

// 이진수 더하기
public class Solution32 {
    public static void main(String[] args) {
        //String bin1 = "10";
        //String bin2 = "11";
        // 101
        String bin1 = "1001";
        String bin2 = "1111";
        // 11000

        if (bin1.length() < 1 || bin1.length() > 10) return;
        if (bin2.length() < 1 || bin2.length() > 10) return;

        System.out.println(solution(bin1, bin2));
    }

    public static String solution(String bin1, String bin2) {
        return Integer.toBinaryString(Integer.parseInt(bin1, 2) + Integer.parseInt(bin2,2));
    }
}
