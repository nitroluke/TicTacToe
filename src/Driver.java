
import java.util.Scanner;
/**
 * This is a Driver for Outlab 5.  It controls the execution of a 
 * tic-tac-toe game.
 * 
 * @author Luke Welna
 * @Last modified: 11/17/14
 */
public class Driver
{
    public static void main(String[] args)
    {
        Scanner in;
        //new tic-tac-toe board
        Board board = new Board();
        board.print();
        //two new players (conputer and human)
        Player computer = new Player(board, "X");   //Give computer player access to board and assign as X.
        Player human = new Player(board, "O");      //Give human player access to board and assign as O.

        //while the game is not over
        while(!board.gameOver()){
            //let computer move first
            computer.computerMove(); 
            //print tic-tac-toe board
            board.print();  
            //if the game is not over yet
            if (!board.gameOver()){
                //let the human make a move
                human.humanMove();
            }
            if(board.gameOver()){
               
            }
        } 
        
        //print out the winner (if there is one) of the game
        board.print();
        board.printWinner();
    }
}