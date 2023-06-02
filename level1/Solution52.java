package programmers.level1;

import java.util.*;

// 대충 만든 자판
public class Solution52 {
    public static void main(String[] args) {
        //String[] keymap = {"ABACD", "BCEFD"};
        //String[] targets = {"ABCD","AABB"};
        // [9, 4]
        //String[] keymap = {"AA"};
        //String[] targets = {"B"};
        // [-1]
        //String[] keymap = {"AGZ", "BSSS"};
        //String[] targets = {"ASA", "BGZ"};
        // [4, 6]
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"XABCD", "AABB"};
        // [4, 6]

        if (keymap.length < 1 || keymap.length > 100) return;
        for (int i = 0; i < keymap.length; i++) {
            if (keymap[i].length() < 1 || keymap[i].length() > 100) return;
        }
        if (targets.length < 1 || targets.length > 100) return;
        for (int i = 0; i < targets.length; i++) {
            if (targets[i].length() < 1 || targets[i].length() > 100) return;
        }

        int[] result = solution(keymap, targets);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        int index = -1, count = 0;

        for (int i = 0; i < targets.length; i++) {
            for (int j = 0; j < targets[i].length(); j++) {

                List<Integer> list = new LinkedList<>();
                char ch = targets[i].charAt(j);

                for (int k = 0; k < keymap.length; k++) {
                    if (keymap[k].indexOf(ch) != -1) {
                        index = keymap[k].indexOf(ch) + 1;
                        list.add(index);
                    }
                }

                if (index == -1) {
                    answer[i] = index;
                    break;
                }

                Collections.sort(list);
                count += list.get(0);
                answer[i] = count;

                index = -1;
                list.clear();
            }
            count = 0;
        }

        return answer;
    }
}