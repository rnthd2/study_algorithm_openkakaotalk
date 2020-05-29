import java.util.HashMap;
import java.util.Scanner;

/**
 * 4*4 미로에서 출발점(1,1)에서 도착점(4,4)까지로의 경로를 출력하는 프로그램을 작성하십시오.
 *
 * 입력
 * 길을 1, 벽을 0으로 4*4 정사각형 꼴로 입력합니다.
 * 단, 출발점부터 도착점까지의 길은 하나밖에 없습니다.
 *
 * 출력
 * 출발점부터 도착점까지 미로를 헤매지 않고 이동하는 경로를 정사각형 위에 1로 표현
 *
 * 예시
 *
 * 입력
 * 1 1 0 1
 * 0 1 1 1
 * 0 0 0 1
 * 0 1 0 1
 *
 * 출력
 * 1 1 0 0
 * 0 1 1 1
 * 0 0 0 1
 * 0 0 0 1
 * https://level.goorm.io/exam/43131/4x4-%EB%AF%B8%EB%A1%9C%EC%B0%BE%EA%B8%B0/quiz/1
 *
 * bfs나 dfs 알고리즘
 * a*
 * 조건에서 길이 무조건 하나면 좌수법 우수법
 * 다익스트라
 */
//todo Builder로 교체
class Maze{
	static int row;
	static int col;
	static int val;
	static boolean visited;
}
public class FourByFourMaze {
	static final int ROWS = 4;
	static final int COLS = 4;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNextLine()){
			String str = sc.nextLine();
			for (int i = 0; i < ROWS; i++) {
				for (int j = 0; j < COLS; j++) {
					Maze.val = str.charAt(j);
					Maze.row = i;
					Maze.col = j;
					Maze.visited = false;
				}
			}
		}
	}

	//stack의 방법으로...
	int[][] usingStack(Maze maze){
		if(maze.val != 0 && (maze.row != ROWS-1 && maze.col != COLS-1) && !maze.visited){
			
		}
	}
}
