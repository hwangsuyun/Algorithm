package programmers.level0;

import java.util.*;
import java.util.stream.Collectors;

// 배열 회전시키기
public class Solution59 {
    public static void main(String[] args) {
        //int[] numbers = {1, 2, 3};
        //String direction = "right";
        // [3, 1, 2]
        int[] numbers = {4, 455, 6, 4, -1, 45, 6};
        String direction = "left";
        // [455, 6, 4, -1, 45, 6, 4]

        if (numbers.length < 3 || numbers.length > 20) return;
        if (!direction.equals("left") && !direction.equals("right")) return;

        int[] result = solution(numbers, direction);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(int[] numbers, String direction) {
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        if (direction.equals("left")) {
              list.add(list.size(), list.get(0));
              list.remove(0);
        } else {
            list.add(0, list.get(list.size() - 1));
            list.remove(list.size() - 1);
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}