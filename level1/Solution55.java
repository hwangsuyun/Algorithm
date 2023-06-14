package programmers.level1;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

// 개인정보 수집 유효기간
public class Solution55 {
    public static void main(String[] args) {
        //String today = "2022.05.19";
        //String[] terms = {"A 6", "B 12", "C 3"};
        //String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
        // [1, 3]
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
        // [1, 4, 5]

        if (terms.length < 1 || terms.length > 20) return;
        if (privacies.length < 1 || privacies.length > 100) return;

        int[] result = solution(today, terms, privacies);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        int index = 1;

        for (String privacy : privacies) {
            String[] priArray = privacy.split(" ");

            for (String term : terms) {
                String[] termArray = term.split(" ");
                if (termArray[0].equals(priArray[1])) {
                    String expirationDate = getDate(cal1, df, priArray[0], termArray[1]);
                    if (destroyDate(cal1, cal2, df, expirationDate, today)) {
                        answer.add(index);
                    }
                }
            }
            index++;
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }

    private static String getDate(Calendar cal, DateFormat df, String date, String month) {
        int day = 0;
        String temp = "";

        try {
            cal.setTime(df.parse(date));
        } catch (ParseException e) {}

        cal.add(Calendar.MONTH, Integer.parseInt(month));
        cal.add(Calendar.DATE, -1);
        day = df.format(cal.getTime()).lastIndexOf(".") + 1;
        temp = df.format(cal.getTime()).substring(day);
        if (Integer.parseInt(temp) >= 28) {
            cal.set(Calendar.DATE, 28);
        }

        return df.format(cal.getTime());
    }

    private static boolean destroyDate(Calendar cal1, Calendar cal2, DateFormat df,
                                       String expirationDate, String today) {
        try {
            cal1.setTime(df.parse(expirationDate));
            cal2.setTime(df.parse(today));
        } catch (ParseException e) {}
        return cal1.before(cal2);
    }
}