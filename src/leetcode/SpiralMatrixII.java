package leetcode;

public class SpiralMatrixII {
    public static void main(String[] args) {
        System.out.println(generateMatrix(4));
    }

    public static int[][] generateMatrix(int n) {
        int [][] matrix = new int[n][n];
        int x = 0;
        int y = 0;
        int value = 1;
        int length = n;
        int limit = n*n;
        while(value <= limit){
            while(y < n && value <= limit){
                matrix[x][y++] = value++;
            }
            ++x;
            --y;
            while(x < n && value <= limit){
                matrix[x++][y] = value++;
            }
            --x;
            --y;
            while(y > (length-(n)-1) && value <= limit){
                matrix[x][y--] = value++;
            }
            --x;
            ++y;
            while(x > (length-(n)) && value <= limit){
                matrix[x--][y] = value++;
            }
            ++x;
            ++y;
            --n;
        }

        return matrix;
    }
}
