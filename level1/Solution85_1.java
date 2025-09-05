import java.util.*;
import java.util.stream.IntStream;

public class Solution85_1 {
    public static void main(String[] args) {
        //int[] schedules = {700, 800, 1100};
        //int[][] timelogs = {{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        //int startday = 5;
        // 3
        int[] schedules = {730, 855, 700, 720};
        int[][] timelogs = {{710, 700, 650, 735, 700, 931, 912},
                            {908, 901, 805, 815, 800, 831, 835},
                            {705, 701, 702, 705, 710, 710, 711},
                            {707, 731, 859, 913, 934, 931, 905}};
        int startday = 1;
        // 2

        System.out.println(solution(schedules, timelogs, startday));
    }

    public static int solution(int[] schedules, int[][] timeLogs, int startDay) {
        return (int) IntStream.range(0, timeLogs.length)
                .filter(i -> IntStream.range(0, timeLogs[i].length)
                        .filter(idx -> timeLogs[i][idx] > (schedules[i] + ((schedules[i] % 100 > 49) ? 50 : 10))
                                && !(idx == 6 - startDay % 7 || idx == 7 - startDay))
                        .count() == 0)
                .count();
    }
}
