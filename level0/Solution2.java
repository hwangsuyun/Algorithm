package com.example.algorithm.level0;

public class Solution2 {
    public static void main(String[] args) {
        //int[] common = {1, 2, 3, 4}; // 5
        int[] common = {2, 4, 8}; // 16

        if (common.length < 2 || common.length > 1000) return;
        for (int com : common) {
            if (com < -1000 || com > 2000) return;
        }

        System.out.println(solution(common));
    }

    public static int solution(int[] common) {
        int number = common[1] - common[0];
        if (plus(number, common) == true) {
            System.out.println("plus : " + number);
            return number + common[common.length - 1];
        }
        number = common[1] / common[0];
        if (multiplex(number, common) == true) {
            System.out.println("multiplex : " + number);
            return number * common[common.length - 1];
        }
        number = common[0] / common[1];
        if (divide(number, common) == true) {
            System.out.println("divide : " + number);
            if (number == 0) return 0;
            return number / common[common.length - 1];
        }

        return 0;
    }

    public static boolean plus(int sum, int[] common) {
        for (int i = 1; i < common.length; i++) {
            if (sum == (common[i + 1] - common[i])) {
                return true;
            } else {
                break;
            }
        }
        return false;
    }

    public static boolean multiplex(int mul, int[] common) {
        for (int i = 1; i < common.length; i++) {
            if (mul == (common[i + 1] / common[i])) {
                return true;
            } else {
                break;
            }
        }
        return false;
    }

    public static boolean divide(int div, int[] common) {
        for (int i = 1; i < common.length; i++) {
            if (div == (common[i] / common[i + 1])) {
                return true;
            } else {
                break;
            }
        }
        return false;
    }
}
