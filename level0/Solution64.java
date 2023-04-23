package programmers.level0;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

// 가위 바위 보
public class Solution64 {
    public static void main(String[] args) {
        //String rsp = "2"; // 0
        String rsp = "205"; // 052

        if (rsp.length() < 0 || rsp.length() > 100) return;
        if (!rsp.contains("0") && !rsp.contains("2") && !rsp.contains("5")) return;

        System.out.println(solution(rsp));
    }

    public static String solution(String rsp) {
        String result = "";
        for (String s : rsp.split("")) {
            if (s.equals("2")) result += "0";
            else if (s.equals("0")) result += "5";
            else result += "2";
        }
        return result;
    }
}