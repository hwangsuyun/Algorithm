package programmers.level0;

// 특이한 정렬
public class Solution36 {
    public static void main(String[] args) {
        //int[] numlist = {1, 2, 3, 4, 5, 6};
        //int n = 4;
        // [4, 5, 3, 6, 2, 1]
        //int[] numlist = {10000, 20, 36, 47, 40, 6, 10, 7000};
        //int n = 30;
        // [36, 40, 20, 47, 10, 6, 7000, 10000]
        int[] numlist = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 11};
        int n = 6;
        // [6, 7, 5, 8, 4, 9, 3, 10, 2, 11, 1]

        int[] rank = new int[numlist.length];

        if (n < 1 || n > 10000) return;
        if (numlist.length < 1 || numlist.length > 100) return;
        for (int i = 0; i < numlist.length; i++) {
            if (numlist[i] < 1 || numlist[i] > 10000) return;
        }

        rank = solution(numlist, n);
        for (int i : rank) System.out.println(i);
    }

    public static int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        int[] rank = new int[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            for (int j = 0; j < numlist.length; j++) {
                if (Math.abs(n - numlist[i]) > Math.abs(n - numlist[j])) {
                    rank[i] = rank[i] + 1;
                } else if (Math.abs(n - numlist[i]) == Math.abs(n - numlist[j])) {
                    if (numlist[i] < numlist[j]) {
                        rank[i] = rank[i] + 1;
                    }
                }
            }
        }

        for (int i = 0; i < rank.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                if (i == rank[j]) {
                    answer[i] = numlist[j];
                }
            }
        }

        return answer;
    }
}
