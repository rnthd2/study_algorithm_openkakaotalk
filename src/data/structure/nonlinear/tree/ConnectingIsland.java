package data.structure.nonlinear.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 섬 연결하기
 *
 *
 * https://programmers.co.kr/learn/courses/30/lessons/42861
 */
public class ConnectingIsland {
	static List<ArrayList> sets = new ArrayList();

	static int solution(int n, int[][] costs) {
		List<Integer> answerList = new ArrayList();

		//선택정렬을 이용한 가중치 오름차순으로 정렬
		for (int i = 0; i < costs.length-1; i++) {
			for (int j = i+1; j < costs.length; j++) {
				if(costs[i][2] > costs[j][2])
					costs = swap(costs, i, j);
			}
		}

		//각각의 섬을 하나의 집합으로 세팅
		for (int i = 0; i < n; i++) {
			sets.add(new ArrayList(Arrays.asList(i)));
		}

		//오름차순으로 가중치 최소 경로 선택
		for (int i = 0; i < costs.length; i++) {
			if (findSet(costs[i][0]) != findSet(costs[i][1])) {
				answerList.add(costs[i][2]);

				//집합 세팅
				for (ArrayList set : sets) {
					if(set.contains(costs[i][1])) {
						sets.remove(set);
						break;
					}
				}
				sets.get(costs[i][0]).add(costs[i][1]);
			}
			if(answerList.size() == n-1) break;
		}
		return answerList.stream().mapToInt(e -> e).sum();
	}

	public static void main(String[] args) {
		int n = 4;
		int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int result = solution(n, costs);
		System.out.println(result);
	}

	static int[][] swap(int[][] costs, int i, int j){
		int[] temp = costs[j];
		costs[j] = costs[i];
		costs[i] = temp;
		return costs;
	}

	static List<ArrayList> findSet(int x){
		return sets.stream().filter(set -> set.contains(x)).collect(Collectors.toList());
	}
}
