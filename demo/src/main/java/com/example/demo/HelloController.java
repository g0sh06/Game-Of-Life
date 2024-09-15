package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;

public class HelloController {

    @FXML
    private GridPane gridPane;

    private GraphicsContext gc;
    private Canvas canvas;

    private final static int SIZE = 50;
    private final static double CUBE_HEIGHT = 15.0;
    private final static double CUBE_WIDTH = 15.0;

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
    public void drawGrid() {
        // Clear the canvas before drawing
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        // Draw the grid
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                // Calculate the x and y positions based on row and column
                double x = row * CUBE_WIDTH;
                double y = col * CUBE_HEIGHT;

                // Draw the outline of the cube
                gc.strokeRect(x, y, CUBE_WIDTH, CUBE_HEIGHT);

                // Optionally, fill the cube (you can remove this if you don't want it filled)
                //gc.fillRect(x, y, CUBE_WIDTH, CUBE_HEIGHT);
            }
        }
    }
}
