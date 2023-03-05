package programmers.level0;

// 치킨 쿠폰
public class Solution33 {
    public static void main(String[] args) {
        //int chicken = 100; // 11
        //int chicken = 1081; // 120
        int chicken = 1999; // 222

        if (chicken < 0 || chicken > 1000000) return;

        System.out.println(solution(chicken));
    }

    public static int solution(int chicken) {
        int coupon = chicken;
        int result = 0;
        while (chicken >= 10) {
            result += chicken / 10;
            coupon = chicken / 10 + chicken % 10;
            chicken = coupon;
        }
        return result;
    }
}
