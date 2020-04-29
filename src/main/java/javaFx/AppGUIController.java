package javaFx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sensor.*;
import database.*;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Scanner;

public class AppGUIController implements tempListener {

    public Button sB;
    public Button login2;
    public Button back;
    public Label tempLabel;

    public TempDAO tempDAO = new TempDAOImpl();
    public TempDTO tempDTO = new TempDTO();
    public TextField cpr;

    public void inform(final double temp) {

        Scanner scanner = new Scanner(System.in);
        String cpr = scanner.next();
        tempDTO.setCpr(cpr);
        tempDTO.setTid(new Timestamp());
        tempDAO.save(new TempDTO(temp, new Date().toString()));
        Platform.runLater(new Runnable() {
            public void run() {
                tempLabel.setText(String.valueOf(temp));
            }
        });
    }

    public void temp(ActionEvent actionEvent) {
        Sensor sensor = new Sensor();
        new Thread(sensor).start();
        sensor.registerObserver(this);
    }

    public void SPressed(ActionEvent actionEvent) throws IOException {
        Parent secondPaneLoader = FXMLLoader.load(getClass().getResource("/logIn2.fxml"));
        Scene secondScene = new Scene(secondPaneLoader);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(secondScene);
        primaryStage.setTitle("Nem-id");
        primaryStage.show();
    }

    public void search(ActionEvent actionEvent) throws IOException {
        Parent theardPaneLoader = FXMLLoader.load(getClass().getResource("/searchD.fxml"));
        Scene theardScene = new Scene(theardPaneLoader);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(theardScene);
        primaryStage.setTitle("Search");
        primaryStage.show();
    }

    public void patientFolder(ActionEvent actionEvent) throws IOException {
        Parent fourthPaneLoader = FXMLLoader.load(getClass().getResource("/patientFolder.fxml"));
        Scene fourthScene = new Scene(fourthPaneLoader);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(fourthScene);
        primaryStage.setTitle("Patient's folder");
        primaryStage.show();
    }

    public void back(ActionEvent actionEvent) throws IOException {
        Parent firstPaneLoader = FXMLLoader.load(getClass().getResource("/logIn1.fxml"));
        Scene firstScene = new Scene(firstPaneLoader);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(firstScene);
        primaryStage.setTitle("Welcome to Diagnomonic platform");
        primaryStage.show();
    }
}







