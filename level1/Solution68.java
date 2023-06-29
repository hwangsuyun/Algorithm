package programmers.level1;

import java.util.HashMap;
import java.util.Map;

// 숫자 짝꿍
public class Solution68 {
    public static void main(String[] args) {
        //String X = "100";
        //String Y = "2345";
        // "-1"
        //String X = "100";
        //String Y = "203045";
        // "0"
        //String X = "100";
        //String Y = "123450";
        // "10"
        //String X = "12321";
        //String Y = "42531";
        // "321"
        //String X = "5525";
        //String Y = "1255";
        // "552"
        String X = "1000000002";
        String Y = "20200";
        // "2000"

        if (X.length() < 3 || X.length() > 3000000) return;
        if (Y.length() < 3 || Y.length() > 3000000) return;

        System.out.println(solution(X, Y));
    }

    public static String solution(String X, String Y) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        Map<Integer, Integer> xMap = new HashMap<>();
        Map<Integer, Integer> yMap = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            xMap.put(i, 0);
            yMap.put(i, 0);
        }
        for (int i = 0; i < X.length(); i++) {
            xMap.put(X.charAt(i) - '0', xMap.get(X.charAt(i) - '0') + 1);
        }
        for (int i = 0; i < Y.length(); i++) {
            yMap.put(Y.charAt(i) - '0', yMap.get(Y.charAt(i) - '0') + 1);
        }
        for (int i = 9; i >= 0; i--) {
            answer = Math.min(xMap.get(i), yMap.get(i));
            for (int j = 0; j < answer; j++) {
                sb.append(i);
            }
        }

        if (sb.length() == 0) return "-1";
        if (sb.toString().charAt(0) == '0') return "0";
        return sb.toString();
    }
}