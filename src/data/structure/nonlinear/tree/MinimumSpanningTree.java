package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//크루스칼 알고리즘 풀이
public class MinimumSpanningTree {
	private static int V = 3;
	private static int E = 3;
	private static ArrayList<Integer> E1 = new ArrayList<>(Arrays.asList(1,2,1));
	private static ArrayList<Integer> E2 = new ArrayList<>(Arrays.asList(2,3,2));
	private static ArrayList<Integer> E3 = new ArrayList<>(Arrays.asList(1,3,3));
	private static List<ArrayList<Integer>> Es = new ArrayList<>(Arrays.asList(E1, E2, E3));
	private static List<ArrayList<Integer>> set = new ArrayList<>();

	public static void main(String[] args) {

		List<ArrayList<Integer>> minSpanningTree = new ArrayList<>();

		//각각의 노드들을 유일한 원소로 가지는 집합을 만든다
		for (int i = 0; i < V; i++) {
			set.add(new ArrayList<>(Arrays.asList(i)));
		}

		//선택정렬을 이용하여 가중치 오름차순으로 정렬한다
		for (int i = 1; i < Es.size(); i++) {
			for (int j = 0; j < i; j++) {
				if(Es.get(j).get(2) > Es.get(i).get(2)){
					Collections.swap(Es, i, j);     //swap
				}
			}
		}

		//사이클을 형성하지 않는 에지(간선)들을 선택한다
		for (ArrayList<Integer> e : Es) {
			if(findSet(e.get(0)) != findSet(e.get(1))){
				minSpanningTree.add(e);

				//같은 집합으로 둔다
				ArrayList temp = set.get(e.get(1));
				set.remove(e.get(1));
				set.add(e.get(0), temp);
			}

			//최소신장트리의 사이즈는 간선-1
			if(minSpanningTree.size() == V-1){
				break;
			}
		}

		//가중치들의 합을 출력한다
		System.out.println(minSpanningTree.stream().mapToInt(e -> e.get(2)).sum());
	}

	static List<ArrayList<Integer>> findSet(int u){
		return set.stream().filter(element -> element.contains(u)).collect(Collectors.toList());
	}
}
