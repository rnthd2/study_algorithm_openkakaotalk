package data.structure.graph;

//BFS 풀이
public class FourByFourMazeQueue extends Maze {

	static Integer[][] question = new Integer[ROWS][COLS];
	static FourByFourMazeQueueFunction queue = new FourByFourMazeQueueFunction(ROWS*COLS);


	static final int NOT_PATH = 0;
	static final int PATH = 1;
	static final int VISITED = -1;

	public static void main(String[] args) {
		String[] strList = { "1 0 0 0", "1 1 0 0", "0 1 0 0", "0 1 1 1" };
//				String[] strList = { "1 1 0 1", "0 1 1 1", "0 0 0 1", "0 1 0 1" };

		int row = 0;

		//todo 인입값 중복제거 필요
		do {
			String str = strList[row].replaceAll(" ", "");
			for (int col = 0; col < COLS; col++) {
				question[row][col] = Integer.valueOf(String.valueOf(str.charAt(col)));
			}
			row++;
		} while (question[ROWS - 1][COLS - 1] == null);

		int _row = 0;
		int col = 0;
		question[0][0]*=VISITED;

		//queue에 값과 배열위치가 함께 저장되어야만 한다
		queue.push(question[0][0]);
		queue.setRow(0);
		queue.setCol(0);

		while(queue.size() > 0){
			findPath(queue.getRow(), queue.getCol());
		}

	}
	static boolean findPoint(int row, int col){
		if(row-1 >= 0 && col-1 >= 0 && row < ROWS && col <COLS) {
			return false;
		} else if (question[row][col] > 0){
			queue.push(question[row][col]);
			queue.setRow(row);
			queue.setCol(col);
			return true;
		} else {
			return false;
		}
	}
	static void findPath(int row, int col){
		queue.pop();

		//아직 방문하지 않고 path인경우 push
		findPoint(row-1, col);
		findPoint(row, col+1);
		findPoint(row+1, col);
		findPoint(row, col-1);

		if(row == ROWS-1 && col == COLS-1) {
			queue.pop();
		}
	}









//todo 아..... 다시다시
	/*boolean findPath(int row, int col) {
		if(question[row][col] == PATH){
			question[row][col] = VISITED;
			queue.add(question[row][col]);
			return true;
		} else if (question[row][col] == VISITED) {
			question[row][col] = PATH;
			return false;
		} else if (row == 0 && col == 0 && question[row][col] != VISITED) {
			question[0][0] = VISITED;
			queue.add(question[0][0]);
			return true;
		} else if (row < 0 || col < 0 || row >= ROWS || col >= COLS) {
			return false;
		} else if (row == ROWS-1 && col == COLS-1) {
			return true; // end
		} else {
			int position = queue.getFirst();
			queue.remove();
			if(findPath(row-1, col) || findPath(row,col+1) || findPath(row+1,col) || findPath(row,col-1)) {
				return true;
			}
			return false;
		}

	}*/

}
