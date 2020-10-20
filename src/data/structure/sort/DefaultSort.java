package data.structure.sort;

import util.MyUtil;

import java.util.ArrayList;
import java.util.Arrays;

public class DefaultSort {
	MyUtil util = new MyUtil();

	static int[] quickArray= {3,7,8,1,5};
	public static void main(String[] args) {
		DefaultSort sort = new DefaultSort();
		int[] array = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 1 };

		System.out.println(Arrays.toString(sort.selection(array)));
		System.out.println(Arrays.toString(sort.insertion(array)));

		//		int []array2 ={6,10,2};
		//		sort.maxNum(array2);

		int[] array3 = { 7, 6, 5, 8, 3, 5, 9, 1, 6 };
		System.out.println(Arrays.toString(sort.heapify(array3)));

		sort.quick(0, quickArray.length-1);
		System.out.println(Arrays.toString(quickArray));
	}

	int[] selection(int[] array) {
		for (int x = 0; x < array.length - 1; x++) {
			int point = x;
			for (int y = x + 1; y < array.length; y++) {
				if (array[y] < array[point])
					point = y;
			}
			util.swap(array, x, point);
		}
		return array;
	}

	int[] insertion(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int point = i;
			int temp = array[i];
			for (int j = i - 1; j > -1; j--) {
				if (temp < array[j]) {
					array[j + 1] = array[j];
					point--;
				}
			}
			array[point] = temp;
		}
		return array;
	}

	void maxNum(int[] array) {
		util.permutation(array, 0, array.length, array.length);
		double max = 0;
		for (ArrayList<Integer> list : util.list) {
			double temp = 0;
			int point = 0; //자리수
			for (int i = 0; i < list.size(); i++) {
				point += (int) Math.log10(list.get(i)) + i;
				//10의 제곱근 구하기
				double a = Math.pow(10, i);
				temp += list.get(i) * a;
			}
			if (max < temp)
				max = temp;
		}

		System.out.println(max);

	}

	int[] heapify(int[] array) {
		int number = array.length;

		//최대 힙으로 만든다
		for (int i = 0; i < number; i++) {
			int child = i;
			do {
				//root 포인터는 (child - 1) / 2 이다
				int root = (child - 1) / 2;
				if (array[root] < array[child]) {
					int temp = array[root];
					array[root] = array[child];
					array[child] = temp;
				}
				child = root;
			} while (child != 0);
		}

		//최댓값을 제외한 나머지를 최대 힙으로 만든다
		for (int i = number - 1; i >= 0; i--) {
			int temp = array[0];
			array[0] = array[i];
			array[i] = temp;

			int root = 0;
			int child;

			do {
				//child 포인터는 2 * root + 1이다
				child = 2 * root + 1;

				//바로 아래 자식노드 중 큰 것만 비교할 가치가 있다
				if (array[child] < array[child + 1] && child < i - 1)
					child++;

				//부모와 자식노드 중 큰 것과 비교한다
				if (array[root] < array[child] && child < i) {
					temp = array[root];
					array[root] = array[child];
					array[child] = temp;
				}

				//바로 아래 자식노드 중 큰 것만 비교할 가치가 있다
				root = child;
			} while (root * 2 + 2 < i);
		}
		return array;
	}

	static void quick(int start, int end) {
		int pivot = start;
		int big = start + 1;
		int small = end;

		//양쪽 그룹이 모두 정렬 되어있다
		if(start >= end){
			return;
		}
		//pivot보다 큰 값을 찾는다
		while (big <= end && quickArray[pivot] > quickArray[big] ) {
			big++;
		}

		//pivot보다 작은 값을 찾는다
		while (small >= start && quickArray[pivot] < quickArray[small] ) {
			small--;
		}

		// 서로 엇갈리지 않아 swap만 한다
		if(big < small) {
			swap(quickArray, big, small);
			quick(start, end);
		}
		// 서로 엇갈려 작은 값을 찾아 swap 한다
		else {
			if(big >= quickArray.length || quickArray[big] > quickArray[small]){
				big = small;
			}
			swap(quickArray, pivot, big);
			quick(pivot, big-1); // left group
			quick(big+1, end);   // right group
		}
	}

	public static int[] swap(int[] array, int i, int j){
		int temp = array[j];
		array[j] = array[i];
		array[i] = temp;
		return array;
	}
}
