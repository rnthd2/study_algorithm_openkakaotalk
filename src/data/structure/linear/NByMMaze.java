package data.structure.linear;

import com.sun.source.tree.Tree;

import java.util.Scanner;

/**
 * N×M크기의 배열로 표현되는 미로가 있다.
 * 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
 * 이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
 * 한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
 * 위의 예에서는 15칸을 지나야 (N, M)의 위치로 이동할 수 있다. 칸을 셀 때에는 시작 위치와 도착 위치도 포함한다.
 * <p>
 * 입력
 * 첫째 줄에 두 정수 N, M(2 ≤ N, M ≤ 100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가 주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
 * <p>
 * 출력
 * 첫째 줄에 지나야 하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어진다.
 * <p>
 * https://www.acmicpc.net/problem/2178
 */
//좌선법,우선법 : 벽타고감, 최단거리 알고리즘 아님, 미로 중간에 출구가 있으면 못찾음, 방문한곳을 제외하는면에서 dfs bfs와 닮았지만 다름, 메모리를 적게먹음
//dfs, bfs : 모든 경로의 weight가 같은 경우에는 BFS탐색이 항상 최단 경로를 찾는다
//최단 경로를 찾아내는 알고리즘은 다익스트라 알고리즘이다.
public class NByMMaze {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Integer MAZE_ROW_SIZE = null;
		Integer MAZE_COL_SIZE = null;

		while (sc.hasNextLine()) {
			String src = sc.next();
			if (MAZE_ROW_SIZE == null && MAZE_COL_SIZE == null) {
				String[] size = src.split(" ");
				MAZE_ROW_SIZE = Integer.valueOf(size[0]);
				MAZE_COL_SIZE = Integer.valueOf(size[1]);
			} else {
				int[][] maze = new int[MAZE_ROW_SIZE][MAZE_COL_SIZE];
				for (int i = 0; i < MAZE_ROW_SIZE ; i++) {
					for (int j = 0; j < MAZE_COL_SIZE; j++) {
						maze[i][j] = Integer.valueOf(src.charAt(j));
					}
				}
			}
		}



	}
}
