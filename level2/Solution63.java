package programmers.level2;

import java.util.Stack;

// 마법의 엘리베이터
public class Solution63 {
    public static void main(String[] args) {
        //int storey = 16; // 6
        //int storey = 2554; // 16
        //int storey = 99; // 2
        //int storey = 75; // 8
        //int storey = 555; // 14
        //int storey = 155; // 11
        //int storey = 154; // 10
        int storey = 95; // 6
        //int storey = 545; // 14
        //int storey = 57595358; // 26

        if (storey < 1 || storey > 100000000) return;

        System.out.println(solution(storey));
    }

    public static int solution(int storey) {
        int answer = 0;
        String str = storey + "";
        int[] array = new int[str.length() + 1];
        boolean flag = false;

        array[0] = -9;
        for (int i = 0; i < str.length(); i++) {
            array[i + 1] = Integer.parseInt(str.charAt(i) + "");
        }

        for (int i = array.length - 1; i >= 0; i--) {
            int num = array[i];
            if (num == 5) {
                for (int j = i - 1; j >= 1; j--) {
                    if (array[j] <= 4) {
                        flag = false;
                        break;
                    } else if (array[j] >= 6) {
                        flag = true;
                        break;
                    } else if (array[j] == 5) {
                        flag = true;
                    }
                }
            }

            if (flag || num >= 6) {
                while (num < 10) {
                    answer++;
                    num++;
                }

                if (array[i - 1] == -9) {
                    answer++;
                    break;
                } else if (array[i - 1] == 9) {
                    array[i - 1] = 0;
                    if (array[i - 2] == -9) array[i - 2] = 1;
                    else array[i - 2] += 1;
                } else {
                    array[i - 1] += 1;
                }
            } else {
                while (num > 0) {
                    answer++;
                    num--;
                }
            }
            flag = false;
        }

        return answer;
    }
}