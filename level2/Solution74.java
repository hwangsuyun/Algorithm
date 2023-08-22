package programmers.level2;

import java.util.*;

// 혼자 놀기의 달인
public class Solution74 {
    private static Set<Integer> box;
    private static boolean[] visited;

    public static void main(String[] args) {
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4}; // 12
        //int[] cards = {2, 3, 1}; // 0
        //int[] cards = {5, 3, 2, 1, 4}; // 6
        //int[] cards = {10, 5, 6, 7, 8, 9, 1, 2, 3, 4}; // 12
        //int[] cards = {1, 2}; // 1

        if (cards.length < 2 || cards.length > 100) return;
        for (int i = 0; i < cards.length; i++) {
            if (cards[i] > cards.length) return;
        }

        System.out.println(solution(cards));
    }

    public static int solution(int[] cards) {
        // 1. cards 길이만큼 반복문을 실행한다.
        // 2. cards 의 첫번째 원소를 시작 -> 그 원소의 숫자 -1 을 cards 의 index 로 하여 값을 담는다.
        //    makeBox 재귀 함수 호출을 이용 (ex 8->4->7->1->8 로 이동하다 8 중복 시 return)
        // 3. makeBox 결과(ex 8,4,7,1) 값이 list 에 있는지 체크하여 없으면 담고 있으면 빈 값을 담는다.
        // 4. list 의 int[] 배열의 count 수를 이용하여 내림차순 정렬한다.
        // 5. list 의 0(가장 요소가 많은) * 1(두번째 요소가 많은) 을 반환한다.

        List<int[]> list = new ArrayList<>();
        visited = new boolean[cards.length];

        // 1. cards 길이만큼 반복문을 실행한다.
        for (int i = 0; i < cards.length; i++) {
            if (visited[i]) continue;;

            box = new HashSet<>();

            // 2. cards 의 첫번째 원소를 시작 -> 그 원소의 숫자 -1 을 cards 의 index 로 하여 값을 담는다.
            //    makeBox 재귀 함수 호출을 이용 (ex 8->4->7->1->8 로 이동하다 8 중복 시 return)
            makeBox(cards[i], cards);

            // 3. makeBox 결과(ex 8,4,7,1) 값이 list 에 있는지 체크하여 없으면 담고 있으면 빈 값을 담는다.
            if (!checkDuplicated(list, box.stream().mapToInt(x -> x).toArray())) {
                list.add(box.stream().mapToInt(x -> x).toArray());
            } else {
                list.add(new int[]{});
            }
            box.clear();
        }
        if (list.size() == 1) return 0;

        // 4. list 의 int[] 배열의 count 수를 이용하여 내림차순 정렬한다.
        list.sort(Comparator.comparingInt(o -> (int) Arrays.stream((int[]) o).count()).reversed());
        // 5. list 의 0(가장 요소가 많은) * 1(두번째 요소가 많은) 을 반환한다.
        return (int) (Arrays.stream(list.get(0)).count() * Arrays.stream(list.get(1)).count());
    }

    private static void makeBox(int card, int[] cards) {
        if (visited[card - 1]) return;

        visited[card - 1] = true;
        box.add(card);
        makeBox(cards[card - 1], cards);
    }

    private static boolean checkDuplicated(List<int[]> list, int[] b) {
        for (int[] a : list) {
            if (b.length > 0 && Arrays.equals(a, b)) {
                return true;
            }
        }
        return false;
    }
}