package programmers.level2;

// 스킬트리
public class Solution2 {
	public static void main(String[] args) {
		String skill = "CBD";
		//String skill = "BC";
		String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
		//String[] skill_trees = {"ABZYCXMLDS"};
		if (skill.length() < 2 || skill.length() > 26) return;
		if (skill_trees.length < 1 || skill_trees.length > 20) return;
		for (int i = 0; i < skill_trees.length; i++) {
			if (skill_trees[i].length() < 2 || skill_trees[i].length() > 26) return;
		}
		solution(skill, skill_trees);
	}
	
	public static int solution(String skill, String[] skill_trees) {
		int[] array = new int[skill.length()];
		int result = 0, loop = skill_trees.length;
		int j = 0;
		while (loop > 0) {
			boolean flag = true;
			for (int i = 0; i < skill.length(); i++) {
				if (skill_trees[j].indexOf(skill.charAt(i)) > -1) {
					array[i] = skill_trees[j].indexOf(skill.charAt(i));
				} else {
					array[i] = 99;
				}
				//System.out.println("array : " + array[i]);
			}

			for (int i = array.length - 1; i > 0; i--) {
				if (array[i] < array[i - 1]) {
					flag = false;
					break;
				}
			}
			if (flag) result ++;
			System.out.println("result " + result);
			
			j++;
			loop--;
		}
		return result;
	}
}
