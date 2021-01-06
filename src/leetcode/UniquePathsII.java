package leetcode;

public class UniquePathsII {

    public static void main(String[] args) {
//        int[][] array = new int[][]{{0,0,0},{0,1,0},{0,0,0}};
//        int[][] array = new int[][]{{0,1},{0,0}};
        int[][] array = new int[][]{{0,0},{1,1},{0,0}};
        System.out.println(uniquePathsWithObstacles(array));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return 0;
    }

    static int count;
    static void test(int[][] obstacleGrid, int i, int j){
        if(i==obstacleGrid.length && j==obstacleGrid[0].length){
            count++;
        } else {
            test(obstacleGrid, i++, j++);
        }
    }
}
