package programmers.level0;

// 배열 뒤집기
public class Solution79 {
    public static void main(String[] args) {
        int[] num_list = {1, 2, 3, 4, 5}; // [5, 4, 3, 2, 1]
        //int[] num_list = {1, 1, 1, 1, 1, 2}; // [2, 1, 1, 1, 1, 1]
        //int[] num_list = {1, 0, 1, 1, 1, 3, 5}; // [5, 3, 1, 1, 1, 0, 1]

        if (num_list.length < 1 || num_list.length > 1000) return;
        for (int i = 0; i < num_list.length; i++) {
            if (num_list[i] < 0 || num_list[i] > 1000) return;
        }

        int[] result = solution(num_list);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        for (int i = num_list.length - 1; i >= 0; i--) {
            answer[num_list.length - 1 - i] = num_list[i];
        }
        return answer;
    }
}