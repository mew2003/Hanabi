package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import principal.Deck;

public class Controller {
	
	@FXML
    private Pane escapeMenu;
    @FXML
    private Pane playerName;
    @FXML
    private TextField player1;
    @FXML
    private TextField player2;
    
	private Deck deck;
	private boolean playerNamesEntered = false;

    public void initialize() {
    	
    }
    
    public Stage stage;
	public Scene scene;
	public Parent root;
	
    @FXML
    protected void switchToHanabi(ActionEvent e) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("Hanabi.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
    } 
    
    @FXML
    protected void switchToMenu(ActionEvent e) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
    } 
    
    @FXML
    protected void switchToRules(ActionEvent e) throws IOException {
    	root = FXMLLoader.load(getClass().getResource("Rules.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.setScene(scene);
		stage.show();
    } 
    
    @FXML
    protected void switchToGameBoard2(ActionEvent e) throws IOException, InterruptedException {
    	root = FXMLLoader.load(getClass().getResource("GameBoard2.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		scene = new Scene(root);
		scene.getStylesheets().add(getClass().getResource("GameBoard.css").toExternalForm());
		
		/* Création des outils nécessaire au bon déroulement d'une partie */
		//Création du deck
		deck = new Deck();
		
		//Création des joueurs
		while (!playerNamesEntered) {wait(1000);}
		System.out.println("gg bg t'a écrit les noms");
		
		stage.setScene(scene);
		stage.show();
		
    }
    
    @FXML
    protected void pressed(KeyEvent e) throws IOException {
    	if (e.getCode() == KeyCode.ESCAPE) {
    		if (escapeMenu.isVisible()) {
    			escapeMenu.setVisible(false);
    		} else {
    			escapeMenu.setVisible(true);
    		}
    	}
    }
    
    @FXML
    protected void returnGame(ActionEvent e) throws IOException {
    	escapeMenu.setVisible(false);
    }
    
    @FXML
    protected void enteredNames(ActionEvent e) throws IOException {
    	
    	if (!player1.getText().isBlank() && !player2.getText().isBlank()) {
    		playerName.setVisible(false);
    		playerNamesEntered = true;
    	}
    	
    }
    

}
