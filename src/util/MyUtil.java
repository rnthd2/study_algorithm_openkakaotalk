package util;

import java.util.ArrayList;

public class MyUtil {

	public int[] swap(int[] array, int i, int j){
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
		return array;
	}
	
	public int[][] swap(int[][] array, int i, int j){
		int[] temp = array[j];
		array[j] = array[i];
		array[i] = temp;
		return array;
	}

	public ArrayList<ArrayList> list = new ArrayList();
	public void permutation(int[] arr, int depth, int n, int r) {
		if (depth == r) {
			ArrayList temp = new ArrayList<>();
			for (int i : arr) { temp.add(i); }
			list.add(temp);
			return;
		}

		for (int i=depth; i<n; i++) {
			swap(arr, depth, i);
			permutation(arr, depth + 1, n, r);
			swap(arr, depth, i);
		}
	}
}
