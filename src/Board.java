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
        board = new String[sizeOfBoard][sizeOfBoard];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                board[i][j] = " ";
            }
        }
    }

//    public boolean gameOver() {  //finish this.  Check if game is over
//        boolean gameOver = checkForDiagWin();
//        if(gameOver){
//            return gameOver;
//        }
//        for(int x = 0; x < board.length; x++) {  // serach for horizontal win
//            String winner = board[x][0];   // this will only check the left most array, wont work!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//            if(board[x][0].equals(winner) && winner.compareTo(" ") != 0){  // if board != " " and board[x][0] = the begining value 
//               winString = winner;                                          // always comparing something to itself
//               gameOver = true;
//           }else{
//               gameOver = false;
//               break;
//           }
//           return gameOver;
//        }
//        
//         for (int y = 0; y < board.length; y++) {       // check for vertical win
//              String winner = board[0][y];   // this may not be correct
//            if(winner.equals(" ")){
//                gameOver = false;
//                break;
//            }
//           if(board[0][y].equals(winner)){
//               winString = winner;
//               gameOver = true;
//           }else{
//               gameOver = false;
//               break;
//           }
//        }
//        return gameOver;
//    }

    public boolean gameOver(){
        checkForDiagWin();
        boolean gameOver = false;
        int counterVert = 0;
        int counterHor = 0;
        String ID = board[0][0];
        for(int x = 0; x < board.length; x++){
            for(int y = 0; y < board.length; y++){
//                if(ID.equals()){
//                    
//                }
//                if(counterVert == 3){
//                    gameOver = true;
//                    return gameOver;
//                }
                counterVert = 0;
            }
            //System.out.println("x = " + x);
            ID = board[x][0];
        }
        
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
    }

    private boolean checkForDiagWin() {
        String winner = board[0][0];
        if(winner.equals(" ")){
            return false;
        }
        if(board[0][0].equals(winner) && board[1][1].equals(winner) && board[2][2].equals(winner)){          //top left to bottom right.
            winString = winner;
            return true;
        }
        winner = board[0][2];
        if(board[0][2].equals(winner)  && board[1][1].equals(winner) && board[2][0].equals(winner)){
            winString = winner;
        return true;
    }
        return false;
    }
    
    public void printWinner(){
        if(winString.equals(" ")){
            System.out.println("There is a tie!");
        }else{
            System.out.println(winString + " Is the winner!!");
        }
    }
    
    public String[][] getBoard(){
        return board;
    }
}
