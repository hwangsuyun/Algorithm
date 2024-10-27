package com.example.algorithm.level0;

// 그림 확대
public class Solution109 {
    public static void main(String[] args) {
        String[] picture = {".xx...xx.",
                            "x..x.x..x",
                            "x...x...x",
                            ".x.....x.",
                            "..x...x..",
                            "...x.x...",
                            "....x...."};
        int k = 2;
        /*
          ["..xxxx......xxxx..",
           "..xxxx......xxxx..",
           "xx....xx..xx....xx",
           "xx....xx..xx....xx",
           "xx......xx......xx",
           "xx......xx......xx",
           "..xx..........xx..",
           "..xx..........xx..",
           "....xx......xx....",
           "....xx......xx....",
           "......xx..xx......",
           "......xx..xx......",
           "........xx........",
           "........xx........"]
        */
        //String[] picture = {"x.x",
        //                    ".x.",
        //                    "x.x"};
        //int k = 3;
        /*
          ["xxx...xxx",
           "xxx...xxx",
           "xxx...xxx",
           "...xxx...",
           "...xxx...",
           "...xxx...",
           "xxx...xxx",
           "xxx...xxx",
           "xxx...xxx"]
         */

        if (picture.length < 1 || picture.length > 20) return;
        for (String s : picture) {
            if (s.length() < 1 || s.length() > 20) return;
        }
        if (k < 1 || k > 10) return;

        String[] result = solution(picture, k);
        for (String s : result) {
            System.out.println(s);
        }
    }

    /*
      ".xx...xx.",
      "x..x.x..x",
      "x...x...x",
      ".x.....x.",
      "..x...x..",
      "...x.x...",
      "....x...."
    */

    public static String[] solution(String[] picture, int k) {
        int index = 0;
        String[] answer = new String[picture.length * k];

        for (String s : picture) {
            StringBuilder sb = new StringBuilder();

            for (char ch : s.toCharArray()) {
                sb.append(String.valueOf(ch).repeat(Math.max(0, k)));
            }

            for (int i = 0; i < k; i++) {
                answer[index] = sb.toString();
                index++;
            }
        }

        return answer;
    }

    public static String[] solution2(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        int idx = 0;

        for(int i=0; i<picture.length; i++) {
            for(int j=0; j<k; j++) {
                StringBuilder sb = new StringBuilder();

                for(int l=0; l<picture[i].length(); l++) {
                    sb.append(String.valueOf(picture[i].charAt(l)).repeat(k));
                }

                answer[idx++] = sb.toString();
            }
        }

        return answer;
    }
}