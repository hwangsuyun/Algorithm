package programmers.level0;

import java.util.Scanner;

// 직각 삼각형 출력하기
public class Solution77 {
    public static void main(String[] args) {
        /*
         *
         **
         ***
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        System.out.println(n);

        solution(n);
    }

    public static void solution(int n) {
        String star = "*";
        for (int i = 0; i < n; i++) {
            System.out.println(star);
            star += "*";
        }
    }
}