package javaFx;

import database.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class LoadGUIController {

    public Button søg;
    public TextField idField;
    public TextArea TempLoad;
    public Button back;

    public void LoadData(ActionEvent actionEvent) {

        int id;
        id = Integer.parseInt(idField.getText());
        TempDAO tempDAO = new TempDAOImpl();
        List<TempDTO> tempData = tempDAO.load(id);
        String text = "";
        for (TempDTO data : tempData) {
            text += "ID: " + data.getId() + ", Time: " + data.getTid() + ", Temperature: " + data.getTemp() + " °C" + "\r\n";
        }
        TempLoad.setText(text);
        System.out.println("Oraale");
    }

    public void patientFolder(ActionEvent actionEvent) throws IOException {
        Parent fourthPaneLoader = FXMLLoader.load(getClass().getResource("/patientFolder.fxml"));
        Scene fourthScene = new Scene(fourthPaneLoader);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(fourthScene);
        primaryStage.setTitle("Patient's folder");
        primaryStage.show();
    }
}
