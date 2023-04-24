package programmers.level0;

// 모스부호(1)
public class Solution65 {
    public static void main(String[] args) {
        //String letter = ".... . .-.. .-.. ---"; // hello
        String letter = ".--. -.-- - .... --- -."; // python

        if (letter.length() < 1 || letter.length() > 1000) return;

        System.out.println(solution(letter));
    }

    public static String solution(String letter) {
        String result = "";
        for (String str : letter.split(" ")) {
            if (str.equals(".-")) result += "a";
            if (str.equals("-...")) result += "b";
            if (str.equals("-.-.")) result += "c";
            if (str.equals("-..")) result += "d";
            if (str.equals(".")) result += "e";
            if (str.equals("..-.")) result += "f";
            if (str.equals("--.")) result += "g";
            if (str.equals("....")) result += "h";
            if (str.equals("..")) result += "i";
            if (str.equals(".---")) result += "j";
            if (str.equals("-.-")) result += "k";
            if (str.equals(".-..")) result += "l";
            if (str.equals("--")) result += "m";
            if (str.equals("-.")) result += "n";
            if (str.equals("---")) result += "o";
            if (str.equals(".--.")) result += "p";
            if (str.equals("--.-")) result += "q";
            if (str.equals(".-.")) result += "r";
            if (str.equals("...")) result += "s";
            if (str.equals("-")) result += "t";
            if (str.equals("..-")) result += "u";
            if (str.equals("...-")) result += "v";
            if (str.equals(".--")) result += "w";
            if (str.equals("-..-")) result += "x";
            if (str.equals("-.--")) result += "y";
            if (str.equals("--..")) result += "z";
        }
        return result;
    }
}