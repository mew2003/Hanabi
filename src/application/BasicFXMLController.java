package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BasicFXMLController {

    @FXML
    private Label test;

    public void initialize() {
        // TODO
    }   

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("test");
    }

}
