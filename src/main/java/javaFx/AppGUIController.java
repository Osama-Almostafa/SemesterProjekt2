package javaFx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sensor.*;
import database.*;

import java.io.IOException;

public class AppGUIController implements tempListener {

    public Button sB;
    public Button login2;
    public Button back;
    public Button load;
    public Label tempLabel;
    public TextField cpr;
    public TextArea TempDataOutput;

    public TempDAO tempDAO = new TempDAOImpl();

    public void inform(final TempDTO tempDTO) {
        Platform.runLater(new Runnable() {
            public void run() {
                tempLabel.setText(String.valueOf(tempDTO.getTemp()));
                String text = TempDataOutput.getText();
                text += "New Data! Temp:" + tempDTO.getTemp()+ " °C"+", TimeStamp: " + tempDTO.getTid() + "\r\n";
                TempDataOutput.setText(text);
            }
        });
        TempDTO saveDTO = new TempDTO();
        saveDTO.setId(Integer.parseInt(cpr.getText()));
        saveDTO.setTemp(tempDTO.getTemp());
        saveDTO.setTid(tempDTO.getTid());
        tempDAO.save(saveDTO);
    }

    public void temp(ActionEvent actionEvent) {
        Sensor sensor = new Sensor();
        new Thread(sensor).start();
        sensor.register(this);
    }

    public void SPressed(ActionEvent actionEvent) throws IOException {
        Parent secondPaneLoader = FXMLLoader.load(getClass().getResource("/logIn2.fxml"));
        Scene secondScene = new Scene(secondPaneLoader);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(secondScene);
        primaryStage.setTitle("Nem-id");
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

    public void load(ActionEvent actionEvent) throws IOException {
        Parent fifthPaneLoader = FXMLLoader.load(getClass().getResource("/Load.fxml"));
        Scene fifthScene = new Scene(fifthPaneLoader);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(fifthScene);
        primaryStage.setTitle("Data Base");
        primaryStage.show();
    }
}







