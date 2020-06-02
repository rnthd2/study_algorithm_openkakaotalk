package data.structure.graph;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentSkipListSet;

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
 */
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

	// https://www.youtube.com/watch?v=m6lXDsx7oCk를 참고해서 이래저래 고민해보았지만, 아래 코드로 하면 동떨어진 애들까지 커버할 수 없어서
	// 이 코드안에서는 해결이 안되고 question clone 후 짜넣어야된다
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
