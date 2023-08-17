package programmers.level2;

import java.util.*;

// 택배상자
public class Solution72 {
    public static void main(String[] args) {
        int[] order = {4, 3, 1, 2, 5}; // 2
        //int[] order = {5, 4, 3, 2, 1}; // 5

        if (order.length < 1 || order.length > 1000000) return;

        System.out.println(solution(order));
    }

    public static int solution(int[] order) {
        // 1. order 를 오름차순으로 정렬한 Queue 를 만든다. (컨테이너 역할)
        // 2. Queue 를 순회하면서 order 의 값과 비교한다.
        // 2.1 작으면 Stack 에 담는다. (보조 컨테이너 역할)
        // 2.2 같으면 answer 증가 시킨다.
        // 2.3 크면 Stack 에서 값을 빼서 비교한다.
        // 2.3.1 같으면 answer 증가, 다르면 answer 반환 후 종료

        int answer = 0, index = 0;
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> queue
                = new LinkedList<>(Arrays.asList(Arrays.stream(order).boxed().sorted().toArray(Integer[]::new)));
        queue.add(order.length + 1);

        while (!queue.isEmpty() && index < order.length) {
            int box = queue.peek();
            if (box < order[index]) {
                stack.add(box);
                queue.poll();
            } else if (box > order[index]) {
                int stackBox = stack.pop();
                if (stackBox == order[index]) {
                    answer++;
                    index++;
                } else {
                    break;
                }
            } else {
                queue.poll();
                answer++;
                index++;
            }
        }

        return answer;
    }
}