public class Solution84_1 {
    public static void main(String[] args) {
        int n = 22;
        int w = 6;
        int num = 8;
        // 3
        System.out.println(solution(n, w, num));
    }

    /*
        Programmers. 택배 상자 꺼내기
        ---------------------------
        [문제 설명]
        택배 상자
        - 1~N

        택배 쌓기
        - 왼쪽에서 오른쪽으로 w개 쌓기
        - 그 위에 오른쪽에서 왼쪽으로 w개 쌓기
        - 반복

        택배 꺼내기
        - 입력된 상자번호(A)를 꺼내기
        - 그 위에 쌓인 모든 상자부터 꺼내야 함

        [입력]
        N : 창고에 있는 택배 상자의 수
        W : 가로로 놓는 상자 수
        num : 꺼내려는 상자 번호

        [출력]
        꺼래려는 상자를 포함해서 총 꺼내야하는 상자의 수

        [제한사항]
        2 <= N <= 100
        1 <= W <= 10
        1 <= num <= N
    */

    public static int solution(int n, int w, int num) {
        // 입력
        // 문제풀이
        /**/
        int cnt = 0;
        while (num <= n) {
            num += (w - ((num-1) % w) - 1) * 2 + 1;
            cnt++;
        }

        // 반환
        int answer = cnt;
        return answer;
    }
}
