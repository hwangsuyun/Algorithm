package com.example.algorithm.level1;

// [PCCP 기출문제] 1번 / 동영상 재생기
public class Solution77_1 {
    private static final String PREV = "prev";
    private static final String NEXT = "next";
    private static final int SKIP_SS = 10;
    static int video_len_ss;
    static int pos_ss;
    static int op_start_ss;
    static int op_end_ss;

    public static void main(String[] args) {
        //String video_len = "34:33";
        //String pos = "13:00";
        //String op_start = "00:55";
        //String op_end = "02:55";
        //String[] commands = {"next", "prev"};
        // "13:00"
        //String video_len = "10:55";
        //String pos = "00:05";
        //String op_start = "00:15";
        //String op_end = "06:55";
        //String[] commands = {"prev", "next", "next"};
        // "06:55"
        //String video_len = "07:22";
        //String pos = "04:05";
        //String op_start = "00:15";
        //String op_end = "04:07";
        //String[] commands = {"next"};
        // "04:17"
        String video_len = "30:00";
        String pos = "29:55";
        String op_start = "01:00";
        String op_end = "01:30";
        String[] commands = {"next"};
        // "30:00"

        if (video_len.length() != 5) return;
        if (pos.length() != 5) return;
        if (op_start.length() != 5) return;
        if (op_end.length() != 5) return;
        if (commands.length < 1 || commands.length > 100) return;

        System.out.println(solution(video_len, pos, op_start, op_end, commands));
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        video_len_ss = convertRealTime(video_len);
        pos_ss = convertRealTime(pos);
        op_start_ss = convertRealTime(op_start);
        op_end_ss = convertRealTime(op_end);

        int[] timeArr = calCurPos(commands);

        String answer = String.format("%02d:%02d", timeArr[0], timeArr[1]);
        return answer;
    }

    private static int[] calCurPos(String[] commands) {
        int cur_pos_ss = pos_ss;

        for (String command : commands) {
            if (cur_pos_ss >= op_start_ss
                    && cur_pos_ss <= op_end_ss) {
                cur_pos_ss  = op_end_ss;
            }

            if (command.equals(PREV)) {
                cur_pos_ss = cur_pos_ss - SKIP_SS > 0 ? cur_pos_ss - SKIP_SS : 0;
            } else if (command.equals(NEXT)) {
                cur_pos_ss = cur_pos_ss + SKIP_SS < video_len_ss ? cur_pos_ss + SKIP_SS : video_len_ss;
            }
        }

        if (cur_pos_ss >= op_start_ss
                && cur_pos_ss <= op_end_ss) {
            cur_pos_ss  = op_end_ss;
        }

        int mm = cur_pos_ss / 60;
        int ss = cur_pos_ss % 60;
        return new int[]{mm, ss};
    }

    private static int convertRealTime(String s) {
        String[] sArr = s.split(":");
        int mm = Integer.parseInt(sArr[0]);
        int ss = Integer.parseInt(sArr[1]);

        return mm * 60 + ss;
    }
}