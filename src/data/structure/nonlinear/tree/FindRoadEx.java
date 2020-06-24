package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FindRoadNodeEx implements Comparable<FindRoadNodeEx>{
	Object element;
	int x;
	int y;
	FindRoadNodeEx leftChild;
	FindRoadNodeEx rightChild;
	FindRoadNodeEx parent;

	public FindRoadNodeEx(Object element, int x, int y) {
		this.element = element;
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	//첫번째 방법
	@Override public int compareTo(FindRoadNodeEx o) {
		return this.getY() > o.getY()? 1 : -1;
	}
}

//두번째 방법
class FindRoadComparatorEx implements Comparator<FindRoadNodeEx> {
	@Override
	public int compare(FindRoadNodeEx o1, FindRoadNodeEx o2) {
		return o2.getY() > o1.getY() ? 1 : -1;
	}
}

public class FindRoadEx {

	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } };
		System.out.println(solution(nodeinfo));
	}

	public static int[][] solution(int[][] nodeinfo) {
		int[][] answer = {};
		ArrayList<FindRoadNodeEx> list = new ArrayList<>();

		// 노드 세팅
		for (int i = 0; i < nodeinfo.length; i++) {
			list.add(new FindRoadNodeEx(i, nodeinfo[i][0], nodeinfo[i][1]));
		}

		// y를 기준으로 내림차순, 반대로하면 오름차순
//		Collections.sort(list, new FindRoadComparator());
		//세번째 방법
//		Collections.sort(list, new Comparator<FindRoadNodeEx>() {
//			@Override public int compare(FindRoadNodeEx o1, FindRoadNodeEx o2) {
//				return o2.getY() > o1.getY() ? 1 : -1;
//			}
//		});
		//네번째 방법
		Collections.sort(list, (o1, o2) -> o2.getY() > o1.getY() ? 1 : -1);

		return answer;
	}


}
