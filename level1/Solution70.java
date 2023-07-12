package programmers.level1;

import java.util.*;

// 신고 결과 받기
public class Solution70 {
    public static void main(String[] args) {
        //String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        //String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        //int k = 2;
        // [2,1,1,0]
        //String[] id_list = {"con", "ryan"};
        //String[] report = {"ryan con", "ryan con", "ryan con", "ryan con"};
        //int k = 3;
        // [0,0]
        String[] id_list = {"muzi", "frodo", "apeach", "neo"};
        String[] report = {"muzi frodo", "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;
        // [2,1,1,0]

        if (id_list.length < 2 || id_list.length > 1000) return;
        for (int i = 0; i < id_list.length; i++) {
            if (id_list[i].length() < 1 || id_list[i].length() > 10) return;
        }
        if (report.length < 1 || report.length > 200000) return;
        for (int i = 0; i < report.length; i++) {
            if (report[i].length() < 3 || report[i].length() > 21) return;
        }
        if (k < 1 || k > 200) return;

        int[] result = solution(id_list, report, k);
        for (int i : result) System.out.println(i);
    }

    public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        int count = 0;
        Map<String, String> idMap = new HashMap<>();
        Map<String, Integer> scoreMap = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (String id : id_list) {
            scoreMap.put(id, 0);
        }

        for (String rep : report) {
            String[] array = rep.split(" ");
            idMap.put(array[0], "");
            set.add(rep);
        }

        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            String[] array = iterator.next().split(" ");
            idMap.put(array[0], idMap.get(array[0]) + "," + array[1]);
            scoreMap.put(array[1], scoreMap.get(array[1]) + 1);
        }

        for (int i = 0; i < id_list.length; i++) {
            if (idMap.get(id_list[i]) == null) {
                answer[i] = count;
            } else {
                String[] array = idMap.get(id_list[i]).split(",");
                for (String str : array) {
                    if (str.length() == 0) continue;
                    if (scoreMap.get(str) >= k) {
                        count++;
                        answer[i] = count;
                    }
                }
            }
            count = 0;
        }

        return answer;
    }
}