package GraphAlgorithms;

import java.util.PriorityQueue;
import java.util.Queue;

public class MineSweeper {

    private static int checkBoard(char[][] board, int row, int col){
        int count = 0;
        for(int r = -1 ; r < 2 ; r++ ){
            for(int c = -1 ; c < 2 ; c++){
                int newRow = row + r;
                int newCol = col + c;
                if(newRow < board.length && newRow > -1 && newCol < board[0].length && newCol > -1 && board[newRow][newCol]=='M'){
                    count++;
                }
            }
        }

        return count;
    }

    private static char[][] updateBoard(char[][] board , int row , int col){


        if(board[row][col] != 'E' && board[row][col]!='M'){

            return board;
        }
        if(board[row][col]=='M'){
            board[row][col] ='X';
            return board;
        }
        else{
            int countMines= checkBoard(board,row,col);

            if(countMines>0){
                board[row][col] = Integer.toString(countMines).charAt(0);
            }
            else{

                board[row][col] = 'B';
                if(row+1 < board.length) updateBoard(board,row+1,col);
                if(row-1 > -1) updateBoard(board,row-1,col);
                if(col+1 < board[0].length) updateBoard(board,row,col+1);
                if(col-1 > -1) updateBoard(board,row,col-1);
                if(row+1 < board.length && col+1 < board[0].length) updateBoard(board,row+1,col+1);
                if(row+1 < board.length && col-1 > -1) updateBoard(board,row+1,col-1);
                if(row-1 > -1 && col+1 < board[0].length)  updateBoard(board,row-1,col+1);
                if(row-1 > -1 && col-1 > -1)  updateBoard(board,row-1,col-1);
            }
        }
        return board;
    }

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                            {'E', 'E', 'M', 'E', 'E'},
                            {'E', 'E', 'E', 'E', 'E'},
                             {'E', 'E', 'E', 'E', 'E'}};

        int[] click = {1,2};

        char[][] b = updateBoard(board,click[0], click[1]);

        for(char[]i : board){
            for(char j : i){
                System.out.printf(" %c ", j);
            }
            System.out.println();
        }

    }
}
