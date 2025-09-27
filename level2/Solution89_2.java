package com.example.algorithm.level2;

// 피로도
public class Solution89_2 {
    public static boolean check[];
    public static int ans = 0;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};
        // 3

        System.out.println(solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        check = new boolean[dungeons.length];

        dfs(k, dungeons, 0);

        return ans;
    }

    public static void dfs(int tired, int[][] dungeons, int cnt){
        for(int i=0; i<dungeons.length; i++){
            if(!check[i] && dungeons[i][0]<=tired){
                check[i] = true;
                dfs(tired-dungeons[i][1], dungeons, cnt+1);
                check[i] = false;
            }
        }
        ans = Math.max(ans, cnt);
    }
}