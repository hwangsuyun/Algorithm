package programmers.level0;

// 옷가게 할인 받기
public class Solution82 {
    public static void main(String[] args) {
        //int price = 150000;	// 142,500
        int price = 580000; // 464,000

        if (price < 10 || price > 1000000) return;

        System.out.println(solution(price));
    }

    public static int solution(int price) {
        if (price >= 500000) {
            return price *= 0.8;
        } else if (price >= 300000) {
            return price *= 0.9;
        } else if (price >= 100000) {
            return price *= 0.95;
        } else {
            return price;
        }
    }
}