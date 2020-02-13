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
public class WhackAMole {

    int score;
    int molesLeft;
    int attemptsLeft;
    private char[][] moleGrid;
    private char[][] playerMoleGrid;

    WhackAMole(int numAttempts, int gridDimension) {
        moleGrid = new char[gridDimension][gridDimension];
        playerMoleGrid = new char[gridDimension][gridDimension];
        attemptsLeft = numAttempts;
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid[i].length; j++) {
                moleGrid[i][j] = '*';
                playerMoleGrid[i][j] = '*';
            }
        }
    }

    public void place() {
        Random rand = new Random();
        int positionX = rand.nextInt(10) + 1;
        int positionY = rand.nextInt(10) + 1;
        if (moleGrid[positionX - 1][positionY - 1] != 'M' && moleGrid[positionX - 1][positionY - 1] != 'W') {
            moleGrid[positionX - 1][positionY - 1] = 'M';

        } else {

            place();
        }

    }

    public void whack(int x, int y) {
        if (moleGrid[x - 1][y - 1] == 'M') {
            moleGrid[x - 1][y - 1] = 'W';
            playerMoleGrid[x - 1][y - 1] = 'W';
            attemptsLeft--;
            score++;
            molesLeft--;
        } else {
            attemptsLeft--;
        }
    }

    public void printGridToUser() {
        for (char[] arr : playerMoleGrid) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public void printGrid() {

        for (char[] arr : moleGrid) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public void clearGrid() {
        for (int i = 0; i < moleGrid.length; i++) {
            for (int j = 0; j < moleGrid[i].length; j++) {
                if (moleGrid[i][j] == 'M') {
                    moleGrid[i][j] = '*';
                }

            }
        }
    }
}
