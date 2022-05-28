package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Controller {


    public void initialize() {
        // TODO
    }
    
    public Stage stage;
	public Scene scene;
	public Parent root;
    
    @FXML
    protected void onHelloButtonClick(ActionEvent e) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    } 
    

}
