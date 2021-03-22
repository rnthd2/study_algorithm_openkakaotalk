package leetcode;

import java.util.Arrays;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board1 = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
//        System.out.println(exist(board1, "ABCCE"));
//        System.out.println(exist(board1, "CC"));
//        System.out.println(exist(board1, "SEE"));
//        System.out.println(exist(board1, "SAD"));
//        System.out.println(exist(board1, "BBB"));
//        System.out.println(exist(board1, "BCESA"));
//        System.out.println(exist(board1, "ASDEE"));
//        System.out.println(exist(board1, "CCCCC"));

        char[][] board2 = new char[][]{
                {'C','A','A'},
                {'A','A','A'},
                {'B','C','D'}
        };
//        System.out.println(exist(board2, "AAB"));

        char[][] board3 = new char[][]{
                {'A','B','C','E'},
                {'S','F','E','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(board3, "ABCEFSADEESE"));
    }

    public static boolean exist(char[][] board, String word) {
        for (int x = 0; x < board.length; x++) {
            for (int y = 0; y < board[0].length; y++) {
                if(word.charAt(0) == board[x][y]) {
                    if(solution(arrayCopy(board), word, x, y, 0)){
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    /**
     * 2차원 배열 깊은 복사
     * @param input
     * @return
     */
    public static char[][] arrayCopy(char[][] input) {
        char[][] target = new char[input.length][];
        for (int i=0; i <input.length; i++) {
            target[i] = Arrays.copyOf(input[i], input[i].length);
        }
        return target;
    }

    static boolean solution(char[][] board, String word, int x, int y, int index){
        if(++index >= word.length()){
            return true;
        }

        board[x][y] = '0';
        char c = word.charAt(index);

        //오른쪽
        if(y+1 < board[0].length && board[x][y+1] == c && board[x][y+1] != '0'){
            if(solution(board, word, x, y+1, index)){
                return true;
            }
        }
        //아래
        if(x+1 < board.length && board[x+1][y] == c && board[x+1][y] != '0'){
            if(solution(board, word, x+1, y, index)){
                return true;
            }
        }
        //왼쪽
        if(y-1 > -1 && board[x][y-1] == c && board[x][y-1] != '0'){
            if(solution(board, word, x, y-1, index)){
                return true;
            }
        }
        //위
        if(x-1 > -1 && board[x-1][y] == c  && board[x-1][y] != '0'){
            if(solution(board, word, x-1, y, index)){
                return true;
            }
        }

        return false;
    }
}
