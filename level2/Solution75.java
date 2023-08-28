package programmers.level2;

import java.util.*;

// 할인 행사
public class Solution75 {
    public static void main(String[] args) {
        //String[] want = {"banana", "apple", "rice", "pork", "pot"};
        //int[] number = {3, 2, 2, 2, 1};
        //String[] discount= {"chicken", "apple", "apple", "banana", "rice", "apple",
        //        "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana"};
        // 3
        String[] want = {"apple"};
        int[] number = {10};
        String[] discount = {"banana", "banana", "banana", "banana",
                "banana", "banana", "banana", "banana", "banana", "banana"};
        // 0

        if (want.length < 1 || want.length > number.length) return;
        if (number.length < want.length || number.length > 10) return;
        for (int i = 0; i < number.length; i++) {
            if (number[i] < 1 || number[i] > 10) return;
        }
        if (discount.length < 10 || discount.length > 100000) return;
        for (int i = 0; i < want.length; i++) {
            if (want[i].length() < 1 || want[i].length() > 12) return;
        }
        for (int i = 0; i < discount.length; i++) {
            if (discount[i].length() < 1 || discount[i].length() > 12) return;
        }

        System.out.println(solution(want, number, discount));
    }

    public static int solution(String[] want, int[] number, String[] discount) {
        // 1.want 를 key, number 를 value 로 하는 map 생성
        // 2.discount 배열만큼 반복문을 돌면서 원소값과 temp map 의 key 를 비교
        // 3.map 깊은 복사 -> temp map 생성
        // 4.value 가 0이면 넘어가고 아니면 -1 하여 temp map 에 put 한다.
        // 5.temp map 의 value 가 0일 때 answer 증가
        // 6.2번으로 돌아가서 다시 반복

        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> tempMap = new HashMap<>();

        // 1.want 를 key, number 를 value 로 하는 map 생성
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        // 2.discount 배열만큼 반복문을 돌면서 원소값과 temp map 의 key 를 비교
        for (int i = 0; i < discount.length; i++) {
            // 3.map 깊은 복사 -> temp map 생성
            tempMap.putAll(map);
            int count = 0;

            // 4.value 가 0이면 넘어가고 아니면 -1 하여 temp map 에 put 한다.
            for (int j = i; j < discount.length; j++) {
                if (count == 10) break;
                int temp = tempMap.getOrDefault(discount[j], 0);
                if (temp != 0) {
                    tempMap.put(discount[j], temp - 1);
                }
                count++;
            }

            // 5.temp map 의 value 가 0일 때 answer 증가
            if (Arrays.stream(tempMap.values().toArray()).mapToInt(s -> (int) s).sum() == 0) {
                answer++;
            }
            tempMap.clear();
        }

        return answer;
    }
}