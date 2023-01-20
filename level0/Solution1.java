package programmers.level0;

public class Solution1 {
    public static void main(String[] args) {
        //String[] babbling = {"aya", "yee", "u", "maa", "wyeoo"}; // 1
        String[] babbling = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"}; // 3
        //String[] babbling = {"ayaye", "ayaye", "uuuma", "ye", "yemawoo", "ayaa"}; // 4
        //String[] babbling = {"mawyeoo"}; // 0
        //String[] babbling = {"woowo"}; // 0
        //String[] babbling = {"ayaaya","yeye","woowoo","mama"}; // 0

        if (babbling.length < 1 || babbling.length > 100) return;
        for (String bab : babbling) {
            if (bab.length() < 1 || bab.length() > 15) return;
        }

        System.out.println(solution(babbling));
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};
        int containLength = 0;

        for (String bab : babbling) {
            for (String word : words) {
                if (bab.contains(word)) {
                    containLength += word.length();
                    if (bab.length() == containLength) {
                        containLength = 0;
                        answer++;
                        break;
                    }
                }
            }
            containLength = 0;
        }
        return answer;
    }
}
