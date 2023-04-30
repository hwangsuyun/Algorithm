package programmers.level0;

// 각도기
public class Solution73 {
    public static void main(String[] args) {
        //int angle = 70; // 1
        //int angle = 91; // 3
        int angle = 180; // 4

        if (angle <= 0 || angle > 180) return;

        System.out.println(solution(angle));
    }

    public static int solution(int angle) {
        return angle = angle < 90 ? 1 : angle == 90 ? 2 : angle < 180 ? 3 : 4;
    }
}