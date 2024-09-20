package com.example.demo;

import java.util.Random;

public class GameOfLifeLogic {

    public final int SIZE;
    private static final int ALIVE = 1;
    private static final int DEAD = 0;
    private int[][] currentMatrix;
    private int[][] evolvementMatrix;
    public int neighbors;

    public GameOfLifeLogic(int size) {
        SIZE = size;
        currentMatrix = new int [SIZE][SIZE];
        evolvementMatrix = new int [SIZE][SIZE];
        int randomValue = 0;
        initializeMatrix(randomValue);
        computeNextGen();
    }

    public void initializeMatrix(int randomValue) {
        Random rand = new Random();
        for(int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                randomValue = rand.nextInt(8);
                currentMatrix[i][k] = randomValue;
            }
        }
    }

    public int matrix(int i, int j) {
        return currentMatrix[i][j];
    }

    public void allNeighbors() {
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                // Make sure the indices are within bounds
                if (i - 1 >= 0 && k - 1 >= 0 && i + 1 < SIZE && k + 1 < SIZE) {
                     countNeighbors(i, k); // Or handle boundary conditions properly inside countNeighbors()
                }
            }
        }
    }

    public int countNeighbors(int cols, int rows) {
        neighbors = 0;
        neighbors += currentMatrix[cols - 1][rows - 1];
        neighbors += currentMatrix[cols][rows - 1];
        neighbors += currentMatrix[cols + 1][rows - 1];
        neighbors += currentMatrix[cols + 1][rows];
        neighbors += currentMatrix[cols + 1][rows + 1];
        neighbors += currentMatrix[cols][rows + 1];
        neighbors += currentMatrix[cols - 1][rows + 1];
        neighbors += currentMatrix[cols - 1][rows];
        return neighbors;
    }

    public void computeNextGen() {
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                // Make sure the indices are within bounds
                if (i - 1 >= 0 && k - 1 >= 0 && i + 1 < SIZE && k + 1 < SIZE) {
                    countNeighbors(i, k);
                    evolvementMatrix[i][k] = currentMatrix[i][k];
                    if(evolvementMatrix[i][k] == 0 && countNeighbors(i, k) == 3) {
                        evolvementMatrix[i][k] = 1;
                    }

                }
            }
        }
    }

}