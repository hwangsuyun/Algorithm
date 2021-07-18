package oncoder;
//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
// 방정식
import java.util.ArrayList;
import java.util.Collections;
public class Solution1 {
	public static void main(String[] args) {
		int X = 2;
		int Y = 6;
		int P = 5;
		solution(X, Y, P);
	}
	
	 public static int solution(int X, int Y, int P){
		 if (X < 1 || X > 1000) return -1;
	        if (Y < 1 || Y > 1000) return -1;
	        if (P < 1 || P > 1000) return -1;
	        
	        ArrayList<Integer> list = new ArrayList<>();
	        int answer = 0;
	        
	        for (int a = 1; a < 2 * P; a++) {
	            for (int b = 1; b < 2 * P; b++) {
	                if ((a * X + b * Y) % P ==0) {
	                    if (a + b > (2 * P)) break;
	                    list.add(a + b);
	                    break;
	                } 
	            }
	        }
	        Collections.sort(list);
	        answer = list.get(0);
	        
	        return answer;
	    }
}
