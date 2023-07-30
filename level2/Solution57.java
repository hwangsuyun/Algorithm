package programmers.level2;

import java.util.*;

// 호텔 대실
public class Solution57 {
    public static void main(String[] args) {
        //String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"},
        //        {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        // 3
        //String[][] book_time = {{"09:10", "10:10"}, {"10:20", "12:20"}};
        // 1
        //String[][] book_time = {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};
        // 3
        String[][] book_time = {{"15:00", "17:00"}, {"14:00", "14:40"}, {"14:50", "17:20"}}; // 2

        if (book_time.length < 1 || book_time.length > 1000) return;

        System.out.println(solution(book_time));
    }

    public static int solution(String[][] book_time) {
        /*
        1.HH:MM -> HH * 60 + MM 으로 변경 (분으로 변경)
        2.대실 시작 시간을 기준으로 오름차순 정렬
        3.queue 에 담고 첫 번째 대실 시간부터 꺼낸다.
        4.첫 번째 대실 시간의 종료 시간과 다른 대실 시간 시작 시간을 비교한다.
        4.1 종료시간 + 10분이 다른 대실 시작 시작 시간보다 크면 다른 대실은 시작 불가 (continue)
        4.2 종료시간 + 10분이 다른 대실 시작 시작 시간보다 작으면 다른 대실 시작
        5.4부터 다시 반복한다.
        6.대실 시작 불가 카운팅 한다.
         */

        // 1.HH:MM -> HH * 60 + MM 으로 변경 (분으로 변경)
        int answer = 1;
        int[][] books = new int[book_time.length][book_time[0].length];
        int index = 0;
        for (String[] book : book_time) {
            books[index][0] = Integer.parseInt(book[0].substring(0, 2)) * 60 +
                              Integer.parseInt(book[0].substring(3));
            books[index][1] = Integer.parseInt(book[1].substring(0, 2)) * 60 +
                              Integer.parseInt(book[1].substring(3));
            index++;
        }

        // 2.대실 시작 시간을 기준으로 오름차순 정렬
        Queue<int[]> room = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        Queue<int[]> others = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        // 3.queue 에 담고 첫 번째 대실 시간부터 꺼낸다.
        for (int[] book : books) room.add(book);
        while (!room.isEmpty()) {
            int[] currentBooking = room.poll();
            int currentEnd = currentBooking[1];

            while (!room.isEmpty()) {
                int[] nextBooking = room.peek();
                int nextStart = nextBooking[0];

                // 4.첫 번째 대실 시간의 종료 시간과 다른 대실 시간 시작 시간을 비교한다.
                if (currentEnd + 10 > nextStart) {
                    // 4.1 종료시간 + 10분이 다른 대실 시작 시작 시간보다 크면 다른 대실은 시작 불가
                    // (다른 queue 에 넣기)
                    others.add(room.poll());
                } else {
                    // 4.2 종료시간 + 10분이 다른 대실 시작 시작 시간보다 작으면 같은 방에서 다른 대실 시작
                    // (currentBooking 을 다른 대실 시간으로 변경한다.)
                    currentBooking = room.poll();
                    currentEnd = currentBooking[1];
                }
            }

            // 5.4부터 다시 반복한다. (room 이 비었고 others 가 남아 있으면 others 값을 room 에 담는다.)
            if (room.isEmpty() && !others.isEmpty()) {
                while (!others.isEmpty()) {
                    room.add(others.poll());
                }
                // 6.대실 시작 불가 카운팅 한다. (다른 queue 에서 불러온 값을 카운팅 한다.)
                answer++;
            }
        }

        return answer;
    }
}