package programmers.level1;

import java.util.ArrayList;
import java.util.List;

// 햄버거 만들기
public class Solution64 {
    public static void main(String[] args) {
        //int[] ingredient = {2, 1, 1, 2, 3, 1, 2, 3, 1}; // 2
        //int[] ingredient = {1, 3, 2, 1, 2, 1, 3, 1, 2}; // 0
        int[] ingredient = {1, 2, 1, 2, 3, 1, 3, 1, 2, 3, 1, 2, 3, 1}; // 3

        if (ingredient.length < 1 || ingredient.length > 1000000) return;

        System.out.println(solution(ingredient));
    }

    public static int solution(int[] ingredient) {
        List<Integer> list = new ArrayList<>();
        String buger = "";
        int answer = 0;

        for (int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
            if (list.size() >= 4) {
                buger = ""
                        + list.get(list.size() - 1)
                        + list.get(list.size() - 2)
                        + list.get(list.size() - 3)
                        + list.get(list.size() - 4);
                if (buger.equals("1321")) {
                    for (int j = 0; j < 4; j++) {
                        list.remove(list.size() - 1);
                    }
                    answer++;
                }
            }
        }

        return answer;
    }
}