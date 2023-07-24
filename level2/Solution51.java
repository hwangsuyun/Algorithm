package programmers.level2;

import java.util.*;

// 과제 진행하기
public class Solution51 {
    public static void main(String[] args) {
        //String[][] plans = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        // ["korean", "english", "math"]
        //String[][] plans = {{"science", "12:40", "50"}, {"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
	    //["science", "history", "computer", "music"]
        //String[][] plans = {{"aaa", "12:00", "20"}, {"bbb", "12:10", "30"}, {"ccc", "12:40", "10"}};
        // ["bbb", "ccc", "aaa"]
        String[][] plans = {{"1", "00:00", "30"}, {"2", "00:10", "10"}, {"3", "00:30", "10"}, {"4", "00:50", "10"}};
        //["2", "3", "1", "4"]

        if (plans.length < 3 || plans.length > 1000) return;

        String[] result = solution(plans);
        for (String str : result) System.out.println(str);
    }

    public static String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int currentTime = 0;

        // 1. 시간 순서대로 정렬(오름차순)
        Stack<String[]> stack = new Stack<>();
        Map<Integer, String[]> map = new HashMap<>();
        Stack<String[]> newPlans = new Stack<>();
        int rank = 0;
        for (int i = 0; i < plans.length; i++) {
            String[] times = plans[i][1].split(":");
            int time = Integer.parseInt(times[0] + times[1]);
            for (int j = 0; j < plans.length; j++) {
                if (i == j) continue;
                times = plans[j][1].split(":");
                if (time > Integer.parseInt(times[0] + times[1])) {
                    rank++;
                }
            }
            map.put(rank, plans[i]);
            rank = 0;
        }
        for (int i = map.size() - 1; i >= 0; i--) {
            stack.push(map.get(i));
        }
        //while (!stack.isEmpty()) System.out.println(stack.pop()[0]);

        while (!stack.isEmpty()) {
            // 2. 과제 진행
            String[] plan = stack.pop();
            int time = getTime(plan[1]);
            int period = Integer.parseInt(plan[2]);
            currentTime = time + period;
            //System.out.println("currentTime : " + currentTime);

            if (stack.isEmpty()) {
                answer[rank] = plan[0];
                rank++;

                // 6. 모든 과제를 탐색, 멈춘 과제를 순서대로 진행
                while (!newPlans.isEmpty()) {
                    answer[rank] = newPlans.pop()[0];
                    rank++;
                }

                break;
            }

            String[] nextPlan = stack.peek();
            int nextTime = getTime(nextPlan[1]);

            // 3. 과제를 진행하는데 다음 과제할 시간이 되있는지 체크
            if (currentTime == nextTime) {
                // 4. 과제 완료
                answer[rank] = plan[0];
                rank++;
            } else if (currentTime < nextTime) {
                answer[rank] = plan[0];
                rank++;

                // 5. 과제는 완료, 다음 과제 시간까지 시간이 남으면 이 남은 시간동안 멈춘 과제 진행
                while (!newPlans.isEmpty()) {
                    int remain = nextTime - currentTime;
                    String[] newPlan = newPlans.pop();
                    int newPeriod = Integer.parseInt(newPlan[1]);
                    if (remain >= newPeriod) {
                        answer[rank] = newPlan[0];
                        rank++;
                        currentTime += newPeriod;
                    } else {
                        newPlans.push(new String[] {newPlan[0], newPeriod - remain + ""});
                        break;
                    }
                }
            } else {
                newPlans.push(new String[] {plan[0], currentTime - nextTime + ""});
            }
        }

        return answer;
    }

    private static int getTime(String time) {
        String[] temp = time.split(":");
        int hour = Integer.parseInt(temp[0]) * 60;
        int minute = Integer.parseInt(temp[1]);
        return hour + minute;
    }
}