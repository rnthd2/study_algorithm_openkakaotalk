package leetcode;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        char[][] board3 = new char[][]
                {{'1','2','3'}
                ,{'4','5','6'}
                ,{'7','8','9'}};

        char[][] board = new char[][]
                {{'5','3','.','.','7','.','.','.','.'}
                ,{'6','.','.','1','9','5','.','.','.'}
                ,{'.','9','8','.','.','.','.','6','.'}
                ,{'8','.','.','.','6','.','.','.','3'}
                ,{'4','.','.','8','.','3','.','.','1'}
                ,{'7','.','.','.','2','.','.','.','6'}
                ,{'.','6','.','.','.','.','2','8','.'}
                ,{'.','.','.','4','1','9','.','.','5'}
                ,{'.','.','.','.','8','.','.','7','9'}};

        char[][] board2 = new char[][]
                {{'.','.','.','.','5','.','.','1','.'}
                ,{'.','4','.','3','.','.','.','.','.'}
                ,{'.','.','.','.','.','3','.','.','1'}
                ,{'8','.','.','.','.','.','.','2','.'}
                ,{'.','.','2','.','7','.','.','.','.'}
                ,{'.','1','5','.','.','.','.','.','.'}
                ,{'.','.','.','.','.','2','.','.','.'}
                ,{'.','2','.','9','.','.','.','.','.'}
                ,{'.','.','4','.','.','.','.','.','.'}};

        System.out.println(isValidSudoku(board));
    }
    private static final Character EMPTY = '.';
    public static boolean isValidSudoku(char[][] board) {

//        1. Each row must contain the digits 1-9 without repetition.
//        2. Each column must contain the digits 1-9 without repetition.
        Set row = new HashSet();
        Set col = new HashSet();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if((board[i][j] != EMPTY && row.contains(board[i][j]))
                || (board[j][i] != EMPTY && col.contains(board[j][i]))){
                    return false;
                }
                row.add(board[i][j]);
                col.add(board[j][i]);
            }
            row.clear();
            col.clear();
        }

//        3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
        final double SUB_BOXES_LENGTH = Math.sqrt(board.length);
        for (int x = 0; x < board.length; x+=SUB_BOXES_LENGTH) {
            for (int y = 0; y < board.length; y+=SUB_BOXES_LENGTH) {
                if(!isValidSubBoxesOfTheGrid(board, x, y, SUB_BOXES_LENGTH))
                    return false;
            }
        }

        return true;
    }

    static boolean isValidSubBoxesOfTheGrid(char[][] board, int row_start, int col_start, double length){
        Set grid = new HashSet();
        for (int x = row_start; x < row_start+length; x++) {
            for (int y = col_start; y < col_start+length; y++) {
                if((board[x][y] != EMPTY && grid.contains(board[x][y])))
                    return false;
                grid.add(board[x][y]);
            }
        }
        return true;
    }



}
