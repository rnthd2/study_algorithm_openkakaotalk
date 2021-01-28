package leetcode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1}},1));
        System.out.println(searchMatrix(new int[][]{{0}},1));
        System.out.println(searchMatrix(new int[][]{{1,3}},3));
        System.out.println(searchMatrix(new int[][]{{1,1}},2));
        System.out.println(searchMatrix(new int[][]{{1},{3}},3));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,23,34,60}},13));
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,23,34,60}},34));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        return solution(matrix, target, 0, matrix[0].length-1);
    }
    private static boolean solution(int[][] matrix, int target, int row, int col){
        //matrix 크기가 1이면서 matrix[0]과 target 이 다를 때
        if(matrix.length < 2 && matrix[0].length < 1){
            return false;
        }
        //matrix 범주를 넘어설 때
        if(row >= matrix.length || col < 0){
            return false;
        }
        if(matrix[row][col] == target){
            return true;
        }
        //The first integer of each row is greater than the last integer of the previous row.
        if(target > matrix[row][matrix[0].length-1]){
            return solution(matrix, target, ++row, matrix[0].length-1);
        } else {
            return solution(matrix, target, row, --col);
        }
    }

    private static boolean isaBoolean(int target, int[] matrix2) {
        return Arrays.stream(matrix2).anyMatch(e -> e == target);
    }

    private static int getMatrixNearIndexByTaget(int[][] matrix, int target) {
        return IntStream.range(0, matrix.length)
                .filter(i -> target <= matrix[i][0])
                .findFirst().orElse(-1);
    }
}
