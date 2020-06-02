package data.structure.bfs;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 4*4 미로에서 출발점(1,1)에서 도착점(4,4)까지로의 경로를 출력하는 프로그램을 작성하십시오.
 * <p>
 * 입력
 * 길을 1, 벽을 0으로 4*4 정사각형 꼴로 입력합니다.
 * 단, 출발점부터 도착점까지의 길은 하나밖에 없습니다.
 * <p>
 * 출력
 * 출발점부터 도착점까지 미로를 헤매지 않고 이동하는 경로를 정사각형 위에 1로 표현
 * <p>
 * 예시
 * <p>
 * 입력
 * 1 1 0 1
 * 0 1 1 1
 * 0 0 0 1
 * 0 1 0 1
 * <p>
 * 출력
 * 1 1 0 0
 * 0 1 1 1
 * 0 0 0 1
 * 0 0 0 1
 * https://level.goorm.io/exam/43131/4x4-%EB%AF%B8%EB%A1%9C%EC%B0%BE%EA%B8%B0/quiz/1
 * <p>
 * bfs나 dfs 알고리즘
 * a*
 * 조건에서 길이 무조건 하나면 좌수법 우수법
 * 다익스트라
 */
//todo Builder로 교체
class Maze {
	int row;
	int col;
	char val;
	boolean visited;

	public Maze() {
	}
}

public class
FourByFourMaze {
	static final int ROWS = 4;
	static final int COLS = 4;
	static Stack<Maze> stack = new Stack();
	static ArrayList<Maze> mazeList = new ArrayList();

	public static void main(String[] args) {
		//		Scanner sc = new Scanner(System.in);

//		String[] strList = { "1 1 0 1", "0 1 1 1", "0 0 0 1", "0 1 0 1" };
		String[] strList = { "1 0 0 0", "1 1 0 0", "0 1 0 0", "0 1 1 1" };

		int row = 0;
		do {
			String str = strList[row].replaceAll(" ", "");
			;
			//			String str = sc.nextLine();
			for (int col = 0; col < COLS; col++) {
				Maze maze = new Maze();
				maze.row = row;
				maze.col = col;
				maze.val = str.charAt(col);
				maze.visited = false;
				mazeList.add(maze);
			}

			row++;
		} while (mazeList.size() < ROWS * COLS);

		find(mazeList.get(0));
	}

	static void find(Maze target) {

		if (CheckType.FIRST.func.apply(target)) {
			target.visited = true;
			stack.push(target);
			find(target);
		} else {
			if (CheckType.LAST.func.apply(target)) {
				print();
			} else {
				for (Maze maze : mazeList) {
					if (CheckType.CARDINAL_POSITION.biFunc.apply(maze, target)) {
						//되돌아왔을때 pop됨
						if (stack.peek() != target) {
							stack.push(target);
						}
						maze.visited = true;
						stack.push(maze);
						find(maze);
					}
				}
				target.visited = true;
				target = stack.pop();
				find(target);
			}
		}
	}

	//Stack을 출력
	static void print() {
		Maze[] stackList = stack.toArray(new Maze[stack.size()]);
		String[][] result = new String[ROWS][COLS];

		for (Maze maze : stackList) {
			result[maze.row][maze.col] = maze.val + " ";
		}

		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (result[i][j] == null) {
					System.out.print("0 ");
				} else {
					System.out.print(result[i][j]);
				}
			}
			System.out.println();
		}
		//todo 재귀를 바꾸든가해야지...
		System.exit(0);
	}

	public enum CheckType {
		FIRST(maze -> maze.row == 0 && maze.col == 0 && maze.visited == false),
		LAST(maze -> maze.row == ROWS - 1 && maze.col == COLS - 1),
		CARDINAL_POSITION((maze, target) -> maze.visited == false && maze.val == '1'
				&& ((target.row == maze.row - 1 && target.col == maze.col)
				|| (target.row == maze.row && target.col == maze.col - 1)
				|| (target.row == maze.row + 1 && target.col == maze.col)
				|| (target.row == maze.row && target.col == maze.col + 1)));

		private Function<Maze, Boolean> func;
		private BiFunction<Maze, Maze, Boolean> biFunc;

		CheckType(Function<Maze, Boolean> func) {
			this.func = func;
		}

		CheckType(BiFunction<Maze, Maze, Boolean> biFunc) {
			this.biFunc = biFunc;
		}
	}
}
