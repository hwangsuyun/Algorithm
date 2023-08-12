package programmers.level2;

import java.util.*;
import java.util.stream.Collectors;

// 귤 고르기
public class Solution68 {
    public static void main(String[] args) {
        //int k = 6;
        //int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        // 3
        //int k = 4;
        //int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};
        // 2
        int k = 2;
        int[] tangerine = {1, 1, 1, 1, 2, 2, 2, 3};
        // 1

        if (k < 1 || k > tangerine.length) return;
        if (tangerine.length < k || tangerine.length > 100000) return;
        for (int i = 0; i < tangerine.length; i++) {
            if (tangerine[i] < 1 || tangerine[i] > 10000000) return;
        }

        System.out.println(solution(k, tangerine));
    }

    public static int solution(int k, int[] tangerine) {
        // 1. tangerine 오름차순 정렬
        // 2. 반복문 돌면서 key : tangerine 값, value : 중복 값
        // 3. map value 내림차순 정렬
        // 4. map 에서 값을 1개 씩 꺼내면서 k 에서 마이너스 하면서 answer 증가
        // 5. k < 0 일때 answer 리턴

        int answer = 0;
        String str = Arrays.stream(tangerine).mapToObj(s -> s + "").collect(Collectors.joining());
        Map<Integer, Integer> map = new HashMap<>();

        // 1. tangerine 오름차순 정렬
        Arrays.sort(tangerine);

        // 2. 반복문 돌면서 key : tangerine 값, value : 중복 값
        for (int i = 0; i < tangerine.length; i++) {
            int temp = map.getOrDefault(tangerine[i], 0);
            map.put(tangerine[i], temp + 1);
        }

        // 3. map value 내림차순 정렬
        List<Integer> entryList = new LinkedList<>(map.keySet());
        entryList.sort((o1, o2) -> map.get(o2).compareTo(map.get(o1)));

        // 4. map 에서 값을 1개 씩 꺼내면서 k 에서 마이너스 하면서 answer 증가
        for (Integer key : entryList) {
            // 5. k < 0 일때 answer 리턴
            if (k <= 0) break;

            k -= map.get(key);
            answer++;
        }

        return answer;
    }
}