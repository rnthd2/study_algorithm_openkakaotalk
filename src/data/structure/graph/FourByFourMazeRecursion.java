package data.structure.graph;

public class FourByFourMazeRecursion {

	static final int ROWS = 4;
	static final int COLS = 4;

	static final int NOTPATH = 0;
	static final int PATH = 1;
	static final int EXIT = 2;
	static final int VISITED = 2;

	static Integer[][] question = new Integer[ROWS][COLS];
	static Integer[][] result= new Integer[ROWS][COLS];

	public static void main(String[] args) {

//		String[] strList = { "1 1 0 1", "0 1 1 1", "0 0 0 1", "0 1 0 1" };
		String[] strList = { "1 0 0 0", "1 1 0 0", "0 1 0 0", "0 1 1 1" };

		int row = 0;
		do {
			String str = strList[row].replaceAll(" ", "");
			for (int col = 0; col < COLS; col++) {
				question[row][col] = Integer.valueOf(String.valueOf(str.charAt(col)));
			}
			row++;
		} while (question[ROWS-1][COLS-1]==null);

		findPath(0, 0);

		for (int i = 0; i < question.length; i++) {
			for (int j = 0; j < question.length; j++) {
				System.out.print(((question[i][j] != NOTPATH)? PATH : NOTPATH) + " ");
			}
			System.out.println();
		}
	}

	// https://www.youtube.com/watch?v=m6lXDsx7oCk를 참고해서 이래저래 고민해보았지만,
	// 아래 코드로 하면 동떨어진 애들까지 커버할 수 없어서 이 코드안에서는 해결이 안되고 visited한걸 출력 때 정리한다
	static boolean findPath(int row, int col) {
		if (row < 0 || col < 0 || row >= ROWS || col >= COLS) {
			return false; //is wall
		} else if (question[row][col] != PATH) {
			return false; // not path(visited, wall, block)
		} else if (row == ROWS - 1 && col == COLS - 1) {
			question[row][col] = EXIT;
			return true;
		} else {
			question[row][col] = VISITED;
			if(findPath(row-1, col) || findPath(row,col+1) || findPath(row+1,col) || findPath(row,col-1)){
				return true;
			}
			question[row][col] = NOTPATH;
			return false;
		}
	}

}
