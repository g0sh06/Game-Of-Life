package com.example.demo;

import java.util.Random;

public class GameOfLifeLogic {

    public final int SIZE;
    private static final int ALIVE = 1;
    private static final int DEAD = 0;
    private int[][] currentMatrix;
    private int[][] evolvementMatrix;

    public GameOfLifeLogic(int size) {
        SIZE = size;
        currentMatrix = new int [SIZE][SIZE];
        evolvementMatrix = new int [SIZE][SIZE];
        Random rand = new Random();
        int randomValue;
        for(int i = 0; i < SIZE; i++) {
            for (int k = 0; k < SIZE; k++) {
                randomValue = rand.nextInt(5);
                currentMatrix[i][k] = randomValue;
            }
        }
    }

    public int matrix(int i, int j) {
        return currentMatrix[i][j];
    }
}
