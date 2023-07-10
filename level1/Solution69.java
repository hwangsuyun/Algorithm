package programmers.level1;

import java.util.HashMap;
import java.util.Map;

// 성격 유형 검사하기
public class Solution69 {
    public static void main(String[] args) {
        /*
        1번 지표	라이언형(R), 튜브형(T)
        2번 지표	콘형(C), 프로도형(F)
        3번 지표	제이지형(J), 무지형(M)
        4번 지표	어피치형(A), 네오형(N)

        1	매우 비동의 : 3점
        2	비동의      : 2점
        3	약간 비동의  : 1점
        4	모르겠음     : 0점
        5	약간 동의    : 1점
        6	동의        : 2점
        7	매우 동의    : 3점
        */
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        // TCMA
        //String[] survey = {"TR", "RT", "TR"};
        //int[] choices = {7, 1, 3};
        // RCJA

        if (survey.length < 1 || survey.length > 1000) return;
        if (choices.length != survey.length) return;
        for (int i = 0; i < choices.length; i++) {
            if (choices[i] < 1 || choices[i] > 7) return;
        }

        System.out.println(solution(survey, choices));
    }

    public static String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> score = initialize();

        for (int i = 0; i < choices.length; i++) {
            String[] surArr = survey[i].split("");
            switch (choices[i]) {
                case 1:
                    score.put(surArr[0], score.get(surArr[0]) + 3);
                    break;
                case 2:
                    score.put(surArr[0], score.get(surArr[0]) + 2);
                    break;
                case 3:
                    score.put(surArr[0], score.get(surArr[0]) + 1);
                    break;
                case 4:
                    score.put(surArr[0], score.get(surArr[0]) + 0);
                    score.put(surArr[1], score.get(surArr[1]) + 0);
                    break;
                case 5:
                    score.put(surArr[1], score.get(surArr[1]) + 1);
                    break;
                case 6:
                    score.put(surArr[1], score.get(surArr[1]) + 2);
                    break;
                case 7:
                    score.put(surArr[1], score.get(surArr[1]) + 3);
                    break;
            }
        }

        answer = compare(score);
        return answer;
    }

    private static Map<String, Integer> initialize() {
        Map<String, Integer> score = new HashMap<>();
        score.put("R", 0); score.put("T", 0); score.put("C", 0); score.put("F", 0);
        score.put("J", 0); score.put("M", 0); score.put("A", 0); score.put("N", 0);
        return score;
    }

    private static String compare(Map<String, Integer> score) {
        String answer = "";

        if (score.get("R") > score.get("T")) answer += "R";
        else if (score.get("R") < score.get("T")) answer += "T";
        else answer += (char) (Math.min("R".charAt(0), "T".charAt(0))) + "";

        if (score.get("C") > score.get("F")) answer += "C";
        else if (score.get("C") < score.get("F")) answer += "F";
        else answer += (char) (Math.min("C".charAt(0), "F".charAt(0))) + "";

        if (score.get("J") > score.get("M")) answer += "J";
        else if (score.get("J") < score.get("M")) answer += "M";
        else answer += (char) (Math.min("J".charAt(0), "M".charAt(0))) + "";

        if (score.get("A") > score.get("N")) answer += "A";
        else if (score.get("A") < score.get("N")) answer += "N";
        else answer += (char) (Math.min("A".charAt(0), "N".charAt(0))) + "";

        return answer;
    }
}