package data.structure.nonlinear.heap;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Swap 회수가 최대가 되도록 하는 힙을 출력
 */
public class HeapSortDefault2 {
	static int swap = 0;
	ArrayList<ArrayList> list = new ArrayList<>();
	static final int N = 6;

	public static void main(String[] args) {
		HeapSortDefault2 heapSort = new HeapSortDefault2();

		System.out.println(heapSort.solution(N));
	}

	private ArrayList<Integer> solution(int N){
		ArrayList<Integer> result = new ArrayList<>();
		ArrayList<Integer> num = new ArrayList<>(N);

		for (int i = 1; i <= N; i++) {
			num.add(i);
		}

		// 순열 알고리즘으로 모든 배열의 순을 구한다
		perm(num, 0, N, N);

		// todo 그 중 최대힙인 경우만 가져온다
		ArrayList<ArrayList> test = new ArrayList<>();
		test.addAll(list);
		for (ArrayList arrayList : test) {
			if(!chMaxHeap(arrayList)){
				list.remove(arrayList);
			}
		}

		// swap이 가장 적은 경우만 가져온다
		for (ArrayList arrayList : list) {
			int val = swap;
			swap=0;
			ArrayList<Integer> a = new ArrayList<>();
			a.addAll(arrayList);
			makeHeap(arrayList);
			if(val < swap){
				result = a;
			}
		}

		return result;
	}

	void perm(ArrayList arr, int depth, int n, int k) {

		//todo 복사 방식을 바꾸었다
		if (depth == k) {
			ArrayList test = new ArrayList();
			test.addAll(arr);
			list.add(test);
			return;
		}
		for (int i = depth; i < n; i++) {
			Collections.swap(arr, i, depth);
			perm(arr, depth + 1, n, k);
			Collections.swap(arr, i, depth);
		}
	}


	boolean chMaxHeap(ArrayList<Integer> arr){
		boolean result = false;

		//todo 모든 배열이 최대힙으로 만족해야됨... 수정 필요
		if(test(1, arr) && test(2, arr) && test(3, arr) && test(4, arr) && test(5, arr))
			result = true;


		return result;
	}

	boolean test(int i, ArrayList<Integer> arr){
		if((i%2==0 && arr.get(i/2-1) > arr.get(i)) || ((i%2!=0 && arr.get(i/2) > arr.get(i)))) {
			return true;
		}
		return false;
	}

	private ArrayList<Integer> makeHeap(ArrayList<Integer> heap) {
		int lastIndex = heap.size() - 1;
		//최댓값 삭제
		Collections.swap(heap, 0, lastIndex);
		heap.remove(heap.get(lastIndex));

		//swap
		for (int i = 1; i < heap.size(); i++) {
			if (heap.get(i) > heap.get(i - 1)) {
				Collections.swap(heap, i, i - 1);
				swap++;
			}
		}

		if(heap.size() > 1){
			makeHeap(heap);
		}

		return heap;
	}

}
