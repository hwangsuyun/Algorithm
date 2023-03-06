package programmers.level0;

import java.util.Arrays;

// 로그인 성공?
public class Solution34 {
    public static void main(String[] args) {
        //String[] id_pw = {"meosseugi", "1234"};
        //String[][] db = {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}};
        // login
        //String[] id_pw = {"programmer01", "15789"};
        //String[][] db = {{"programmer02", "111111"}, {"programmer00", "134"}, {"programmer01", "1145"}};
        // wrong pw
        //String[] id_pw = {"rabbit04", "98761"};
        //String[][] db = {{"jaja11", "98761"}, {"krong0313", "29440"}, {"rabbit00", "111333"}};
        // fail
        String[] id_pw = {"rabbit04", "98761"};
        String[][] db = {{"", ""}, {"", ""}, {"", ""}};
        // fail

        if (id_pw.length != 2) return;
        if (id_pw[0].length() < 1 || id_pw[0].length() > 15) return;
        if (id_pw[1].length() < 1 || id_pw[1].length() > 6) return;
        if (db.length < 1 || db.length > 10) return;
        for (int i = 0; i < db.length; i++) {
            if (db[i].length != 2) return;
        }

        System.out.println(solution(id_pw, db));
    }

    public static String solution(String[] id_pw, String[][] db) {
        String answer = "";
        boolean id = false, pw = false;

        for (int i = 0; i < db.length; i++) {
            if (db[i][0].equals(id_pw[0])) {
                id = true;
                if (db[i][1].equals(id_pw[1])) {
                    pw = true;
                    break;
                }
            }
        }
        if (id == true && pw == true) answer = "login";
        else if (id == true && pw == false) answer = "wrong pw";
        else if (id == false) answer = "fail";

        return answer;
    }
}
