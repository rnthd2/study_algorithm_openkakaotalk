package data.structure.sort;

import util.MyUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultSort {
	MyUtil util = new MyUtil();

	public static void main(String[] args) {
		DefaultSort sort = new DefaultSort();
		int []array ={2,3,4,5,6,7,8,9,10,1};

		System.out.println(Arrays.toString(sort.selection(array)));
		System.out.println(Arrays.toString(sort.insertion(array)));

//		int []array2 ={6,10,2};
//		sort.maxNum(array2);

		int []array3 ={7,6,5,8,3,5,9,1,6};
		System.out.println(Arrays.toString(sort.heapify(array3)));
	}

	int[] selection(int[] array){
		for (int x = 0; x < array.length-1; x++) {
			int point = x;
			for (int y = x+1; y < array.length; y++) {
				if(array[y] < array[point]) point=y;
			}
			util.swap(array, x, point);
		}
		return array;
	}

	int[] insertion(int[] array){
		for (int i = 0; i < array.length; i++) {
			int point = i;
			int temp = array[i];
			for (int j = i-1; j > -1; j--) {
				if(temp < array[j]){
					array[j+1] = array[j];
					point--;
				}
			}
			array[point] = temp;
		}
		return array;
	}

	void maxNum(int[] array){
		util.permutation(array, 0, array.length, array.length);
		double max = 0;
		for (ArrayList<Integer> list : util.list) {
			double temp = 0;
			int point = 0; //자리수
			for (int i = 0; i < list.size(); i++) {
				point+=(int)Math.log10(list.get(i))+i;
				double a = Math.pow(10, i);
				temp += list.get(i)*a;
			}
			if(max < temp) max = temp;
		}

		System.out.println(max);

	}

	int[] heapify(int[] array){
		int number = array.length;
		for (int i = 0; i < number; i++) {
			int child = i;
			do{
				int root = (child-1)/2;
				if(array[root] < array[child]){
					int temp = array[root];
					array[root] = array[child];
					array[child] = temp;
				}
				child = root;
			} while(child != 0);
		}

		for (int i = number-1 ; i >= 0 ; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			int root = 0;
			int child;

			do {
				child = 2*root+1;
				if(array[child] < array[child+1] && child < i-1)
					child++;
				if(array[root] < array[child] && child < i){
					temp = array[root];
					array[root] = array[child];
					array[child] = temp;
				}
				root = child;
			} while(root*2+2<i);
		}
		return array;
	}
}
