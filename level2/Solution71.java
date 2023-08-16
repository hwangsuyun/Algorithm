package programmers.level2;

import java.util.*;

// 롤케이크 자르기
public class Solution71 {
    public static void main(String[] args) {
        int[] topping = {1, 2, 1, 3, 1, 4, 1, 2}; // 2
        //int[] topping = {1, 2, 3, 1, 4}; // 0;

        if (topping.length < 1 || topping.length > 1000000) return;
        for (int i = 0; i < topping.length; i++) {
            if (topping[i] < 1 || topping[i] > 10000) return;
        }

        System.out.println(solution(topping));
    }

    public static int solution(int[] topping) {
        // 1. Map 의 key 에 topping 원소값, value 에 원소 값의 중복 개수 담기
        // 1.1 map 에 key -1, value 는 map 에서 value 가 0이 아닌 key 개 수 담기
        // 2. topping 길이만큼 반복문을 돌면서 set 에 1개씩 담기
        // 3. map 에서 topping 원소값을 찾아서 -1 (중복값 제거) 하고 다시 map 에 담기
        // 4. map 에 topping 원소 값이 0이면 map 의 키 개수를 가져와서 -1 을 하고 다시 담기
        // 5. set 의 사이즈와 map 의 key 개 수 비교

        int answer = 0, count = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();

        // 1. Map 의 key 에 topping 원소값, value 에 원소 값의 중복 개수 담기
        for (int i = 0; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], count) + 1);
        }
        // 1.1 map 에 key -1, value 는 map 에서 value 가 0이 아닌 key 개 수 담기
        map.put(-1, getCount(map));

        for (int i = 0; i < topping.length; i++) {
            // 2. topping 길이만큼 반복문을 돌면서 set 에 1개씩 담기
            set.add(topping[i]);
            // 3. map 에서 topping 원소값을 찾아서 -1 (중복값 제거) 하고 다시 map 에 담기
            map.put(topping[i], map.get(topping[i]) - 1);
            // 4. map 에 topping 원소 값이 0이면 map 의 키 개수를 가져와서 -1 을 하고 다시 담기
            if (map.get(topping[i]) == 0) map.put(-1, map.get(-1) - 1);
            // 5. set 의 사이즈와 map 의 key 개 수 비교
            if (set.size() == map.get(-1)) answer++;
        }

        return answer;
    }

    // map 에서 value 가 0이 아닌 key 개 수 찾기
    private static int getCount(Map<Integer, Integer> map) {
        int total = 0;
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            int key = iterator.next();
            if (map.get(key) > 0) {
                total++;
            } else {
                iterator.remove();
            }
        }
        return total;
    }
}