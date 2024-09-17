package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
public class HelloApplication extends Application{
    public void start(Stage stage) throws Exception{
        Parent root = (Parent)

                FXMLLoader.load(getClass().getResource("hello-view.fxml"));

        Scene scene = new Scene(root, 1080, 1080);
        stage.setTitle("Game Of Life");//title of the window
        stage.setScene(scene);
        stage.setResizable(false);//makes the windows not resizeable
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
        System.out.println();
    }
}
