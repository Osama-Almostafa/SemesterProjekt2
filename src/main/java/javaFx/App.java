package javaFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent firstPaneLoader = FXMLLoader.load(getClass().getResource("/logIn.fxml"));
        Scene firstScene = new Scene(firstPaneLoader);
        primaryStage.setScene(firstScene);
        primaryStage.setTitle("Welcome to Diagnomonic platform");
        primaryStage.show();
    }
}

