package javaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import database.*;

import java.io.IOException;
import java.util.List;

public class LoadGUIController {

    public Button søg;
    public Button back;
    public TextField idField;
    public TextArea TempLoad;

    public void LoadData(ActionEvent actionEvent) {

        int id = Integer.parseInt(idField.getText());
        TempDAO tempDAO = new TempDAOImpl();
        List<TempDTO> tempData = tempDAO.load(id);
        String text = "";
        for (TempDTO data : tempData) {
            text += "ID: " + data.getId() + ", Time: " + data.getTid() + ", Temperature: " + data.getTemp() + " °C" + "\r\n";
        }
        TempLoad.setText(text);
    }

    public void patientFolder(ActionEvent actionEvent) throws IOException {
        Parent secondPaneLoader = FXMLLoader.load(getClass().getResource("/patientFolder.fxml"));
        Scene secondScene = new Scene(secondPaneLoader);
        Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        primaryStage.setScene(secondScene);
        primaryStage.setTitle("Patient's folder");
        primaryStage.show();
    }
}
