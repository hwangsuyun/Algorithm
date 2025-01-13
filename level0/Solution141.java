package com.example.algorithm.level0;

import java.util.ArrayList;

// 공백으로 구분하기 1
public class Solution141 {
    public static void main(String[] args) {
        String my_string = "i love you"; // ["i", "love", "you"]
        //String my_string = "programmers"; // ["programmers"]

        if (my_string.length() < 1 || my_string.length() > 1000) return;

        String[] result = solution(my_string);
        for (String str : result) {
            System.out.println(str);
        }
    }

    public static String[] solution(String my_string) {
        return my_string.split(" ");
    }

    public static ArrayList<String> solution2(String my_string) {
        ArrayList<String> answer = new ArrayList();
        String a = "";

        for(int i=0; i<=my_string.length();i++){
            if(my_string.charAt(i) == ' '){
                answer.add(a);
                a = "";
            }else if(i == my_string.length()-1){
                a += Character.toString(my_string.charAt(my_string.length()-1));
                answer.add(a);
                break;
            }else{
                a += Character.toString(my_string.charAt(i));
            }
        }

        return answer;
    }
}