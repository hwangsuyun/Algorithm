package programmers.level1;

// 옹알이 (2)
public class Solution65 {
    public static void main(String[] args) {
        //String[] babbling = {"aya", "yee", "u", "maa"}; // 1
        String[] babbling = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}; // 2
        //String[] babbling = {"ayayeaya"}; // 1

        if (babbling.length < 1 || babbling.length > 100) return;
        for (int i = 0; i < babbling.length; i++) {
            if (babbling[i].length() < 1 || babbling[i].length() > 30) return;
        }

        System.out.println(solution(babbling));
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        String[] words = {"aya", "ye", "woo", "ma"};

        for (String bab : babbling) {
            for (int i = 0; i < words.length; i++) {
                if (!bab.contains(words[i] + words[i])) {
                    bab = bab.replace(words[i], " ");
                }
            }
            bab = bab.replace(" ", "");
            if (bab.length() == 0) {
                answer++;
            }
        }

        return answer;
    }
}