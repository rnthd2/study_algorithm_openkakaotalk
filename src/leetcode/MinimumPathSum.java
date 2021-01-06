package leetcode;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] array = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
//        int[][] array = new int[][]{{1, 2},{1, 1}};
//        int[][] array = new int[][]{{0, 0},{0, 0}};
        System.out.println(minPathSum(array));
    }
    static int [][] dp;

    public static int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        dp=new int[rows][cols];
        Integer.MAX_VALUE
        return solution(grid, rows-1, cols-1);

    }

    static int solution(int[][] grid, int rows, int cols){
        if(rows==0 && cols==0) return grid[0][0];
        if (dp[rows][cols] != 0) return dp[rows][cols];
        if(rows==0) {
            dp[rows][cols] = grid[rows][cols] + solution(grid, rows, cols-1);
            return dp[rows][cols];
        }
        if(cols==0){
            dp[rows][cols] = grid[rows][cols] + solution(grid, rows-1, cols);
            return dp[rows][cols];
        }
        dp[rows][cols] = grid[rows][cols] + Math.min(solution(grid,rows-1,cols), solution(grid,rows,cols-1));
        return dp[rows][cols];
    }

}
