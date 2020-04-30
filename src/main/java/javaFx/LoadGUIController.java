package javaFx;

import database.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.List;

public class LoadGUIController {

    public Button søg;
    public TextField idField;
    public TextArea TempLoad;

    public void LoadData(ActionEvent actionEvent) {

        int id;
        id = Integer.parseInt(idField.getId());
        TempDAO tempDAO = new TempDAOImpl();
        List<TempDTO> tempData = tempDAO.load(id);
        String text = "";
        for (TempDTO data : tempData) {
            text += "ID: " + data.getId() + ", Time: " + data.getTid() + ", WindSpeed: " + data.getTemp() + "\r\n";
        }
        TempLoad.setText(text);
    }
}
