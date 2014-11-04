
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author nitroluke
 */
public class Board {
    private int sizeOfBoard = 3;
    public String board[][];
    private String winString = " ";

    public Board() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size of the board you would like to play on> \n");
        sizeOfBoard = in.nextInt();
        
        board = new String[sizeOfBoard][sizeOfBoard];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = " ";
            }
        }
    }

    public boolean gameOver(){
        boolean gameOver;
//        System.out.println("checkForDiagWin");
        gameOver = checkForDiagWin();
        if(gameOver){
            return gameOver;
        }
//        System.out.println("CheckForHorizontalWin");
        gameOver = checkForHorizontalWin();
        if(gameOver){
            return gameOver;
        }
//        System.out.println("CheckforVerticalWin");
        gameOver = checkForVerticalWin();
        return gameOver;
    }
    
    public void print() {
        System.out.println("_______");
        for (int x = 0; x < board.length; x++) {
            System.out.print("|");
            for (int y = 0; y < board.length; y++) {
                System.out.print(board[x][y] + "|");
            }
            System.out.println("");
        }
        System.out.println("");
    }

//    private boolean checkForDiagWin() {         //make this dynamic soon
//        String winner = board[1][1];            // check diag against board[1][1]
//        if(winner.equals(" ")){                 // if board[1][1] = " " neither top left to bottom right or bottom left to bottom right will be 3 in a row 
//            return false;
//        }else if(board[0][0].equals(winner) && board[1][1].equals(winner) && board[2][2].equals(winner)){          //top left to bottom right.
//            winString = winner;
//            return true;
//        }else if(board[0][2].equals(winner)  && board[1][1].equals(winner) && board[2][0].equals(winner)){        // bottom left to top right
//            winString = winner;
//            return true;
//        }else{
//            return false;
//        }
//    }
    
    public boolean checkForDiagWin(){
        String winner = board[0][0];
        int counter = 0;
        if(winner.equals(" ")){
            return false;
        }
        String ID = board[0][board.length - 1];
        int j = board.length - 1;
        for(int i = 0; i < board.length; i++){          //bottom left to top right
            
                if(board[i][j].equals(" ")){  // may need to be optimized
                    j--;
                    break;
                }
                if(ID.equals(board[i][j])){
                    j--;
                    counter++;
                }else{
                    j--;
                    break;
                }
                if(counter == board.length){
                    winString = ID;
                    return true;
                }
            }
        
        
        counter = 0;        //reset counter
        ID = board[0][0];   // to check the diagonal squares against
        for(int i = 0; i < board.length; i++){              //top left to bottom right
            
            if(board[i][i].equals(" ")){
                    break;
                }
                if(ID.equals(board[i][i])){
                    counter++;
                }else{
                    break;
                }
                if(counter == board.length){
                    winString = ID;
                    return true;
                }
        }
        return false;           //no win was found
        }
    
    public void printWinner(){
        System.out.println("Game Over!");
        if(winString.equals(" ")){
            System.out.println("Cat Game!");
        }else{
            System.out.println(winString + " Is the winner!!");
        }
    }
    
    public String[][] getBoard(){
        return board;
    }

    private boolean checkForHorizontalWin() {
        String ID = " ";
        int counter = 0;
        for(int x = 0; x < board.length; x++){
            ID = board[x][0];                           // ID = the first row [0][0], [1][0], and [2][0]
            //fist column me board[0][x]
            for(int y = 0; y < board.length; y++){
                // to check columns just check board[y][x]
                if(ID.equals(" ")){
                    break;
                }
                if(ID.equals(board[x][y])){            // compares the ID(first value in the row) to board[x][y] if they are equal...
                    counter++;                          // increment the counter
                }else{                                 // if they arent, no need to stay in the loop.  Break out of the inner loop
                    break;
                }
                if(counter == board.length){
                    winString = ID;
                    return true;
                }
            }  
            counter = 0;
        }
        return false;  // a horizontal win was not found
    }

    private boolean checkForVerticalWin() {             // combine this and checkForHorWin()
        String ID = " ";
        int counter = 0;
        for(int y = 0; y < board.length; y++){
            ID = board[0][y];                           // ID = the first column [0][1], [0][1], and [0][2]
            for(int x = 0; x < board.length; x++){
                if(ID.equals(" ")){
                    break;
                }
                if(ID.equals(board[x][y])){            // compares the ID(first value in the column) to board[x][y] if they are equal...
                    counter++;                          // increment the counter
                }else{                                 // if they arent, no need to stay in the loop.  Break out of the inner loop
                    break;
                }
                if(counter == board.length){
                    winString = ID;
                    return true;
                }
            }  
            counter = 0;
        }
        return false;  // a vertical win was not found
    }
}
