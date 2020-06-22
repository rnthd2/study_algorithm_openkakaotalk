package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FindRoadNode implements Comparable<FindRoadNode>{
	Object element;
	int x;
	int y;
	FindRoadNode leftChild;
	FindRoadNode rightChild;
	FindRoadNode parent;

	public FindRoadNode(Object element, int x, int y) {
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
	@Override public int compareTo(FindRoadNode o) {
		return this.getY() > o.getY()? 1 : -1;
	}
}

//두번째 방법
class FindRoadComparator implements Comparator<FindRoadNode> {
	@Override
	public int compare(FindRoadNode o1, FindRoadNode o2) {
		return o2.getY() > o1.getY() ? 1 : -1;
	}
}

public class FindRoad {

	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } };
		System.out.println(solution(nodeinfo));
	}

	public static int[][] solution(int[][] nodeinfo) {
		int[][] answer = {};
		ArrayList<FindRoadNode> list = new ArrayList<>();

		// 노드 세팅
		for (int i = 0; i < nodeinfo.length; i++) {
			list.add(new FindRoadNode(i, nodeinfo[i][0], nodeinfo[i][1]));
		}

		// y를 기준으로 내림차순
//		Collections.sort(list, new FindRoadComparator());
		//세번째 방법
//		Collections.sort(list, new Comparator<FindRoadNode>() {
//			@Override public int compare(FindRoadNode o1, FindRoadNode o2) {
//				return o2.getY() > o1.getY() ? 1 : -1;
//			}
//		});
		//네번째 방법
		Collections.sort(list, (o1, o2) -> o2.getY() > o1.getY() ? 1 : -1);

		return answer;
	}


}
