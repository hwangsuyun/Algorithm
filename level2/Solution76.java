package programmers.level2;

import java.util.*;

// 두 큐 합 같게 만들기
public class Solution76 {
    public static void main(String[] args) {
        //int[] queue1 = {3, 2, 7, 2};
        //int[] queue2 = {4, 6, 5, 1};
        // 2
        //int[] queue1 = {1, 2, 1, 2};
        //int[] queue2 = {1, 10, 1, 2};
        // 7
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        // -1

        if (queue1.length < 1 || queue1.length > 300000) return;
        if (queue2.length < 1 || queue2.length > 300000) return;
        for (int i = 0; i < queue1.length; i++) {
            if (queue1[i] < 1 || queue1[i] > 1000000000) return;
            if (queue2[i] < 1 || queue2[i] > 1000000000) return;
        }

        System.out.println(solution(queue1, queue2));
    }

    public static int solution(int[] queue1, int[] queue2) {
        // 1.queue1, queue2 원소의 합계를 구함
        // 2.queue1 -> List<Long> l1, queue2 -> List<Long> l2
        // 3.l1, l2의 원소의 합이 같을 때 까지 반복문 수행, 원소가 없으면 -1 리턴
        // 4.투포인터를 이용하여 값이 작으면 0부터 인덱스 증가, 값이 크면 끝부터 인덱스 감소
        //   list 는 add 시 맨 끝에 넣기 때문에 right 변수는 사용 필요 X, left 만 사용

        // 1.queue1, queue2 원소의 합계를 구함
        long q1Sum = Arrays.stream(queue1).sum();
        long q2Sum = Arrays.stream(queue2).sum();
        // 2.queue1 -> List<Long> l1, queue2 -> List<Long> l2
        List<Long> l1 = new ArrayList<>(
                Arrays.asList(Arrays.stream(queue1).mapToLong(i -> i).boxed().toArray(Long[]::new)));
        List<Long> l2 = new ArrayList<>(
                Arrays.asList(Arrays.stream(queue2).mapToLong(i -> i).boxed().toArray(Long[]::new)));

        return getCount(l1, l2, q1Sum, q2Sum);
    }

    private static int getCount(List<Long> l1, List<Long> l2, long q1Sum, long q2Sum) {
        int count = 0;
        long l1Left = 0, l2Left = 0;

        // 3.l1, l2의 원소의 합이 같을 때 까지 반복문 수행, 원소가 없으면 -1 리턴
        while (q1Sum != q2Sum) {
            if (l1Left == l1.size()) return -1;
            if (l2Left == l2.size()) return -1;
            if (count > 1500000) return -1;

            // 4.투포인터를 이용하여 값이 작으면 0부터 인덱스 증가, 값이 크면 끝부터 인덱스 감소
            //   list 는 add 시 맨 끝에 넣기 때문에 right 변수는 사용 필요 X, left 만 사용
            long temp = 0;
            if (q1Sum < q2Sum) {
                temp = l2.get((int) l2Left);
                l1.add(temp);
                q1Sum += temp;
                q2Sum -= temp;
                l2Left++;
            } else {
                temp = l1.get((int) l1Left);
                l2.add(temp);
                q1Sum -= temp;
                q2Sum += temp;
                l1Left++;
            }
            count++;
        }

        return count;
    }
}