public class Solution85 {
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

    public static int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;

        for (int i = 0; i < schedules.length; i++) {
            boolean flag = false;
            int day = startday;
            int schedule = calculateTime(schedules[i]);

            for (int j = 0; j < timelogs[i].length; j++) {
                if (day > 7) day = 1;
                if (timelogs[i][j] > schedule && day < 6) {
                    flag = true;
                    break;
                }
                day++;
            }

            if (!flag) answer++;
        }

        return answer;
    }

    private static int calculateTime(int schedule) {
        schedule += 10;
        if (schedule % 100 >= 60) {
            int hour = schedule / 100 + 1;
            int minute = schedule % 100 - 60;
            schedule = hour * 100 + minute;
        }
        return schedule;
    }
}
