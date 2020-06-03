package data.structure.graph;

import java.util.ArrayList;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.Function;

//DFS 풀이
class StackMaze extends Maze{
	int row;
	int col;
	char val;
	boolean visited;
}
public class FourByFourMazeStack extends Maze{
	static Stack<StackMaze> stack = new Stack();
	static ArrayList<StackMaze> mazeList = new ArrayList();

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
				StackMaze maze = new StackMaze();
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

	static void find(StackMaze target) {

		if (CheckType.FIRST.getFunc().apply(target)) {
			target.visited = true;
			stack.push(target);
			find(target);
		} else {
			if (CheckType.LAST.getFunc().apply(target)) {
				print();
			} else {
				for (StackMaze maze : mazeList) {
					if (CheckType.CARDINAL_POSITION.getBiFunc().apply(maze, target)) {
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
		StackMaze[] stackList = stack.toArray(new StackMaze[stack.size()]);
		String[][] result = new String[ROWS][COLS];

		for (StackMaze maze : stackList) {
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
}

enum CheckType {

	FIRST(maze -> maze.row == 0 && maze.col == 0 && maze.visited == false),
	LAST(maze -> maze.row == Maze.ROWS - 1 && maze.col == Maze.COLS - 1),
	CARDINAL_POSITION((maze, target) -> maze.visited == false && maze.val == '1'
			&& ((target.row == maze.row - 1 && target.col == maze.col)
			|| (target.row == maze.row && target.col == maze.col - 1)
			|| (target.row == maze.row + 1 && target.col == maze.col)
			|| (target.row == maze.row && target.col == maze.col + 1)));

	private Function<StackMaze, Boolean> func;
	private BiFunction<StackMaze, StackMaze, Boolean> biFunc;

	CheckType(Function<StackMaze, Boolean> func) {
		this.func = func;
	}

	CheckType(BiFunction<StackMaze, StackMaze, Boolean> biFunc) {
		this.biFunc = biFunc;
	}

	public Function<StackMaze, Boolean> getFunc() {
		return func;
	}

	public BiFunction<StackMaze, StackMaze, Boolean> getBiFunc() {
		return biFunc;
	}
}
