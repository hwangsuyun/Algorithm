package programmers.level0;

// 외계어 사전
public class Solution41 {
    public static void main(String[] args) {
        //String[] spell = {"p", "o", "s"};
        //String[] dic = {"sod", "eocd", "qixm", "adio", "soo"};
        // 2
        //String[] spell = {"z", "d", "x"};
        //String[] dic = {"def", "dww", "dzx", "loveaw"};
        // 1
        //String[] spell = {"s", "o", "m", "d"};
        //String[] dic = {"moos", "dzx", "smm", "sunmmo", "som"};
        // 2
        String[] spell = {"a", "b", "c"};
        String[] dic = {"abcd", "efg"};
        // 1

        if (spell.length < 2 || spell.length > 10) return;
        for (int i = 0; i < spell.length; i++) {
            if (spell[i].length() != 1) return;
        }
        if (dic.length < 1 || dic.length > 10) return;
        for (int i = 0; i < dic.length; i++) {
            if (dic[i].length() < 1 || dic[i].length() > 10) return;
        }

        System.out.println(solution(spell, dic));
    }

    public static int solution(String[] spell, String[] dic) {
        boolean flag = false;
        for (int i = 0; i < dic.length; i++) {
            for (int j = 0; j < spell.length; j++) {
                if (!dic[i].contains(spell[j])) break;
                if (j == spell.length - 1) {
                    flag = true;
                }
            }
            if (flag) return 1;
        }
        return 2;
    }
}
