package programmers.level1;

// N으로 표현
public class Solution2 {
	static int answer = -1;
	
	public static void main(String[] args) {
		int N = 5;
		int number = 12;
		/*
		12 = 5 + 5 + (5 / 5) + (5 / 5)
		12 = 55 / 5 + 5 / 5
		12 = (55 + 5) / 5
		*/	
		int result = solution(N, number);
		System.out.println(result);
	}

	public static int solution(int N, int number) {
		dfs(N, 0, 0, number, "");
        return answer;
	}
	
	public static void dfs(int n, int pos, int num, int number, String s) {
        if (pos > 8)
            return;
        if (num == number) {
            if (pos < answer || answer == -1) {
                System.out.println(s);
                answer = pos;
            }
            return;
        }
        int nn=0;
        for (int i = 0; i < 8; i++) {
            nn=nn*10+n;
            dfs(n, pos + 1+i, num + nn, number, s + "+");
            dfs(n, pos + 1+i, num - nn, number, s + "-");
            dfs(n, pos + 1+i, num * nn, number, s + "*");
            dfs(n, pos + 1+i, num / nn, number, s + "/");
        }
        // dfs(n,pos+1,num*10+n,number,s+"5");
    }
	
}

	