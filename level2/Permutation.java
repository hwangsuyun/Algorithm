package programmers.level2;

// 순열(임의의 집합을 다른 순서로 뒤섞는 연산)
public class Permutation {
	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		perm(a, 0, a.length, 1);
	}
	
	public static void perm(int[] arr, int depth, int n, int k) {
		if(depth == k){
			print(arr, k);
			return;
		}
		for(int i = depth; i < n; i++){
			swap(arr, i, depth);
			perm(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}
	}
	
	public static void swap(int[] list, int i, int j) {
		int temp = list[i];
		list[i] = list[j];
		list[j] = temp;
	}
	
	public static void print(int[] arr, int n){
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + "");
		}
		System.out.println();
	}
}
