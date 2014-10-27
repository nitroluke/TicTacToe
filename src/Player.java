
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
public class Player {

    String ID = null;
    String board[][];

    public Player(Board board, String ID) {
        this.board = board.getBoard();
        this.ID = ID;
    }

    public void computerMove() {
        boolean isEmpty = true;
        int randX = (int) (Math.random() * 3);
        int randY = (int) (Math.random() * 3);
        System.out.println("randX = " + randX);
        System.out.println("randY = " + randY);
        while (isEmpty) {
            if (board[randX][randY].equals(" ")) {
                board[randX][randY] = ID;
                isEmpty = false;
            } else {
                randX = (int) (Math.random() * 3);
                randY = (int) (Math.random() * 3);
            }
        }
    }

    public void humanMove() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter a X coordinate from 0 " + board.length);
        int x = in.nextInt();
        System.out.println("input x = " + x);
        System.out.println("Please enter a Y coordinate from 0 - " + board.length);
        int y = in.nextInt();
        System.out.println("input y = " + y);
        if (x < 3 && x > -1 && y > -1 && y < 3) {
            board[x][y] = ID;
        } else {
            System.out.println("Your input is fucking dumb");
            humanMove();
        }
    }
}
