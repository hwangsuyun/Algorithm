package programmers.level1;

// [1차 다트게임]
public class Solution41 {
	public static void main(String[] args) {
		//String dartResult = "1S2D*3T";   // 37
		//String dartResult = "1D2S#10S";  // 9
		//String dartResult = "1D2S0T";    // 3 
		//String dartResult = "1S*2T*3S";  // 23
		//String dartResult = "1D#2S*3S";  // 5 
		//String dartResult = "1T2D3D#";   // -4
		String dartResult = "1D2S3T*";   // 59		
		System.out.println(solution(dartResult));
	}
	
	public static int solution(String dartResult) {
		int answer = 0;
		int[] array = new int[3];
		int index = 0;
		for (int i = 0; i < dartResult.length(); i++) {
			if (dartResult.charAt(i) == 'S' || dartResult.charAt(i) == 'D' || dartResult.charAt(i) == 'T') {
				if (i == 2) {
					array[index] = square(10, dartResult.charAt(i));
				} else if (i > 1 && dartResult.charAt(i - 1) == 48) {
					if (dartResult.charAt(i - 2) == 49) {
						array[index] = square(10, dartResult.charAt(i));
					}
				} else {
					array[index] = square(dartResult.charAt(i - 1) - 48, dartResult.charAt(i));					
				}
				index++;
			} else if (dartResult.charAt(i) == '*') {
				multiplication(index, array, 2);
			} else if (dartResult.charAt(i) == '#') {
				array[index - 1] = array[index - 1] * -1;
			}
		}
		
		for (Integer i : array) {
			answer += i;
		}
		return answer;
	}
	
	public static int square(int number, char ch) {
		int result = 0;
		switch (ch) {
		case 'S':
			result = number;
			break;
		case 'D':
			result = number * number;
			break;
		case 'T':
			result = number * number * number;
			break;
		default:
			break;
		}
		return result;
	}
	
	public static int[] multiplication(int index, int[] array, int number) {
		switch (index) {
		case 3:
			array[index - 2] = array[index - 2] * number;
			array[index - 1] = array[index - 1] * number;
			break;
		case 2:
			array[index - 2] = array[index - 2] * number;
			array[index - 1] = array[index - 1] * number;
			break;
		case 1:
			array[index - 1] = array[index - 1] * number;
			break;
		default:
			break;
		}
		return array;
	}
}
