package programmers.level2;

// 소수 만들기
public class Solution35 {
	public static void main(String[] args) {
		//int[] nums = {1, 2, 3, 4};
		int[] nums = {1, 2, 7, 6, 4};
		if (nums.length < 3 || nums.length > 50) return;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 1 || nums[i] > 1000) return;
		}
		solution(nums);
	}
	public static int solution(int[] nums) {
		int temp = 0;
		boolean flag = false;
		int result = 0;
		for (int i = 0; i < nums.length; i++) {
			temp += nums[i];
			for (int j = i + 1; j <= nums.length - 1; j++) {
				temp += nums[j];
				for (int k = j + 1; k <= nums.length - 1; k++) {
					temp += nums[k];
					flag = isPrimeNumber(temp);
					if (flag) result++;
					temp -= nums[k];
				}
				temp -= nums[j];
			}
			temp -= nums[i];
		}
		System.out.println(result);
		return result;
	}
	public static boolean isPrimeNumber(int num) {
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) return false;
		}
		return true;
	}
}
