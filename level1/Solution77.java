package com.example.algorithm.level1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// [PCCP 기출문제] 1번 / 동영상 재생기
public class Solution77 {
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
        pos = match(pos, video_len, op_start, op_end);

        for (String str : commands) {
            int minute = Integer.parseInt(pos.substring(0, 2));
            int second = Integer.parseInt(pos.substring(3));

            switch (str) {
                case "prev":
                    if (minute == 0 && second < 10) {
                        pos = "00:00";
                    } else {
                        pos = calculateDate(pos, -10);
                    }
                    break;
                case "next":
                    pos = calculateDate(pos, 10);
                    if (minute >= Integer.parseInt(video_len.substring(0, 2))
                        && second >= Integer.parseInt(video_len.substring(3))) {
                        pos = video_len;
                    }
                    break;
            }
            pos = match(pos, video_len, op_start, op_end);
        }

        return pos;
    }

    private static String match(String pos, String video_len, String op_start, String op_end) {
        int position = Integer.parseInt(pos.replace(":", ""));
        int start = Integer.parseInt(op_start.replace(":", ""));
        int end = Integer.parseInt(op_end.replace(":", ""));
        if (position >= start && position <= end) {
            return op_end;
        }

        if (position > Integer.parseInt(video_len.replace(":", ""))) {
            return video_len;
        }

        return pos;
    }

    private static String calculateDate(String pos, int seconds) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        Date date;
        Calendar calendar = Calendar.getInstance();

        try {
            date = simpleDateFormat.parse(pos);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        calendar.setTime(date);
        calendar.add(Calendar.SECOND, seconds);
        return simpleDateFormat.format(new Date(calendar.getTimeInMillis()));
    }
}