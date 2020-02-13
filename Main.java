/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package whackamole;

import java.util.*;

/**
 *
 * @author Rashae
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        WhackAMole mole = new WhackAMole(50, 10);
        boolean isPlaying = true;
        Scanner scan = new Scanner(System.in);
        int xCoordinate = 0;
        int yCoordinate = 0;
        mole.molesLeft = 10;

        System.out.println("You have a maximum of 50 attempts to get the moles");
        System.out.println("Please enter numbers from 1 to 10");
        while (isPlaying) {

            if ((mole.attemptsLeft - 1) == 0 || (mole.molesLeft - 1) == 0) {
                isPlaying = false;
            }

            for (int i = 0; i < mole.molesLeft; i++) {
                mole.place();
            }

            System.out.print("Where would you like to whack?(x, y) to quit enter (-1, -1): ");
            xCoordinate = scan.nextInt();
            yCoordinate = scan.nextInt();

            if (xCoordinate == -1 && yCoordinate == -1) {
                isPlaying = false;
            } else {
                mole.whack(xCoordinate, yCoordinate);
                System.out.println();
                mole.printGridToUser();
                mole.clearGrid();
            }

        }
        System.out.println();
        if (mole.attemptsLeft == 0 || xCoordinate == -1 && yCoordinate == -1) {
            System.out.println("Game Over!!");
            mole.printGrid();
            System.out.println("You whacked " + mole.score + " moles");
        } else {
            System.out.println("You Win!!");
            mole.printGrid();
            System.out.println("You whacked all " + mole.score + " moles!!");

        }

    }
}
