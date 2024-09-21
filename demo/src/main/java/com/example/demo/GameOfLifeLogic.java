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
        currentMatrix = new int[SIZE][SIZE];
        evolvementMatrix = new int[SIZE][SIZE];
        int randomValue = 0;
        initializeMatrix(randomValue);
    }

    public void initializeMatrix(int randomValue) {
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                randomValue = rand.nextInt(2); // Generates 0 or 1
                currentMatrix[i][k] = randomValue;
            }
        }
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
        if (cols - 1 >= 0 && rows - 1 >= 0 && cols + 1 < SIZE && rows + 1 < SIZE) {
            neighbors += evolvementMatrix[cols - 1][rows - 1];
            neighbors += evolvementMatrix[cols][rows - 1];
            neighbors += evolvementMatrix[cols + 1][rows - 1];
            neighbors += evolvementMatrix[cols + 1][rows];
            neighbors += evolvementMatrix[cols + 1][rows + 1];
            neighbors += evolvementMatrix[cols][rows + 1];
            neighbors += evolvementMatrix[cols - 1][rows + 1];
            neighbors += evolvementMatrix[cols - 1][rows];
        }
        return neighbors;
    }

    public void computeNextGen() {
        copyLifeMat();
        for (int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                // Make sure the indices are within bounds
                neighbors = 0;
                neighbors = countNeighbors(i, k);
                if (currentMatrix[i][k] == ALIVE) {
                    if (neighbors == 2 || neighbors == 3) {
                        currentMatrix[i][k] = 1;
                    }
                    if (neighbors < 2 || neighbors > 3) {
                        currentMatrix[i][k] = 0;
                    }
                } else if (currentMatrix[i][k] == DEAD) {
                    if (neighbors == 3) {
                        currentMatrix[i][k] = 1;
                    }
                }
            }
        }
    }

    private void copyLifeMat() {//copies lifeMatrix to copyMatrix
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                evolvementMatrix[i][j] = currentMatrix[i][j];
            }
        }
    }

    public int matrix(int i, int j) {
        return currentMatrix[i][j];
    }
}