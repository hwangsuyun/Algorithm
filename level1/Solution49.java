package programmers.level1;

import java.util.LinkedHashMap;
import java.util.Map;

// 추억 점수
public class Solution49 {
    public static void main(String[] args) {
        //String[] name = {"may", "kein", "kain", "radi"};
        //int[] yearning = {5, 10, 1, 3};
        //String[][] photo = {{"may", "kein", "kain", "radi"},
        //                    {"may", "kein", "brin", "deny"},
        //                    {"kon", "kain", "may", "coni"}};
        //[19, 15, 6]
        //String[] name = {"kali", "mari", "don"};
        //int[] yearning = {11, 1, 55};
        //String[][] photo = {{"kali", "mari", "don"},
        //                    {"pony", "tom", "teddy"},
        //                    {"con", "mona", "don"}};
        //[67, 0, 55]
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may"},
                            {"kein", "deny", "may"},
                            {"kon", "coni"}};
        //[5, 15, 0]


        if (name.length < 3 || name.length > 100) return;
        if (yearning.length < 3 || yearning.length > 100) return;
        if (photo.length < 3 || photo.length > 100) return;

        int[] result = solution(name, yearning, photo);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        int sum = 0;

        Map<String, String> map = new LinkedHashMap<>();
        for (int i = 0; i < name.length; i++) {
            if (i < yearning.length) {
                map.put(name[i], String.valueOf(yearning[i]));
            } else {
                map.put(name[i], "0");
            }
        }

        for (int i = 0; i < photo.length; i++) {
            for (int j = 0; j < photo[i].length; j++) {
                for (String key : map.keySet()) {
                    if (photo[i][j].equals(key)) {
                        sum += Integer.parseInt(map.get(key));
                    }
                }
            }
            answer[i] = sum;
            sum = 0;
        }

        return answer;
    }
}