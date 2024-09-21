package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class HelloController {

    @FXML
    private GridPane gridPane;

    private GraphicsContext gc;
    private Canvas canvas;

    private final static int SIZE = 80;
    private final static double CUBE_HEIGHT = 10.0;
    private final static double CUBE_WIDTH = 10.0;
    GameOfLifeLogic gameoflife = new GameOfLifeLogic(SIZE);

    @FXML
    public void initialize() {
        // create canvas and add it to the gridpane
        canvas = new Canvas(SIZE * CUBE_WIDTH, SIZE * CUBE_HEIGHT);
        gridPane.add(canvas, 0, 0);

        // Get the GraphicsContext of the Canvas
        gc = canvas.getGraphicsContext2D();

        // draw the initial grid
        drawGrid();
    }

    // Draws a grid on the Canvas
    private void drawGrid() {
        double cellWidth = canvas.getWidth() / gameoflife.SIZE;
        double cellHeight = canvas.getHeight() / gameoflife.SIZE;

        for (int i = 0; i < gameoflife.SIZE; i++) {
            for (int j = 0; j < gameoflife.SIZE; j++) {
                if (gameoflife.matrix(i, j) == 1) {
                    // If the cell is alive, fill it with color
                    gc.setFill(Color.BLACK);
                    gc.fillRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                } else {
                    // If the cell is dead, clear it (or fill with a different color)
                    gc.setFill(Color.WHITE);
                    gc.fillRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
                }

                //add the outline of every cell
                gc.strokeRect(i * cellWidth, j * cellHeight, cellWidth, cellHeight);
            }
        }
    }

    @FXML
    public void buttonPressed(ActionEvent action) {
        gameoflife.computeNextGen();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        drawGrid();
    }
}
