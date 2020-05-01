package javaFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
        Parent secondPaneLoader = FXMLLoader.load(getClass().getResource("/logIn.fxml"));
        Scene secondScene = new Scene(secondPaneLoader);
        primaryStage.setScene(secondScene);
        primaryStage.setTitle("Welcome to Diagnomonic platform");
        primaryStage.show();
    }
}

