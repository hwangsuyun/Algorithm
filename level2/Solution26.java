package programmers.level2;

import java.util.Arrays;

// ÆùÄÏ¸ó
public class Solution26 {
	public static void main(String[] args) {
		int[] nums = {3, 1, 2, 3};
		//int[] nums = {3, 3, 3, 2, 2, 4};
		if (nums.length < 1 || nums.length > 10000) return;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 1 || nums[i] > 200000) return;
		}
		solution(nums);
	}
	public static int solution(int[] nums) {
		int cnt = 1, len = nums.length / 2;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			if (i == nums.length - 1) break;
			if (nums[i] != nums[i + 1]) cnt++;
		}
		return cnt >= len ? len : cnt;
	}
}
