package programmers.level0;

// 다항식 더하기
public class Solution45 {
    public static void main(String[] args) {
        //String polynomial = "3x + 7 + x"; // 4x + 7
        //String polynomial = "x + x + x"; // 3x
        String polynomial = "x + 7 + 15"; // x + 22
        //String polynomial = " "; // 0
        //String polynomial = "1 + 1"; // 2

        if (polynomial.length() <= 0 || polynomial.length() > 50) return;

        System.out.println(solution(polynomial));
    }

    public static String solution(String polynomial) {
        polynomial = polynomial.replace(" ", "");
        if (polynomial.equals("") || polynomial.equals("0")) return "0";
        System.out.println("polynomial : " + polynomial);
        int temp1 = 0, temp2 = 0;
        String[] array = polynomial.split("\\+");
        for (String str : array) {
            if (str.contains("x")) {
                System.out.println("str : " + str);
                System.out.println("index : " + str.indexOf("x"));
                temp1 += str.indexOf("x") != 0 ? Integer.parseInt(str.substring(0, str.indexOf("x"))) : 1;
            } else {
                temp2 += Integer.parseInt(str);
            }
        }
        String answer = "";
        if (temp1 != 0) answer = temp1 != 1 ? temp1 + "x" : "x";
        if (temp2 != 0) answer = !answer.equals("") ? answer += " + " + temp2 : temp2 + "";
        return answer;
    }
}