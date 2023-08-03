package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 시소 짝꿍
public class Solution61 {
    public static void main(String[] args) {
        //int[] weights = {100, 180, 360, 100, 270}; // 4
        int[] weights = {100, 100, 100, 200, 200, 200}; // 15

        if (weights.length < 2 || weights.length > 100000) return;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] < 100 | weights[i] > 1000) return;
        }

        System.out.println(solution(weights));
    }

    public static long solution(int[] weights) {
        // 1. weights 가 100000 되니까 이중 반복문 돌리면 시간 초과?
        // 2. 일단 weights 오름차순 정렬
        // 3. 이중 반복문 돌면서 map 에서 이미 체크한 적(= 같은 값)이 있는지 확인
        // 3.1 있으면 map 의 값만큼 증가, map 에 다시 값(자기 자신 -1) 넣고 continue
        // 4. 값 비교
        // 4.1 비교 당할 대상이 비교할 대상보다 4배 크면 내부 반복문 종료
        // 4.2. weight[i] == weight[j], *3 == *2, *4 == *2, *4 == *3 값이 같은 것 찾기
        // 5 map 에 key 는 몸무게, value 는 짝꿍 수 넣기 (자기 자신 -1)
        // 6. 3부터 반복

        long answer = 0;
        Map<Integer, Long> map = new HashMap<>();

        // 2. 일단 weights 오름차순 정렬
        Arrays.sort(weights);

        // 3. 이중 반복문 돌면서 map 에서 이미 체크한 적(= 같은 값)이 있는지 확인
        for (int i = 0; i < weights.length - 1; i++) {
            // 3.1 있으면 map 의 값만큼 증가, map 에 다시 값(자기 자신 -1) 넣고 continue
            long count = map.getOrDefault(weights[i], -1L);
            if (count > -1) {
                answer += count;
                map.put(weights[i], count - 1);
                continue;
            }
            count = 0;

            // 4. 값 비교
            for (int j = i + 1; j <= weights.length - 1; j++) {
                // 4.1 비교 당할 대상이 비교할 대상보다 4배 크면 내부 반복문 종료
                if (weights[i] * 4 < weights[j]) break;
                // 4.2. weight[i] == weight[j], *3 == *2, *4 == *2, *4 == *3 값이 같은 것 찾기
                if (weights[i] == weights[j]
                        || weights[i] * 3 == weights[j] * 2
                        || weights[i] * 4 == weights[j] * 2
                        || weights[i] * 4 == weights[j] * 3) {
                    count++;
                }
            }

            // 5 map 에 key 는 몸무게, value 는 짝꿍 수 넣기 (자기 자신 -1)
            map.put(weights[i], count - 1);
            answer += count;
        }

        return answer;
    }
}