package javaFx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application { // Her oprettes en klasse der arver fra Application klassen.

    public static void main(String[] args) {
        launch(args);
    } // den arvet metode bliver kørt i main

    @Override // omskrivning af stam metode start

    public void start(Stage primaryStage) throws IOException { //
        Parent firstPaneLoader = FXMLLoader.load(getClass().getResource("/logIn.fxml")); // Her oprettes en parent
        // som bliver hentede fra filen logIn.fxml
        Scene firstScene = new Scene(firstPaneLoader); // oprettes en scene og parent/pane sættes ind
        primaryStage.setScene(firstScene); // her sættes der scenen i stage
        primaryStage.setTitle("Welcome to Diagnomonic platform"); // her sætter man titlen
        primaryStage.show(); // vises stagen.
    }
}

