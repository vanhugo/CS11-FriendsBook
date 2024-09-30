package com.example.friendsbook;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.application.Application;

import java.io.IOException;

public class FBApplication extends Application {
    // override the start method, which is the entry point for the JavaFX application
    @Override
    public void start(Stage stage) throws IOException {
        // load the fxml file using FXMLLoader
        FXMLLoader fxmlLoader = new FXMLLoader(FBApplication.class.getResource("hello-view.fxml"));
        // create a scene with the loaded fxml, and set its dimensions (width: 400, height: 300)
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        // set the title of the application window
        stage.setTitle("Hello!");
        // set the scene to the stage
        stage.setScene(scene);
        // display the stage
        stage.show();
    }

    // main method to launch the JavaFX application
    public static void main(String[] args) {
        launch();
    }
}
