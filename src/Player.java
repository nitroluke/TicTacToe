
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nitroluke
 * Last modified: 11/5/14
 */
public class Player {

    String ID = null;
    String board[][];

    public Player(Board board, String ID) {
        this.board = board.getBoard();
        this.ID = ID;
    }

    public void computerMove() { // make this smarter sometime.
        boolean isEmpty = true;
        int randX = (int) (Math.random() * board.length);
        int randY = (int) (Math.random() * board.length);
//        System.out.println("randX = " + randX);
//        System.out.println("randY = " + randY);
        while (isEmpty) {
            if (board[randX][randY].equals(" ")) {
                board[randX][randY] = ID;
                System.out.println("the computer put a " + ID + " @ " + randX + "," + randY);
                isEmpty = false;
            } else {
                randX = (int) (Math.random() * board.length);
                randY = (int) (Math.random() * board.length);
            }
        }
    }

    public void humanMove() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a X coordinate from 0 - " + (board.length -1));
        int x = in.nextInt();
//        System.out.println("input x = " + x);
        System.out.println("Please enter a Y coordinate from 0 - " + (board.length-1));
        int y = in.nextInt();
//        System.out.println("input y = " + y);
        if ((x < board.length && x > -1 && y > -1 && y < board.length) && board[x][y].compareTo(" ") == 0) { // if the values are in range and the spot isnt occupied
            board[x][y] = ID;
        } else {
            System.out.println("Your input is dumb, Please enter a valid coordinate");
            humanMove();
        }
    }
}
