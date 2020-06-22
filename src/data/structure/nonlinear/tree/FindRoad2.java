package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.Collections;

class FindRoadNode2{
	Object element;
	int x;
	int y;
	FindRoadNode leftChild;
	FindRoadNode rightChild;
	FindRoadNode parent;

	public FindRoadNode2(Object element, int x, int y) {
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

}
public class FindRoad2 {

	public static void main(String[] args) {
		int[][] nodeinfo = { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 }, { 2, 2 } };
		System.out.println(solution(nodeinfo));
	}

	public static int[][] solution(int[][] nodeinfo) {
		int[][] answer = {};
		ArrayList<FindRoadNode2> list = new ArrayList<>();

		// 노드 세팅
		for (int i = 0; i < nodeinfo.length; i++) {
			list.add(new FindRoadNode2(i, nodeinfo[i][0], nodeinfo[i][1]));
		}

		//y를 기준으로 내림차순
		Collections.sort(list, (o1, o2) -> o2.getY() > o1.getY() ? 1 : -1);




		return answer;
	}

	static void set(ArrayList<FindRoadNode2> list){
		FindRoadNode2 root = list.get(0);

	}


}
