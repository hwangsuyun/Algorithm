package programmers.level2;

import java.util.HashSet;
import java.util.Set;

// 연속 부분 수열 합의 개수
public class Solution73 {
    public static void main(String[] args) {
        int[] elements = {7, 9, 1, 1, 4}; // 18

        if (elements.length < 3 || elements.length > 1000) return;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] < 1 || elements[i] > 1000) return;
        }

        System.out.println(solution(elements));
    }

    public static int solution(int[] elements) {
        // 1. elements 길이만큼 반복
        // 2. 첫 번째 반복문에서는 elements 의 1개 원소값을 담는다.
        // 3. 내부 반복문에서는 count 를 체크하여 elements 의 원소값을 가져온다.
        // 4. 더해야 하는 길이가 1개 이상이고 elements 의 길이를 넘게 되면
        //    element 의 index 를 0으로 해서 원소값을 추가로 가져온다. (원형 수열)
        // 5. set 에 담고 size 반환

        Set<Integer> set = new HashSet<>();
        int length = 1;

        // 1. elements 길이만큼 반복
        while (length <= elements.length) {
            // 2. 첫 번째 반복문에서는 elements 의 1개 원소값을 담는다.
            for (int i = 0; i < elements.length; i++) {
                int count = 1;
                int sum = elements[i];

                // 3. 내부 반복문에서는 count 를 체크하여 elements 의 원소값을 가져온다.
                for (int j = i + 1; j <= elements.length - 1; j++) {
                    if (count == length) break;
                    sum += elements[j];
                    count++;
                }

                // 4. 더해야 하는 길이가 1개 이상이고 elements 의 길이를 넘게 되면
                // element 의 index 를 0으로 해서 원소값을 추가로 가져온다. (원형 수열)
                if (length > 1 && length + i > elements.length) {
                    for (int j = 0; j < length + i - elements.length; j++) {
                        sum += elements[j];
                    }
                    if (length == elements.length) break;
                }

                set.add(sum);
            }
            length++;
        }

        return set.size();
    }
}