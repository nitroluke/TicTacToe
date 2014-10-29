
import java.util.Scanner;


/**
 * This is a Driver for Outlab 5.  It controls the execution of a 
 * tic-tac-toe game.
 * 
 * @author yaw
 * @version 17 Oct 2014
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
        while(!board.gameOver())
        {
            //let computer move first
            computer.computerMove();
            
            //print tic-tac-toe board
            board.print();
            
            //if the game is not over yet
            if (!board.gameOver())
            {
                //let the human make a move
                human.humanMove();
 
            }else{  // the game is over
                boolean correctInput = false;
                while(!correctInput){
               in = new Scanner(System.in);
                System.out.println("Would you like to play another game? Enter y/n > ");
                String input = in.next();
                if(input.equals("y")){
                    board = new Board();
                    board.print();
                    //two new players (conputer and human)
                    computer = new Player(board, "X");   //Give computer player access to board and assign as X.
                    human = new Player(board, "O");      //Give human player access to board and assign as O.
                    board.gameOver();
                    correctInput = true;
                }else if(input.equals("n")){
                    System.exit(0);
                }else{
                    correctInput = false;
                }
            }  
            }
        } 
        
        //print out the winner (if there is one) of the game
        board.print();
        board.printWinner();
    }
}