package programmers.level0;

// 저주의 숫자 3
public class Solution40 {
    public static void main(String[] args) {
        //int n = 15; // 25
        //int n = 40; // 76
        int n = 73; // 140

        if (n < 1 || n > 100) return;

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int[] array = new int[n * 3];
        int index = 0;
        for (int i = 1; i < array.length - 1; i++) {
            if (i % 3 == 0 || String.valueOf(i).contains("3")) continue;
            array[index] = i;
            index++;
        }
        return array[n - 1];
    }
}
