package programmers.level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// 카드 뭉치
public class Solution53 {
    public static void main(String[] args) {
        //String[] cards1 = {"i", "drink", "water"};
        //String[] cards2 = {"want", "to"};
        //String[] goal = {"i", "want", "to", "drink", "water"};
        // "Yes"
        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        // "Yes"

        if (cards1.length < 1 || cards1.length > 10) return;
        for (int i = 0; i < cards1.length; i++) {
            if (cards1[i].length() < 1 || cards1[i].length() > 10) return;
        }
        if (cards2.length < 1 || cards2.length > 10) return;
        for (int i = 0; i < cards2.length; i++) {
            if (cards2[i].length() < 1 || cards2[i].length() > 10) return;
        }
        if (goal.length < 2 || goal.length > cards1.length + cards2.length) return;
        for (int i = 0; i < goal[i].length(); i++) {
            if (goal[i].length() < 1 || goal[i].length() > 10) return;
        }

        System.out.println(solution(cards1, cards2, goal));
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        Queue<String> cardQueue1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> cardQueue2 = new LinkedList<>(Arrays.asList(cards2));
        String card1 = cardQueue1.poll();
        String card2 = cardQueue2.poll();

        for (String str : goal) {
            if (str.equals(card1)) {
                if (!cardQueue1.isEmpty()) {
                    card1 = cardQueue1.poll();
                }
            } else if (str.equals(card2)) {
                if (!cardQueue2.isEmpty()) {
                    card2 = cardQueue2.poll();
                }
            } else if (!str.equals(card1) && !str.equals(card2)) {
                return "No";
            }
        }

        return "Yes";
    }
}