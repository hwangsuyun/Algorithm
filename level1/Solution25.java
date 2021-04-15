package programmers.level1;

// 정수 제곱근 판별
public class Solution25 {
	public static void main(String[] args) {
		long n = 121;
		System.out.println(solution(n));
	}
	
	public static long solution(long n) {
		double result = Math.sqrt(n);
		int index = (result + "").indexOf(".");
		String str = "";
		try {
			str = (result + "").substring(index, index + 3);
			return -1;
		} catch (StringIndexOutOfBoundsException e) {
			//e.printStackTrace();
			str = (result + "").substring(index, index + 2);
			if (str.equals(".0")) result = (result + 1) * (result + 1);
		}
		System.out.println(result);
		return (long) result;
	}
}
