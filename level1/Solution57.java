package programmers.level1;

import java.util.*;

// 달리기 경주
public class Solution57 {
    public static void main(String[] args) {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        //["mumu", "kai", "mine", "soe", "poe"]

        if (players.length < 5 || players.length > 50000) return;
        for (int i = 0; i < players.length; i++) {
            if (players[i].length() < 3 || players[i].length() > 10) return;
        }
        if (callings.length < 2 || callings.length > 100000) return;

        String[] result = solution(players, callings);
        for (String str : result) System.out.println(str);
    }

    public static String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> playerRank = new HashMap<>();
        Map<Integer, String> rankPlayer = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            playerRank.put(players[i], i);
            rankPlayer.put(i, players[i]);
        }

        for (int i = 0; i < callings.length; i++) {
            int currentRank = playerRank.get(callings[i]);
            int preRank = currentRank - 1;
            String currentPlayer = callings[i];
            String prePlayer = rankPlayer.get(preRank);

            playerRank.put(currentPlayer, preRank);
            playerRank.put(prePlayer, currentRank);
            rankPlayer.put(preRank, currentPlayer);
            rankPlayer.put(currentRank, prePlayer);
        }

        for (int i = 0; i < rankPlayer.size(); i++) {
            answer[i] = rankPlayer.get(i);
        }

        return answer;
    }
}