package data.structure.graph;

import java.util.function.BiFunction;
import java.util.function.Function;

public enum CheckType {

	FIRST(maze -> maze.row == 0 && maze.col == 0 && maze.visited == false),
	LAST(maze -> maze.row == Maze.ROWS - 1 && maze.col == Maze.COLS - 1),
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

	public Function<Maze, Boolean> getFunc() {
		return func;
	}

	public BiFunction<Maze, Maze, Boolean> getBiFunc() {
		return biFunc;
	}
}