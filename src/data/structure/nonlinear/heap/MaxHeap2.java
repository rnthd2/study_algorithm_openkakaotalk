package data.structure.nonlinear.heap;

import java.util.ArrayList;
import java.util.Collections;

public class MaxHeap2 {
	static ArrayList<Integer> heap = new ArrayList<>();
	static int point = -1;

	public static void main(String[] args) {
		int N = 13;
		int[] operations = { 0, 1, 2, 0, 0, 3, 2, 1, 0, 0, 0, 0, 0 };

		for (int operation : operations) {
			//가장 큰 값을 출력하고 그 값을 배열에서 제거하는 경우
			if (operation == 0) {
				if (heap.size() < 1) {
					System.out.println(0);
				} else {
					printMaxHeapNode();
					remove();
				}
			}
			//힙에 추가하는 경우
			else {
				add(operation);
			}
		}
	}

	/**
	 * 1-1) 노드의 삽입
	 * 최대 힙인지 최소 힙인지 판단합니다.
	 * 트리 기준 가장 마지막 자리에 노드를 삽입합니다.
	 * 부모와 비교하여 최대 힙/최소 힙 규칙에 따라 교환합니다.
	 * 위 과정을 반복합니다.
	 *
	 * @param operation
	 */
	static void add(int operation) {
		int temp = ++point;
		heap.add(operation);
		while (temp > 0) {
			if (heap.get(temp) > heap.get(temp - 1)) {
				Collections.swap(heap, temp, temp - 1);
				--temp;
			} else {
				break;
			}
		}
	}

	/**
	 * 1-2) 노드의 삭제
	 * 최대 힙인지 최소 힙인지 판단합니다.
	 * 루트 노드를 제거합니다(최대 값 혹은 최소 값이 저장된 루트만 제거가 가능합니다)
	 * 가장 마지막 노드를 루트 자리에 넣습니다
	 * 자식과 비교하여 최대 힙/최소 힙 규칙에 따라 교환합니다.
	 * 위 과정을 반복합니다.
	 */
	static void remove() {
		heap.set(0, heap.get(point));
		heap.remove(point--);
		int temp = 0;
		while (temp < point) {
			if (heap.get(temp) < heap.get(temp + 1)) {
				Collections.swap(heap, temp, temp + 1);
				++temp;
			} else {
				break;
			}
		}
	}

	static void printMaxHeapNode() {
		System.out.println(heap.get(0));
	}
}
