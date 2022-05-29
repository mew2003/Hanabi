package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import principal.Card;
import principal.Deck;
import principal.Discard;
import principal.PlacedCard;
import principal.PlayerHand;
import principal.Token;

public class Controller {
	
	@FXML
    private Pane escapeMenu;
    @FXML
    private Pane playerName;
    @FXML
    private TextField player1;
    @FXML
    private TextField player2;
    @FXML
    private Pane playerTurn;
    @FXML
    private Label labelPlayerTurn;
    
	private Deck deck;
	private PlayerHand[] players;
	private PlacedCard placedCard;
	private Token redToken;
	private Token blueToken;
	private Discard discard;

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
    	playerTurn.setVisible(false);
    }
    
    @FXML
    protected void enteredNames(ActionEvent e) throws IOException {
    	if (!player1.getText().isBlank() && !player2.getText().isBlank()) {
    		partyConstruct();
    		playerName.setVisible(false);
    	}
    }
    
    private void partyConstruct() {
    	
    	/* Création des outils nécessaire au bon déroulement d'une partie */
		//Création du deck
		deck = new Deck();
		players = new PlayerHand[2];

		//Création des joueurs
        players[0] = new PlayerHand(player1.getText(), 2, deck);
        players[1] = new PlayerHand(player2.getText(), 2, deck);
        
        //Création du plateau de jeu
        placedCard = new PlacedCard();
        
        // Création des jetons
        redToken = new Token(0);
        blueToken = new Token(8);
        
        // Création de la défausse
        discard = new Discard();
        
        labelPlayerTurn.setText("Au tour de " + player1.getText());
        playerTurn.setVisible(true);
    	
    }
    
    private void setCardTheme(Card card, int position) {
    	
    	switch(card.getColor()) {
    		case "red" : {
    			switch(card.getValue()) {
    			    case 1 : {
    			    	
    			    }
    			    case 2 : {
    			    	
    			    }
    			    case 3 : {
    			    	
    			    }
    			    case 4 : {
    			    	
    			    }
    			    case 5 : {
    			    	
    			    }
    			}
    		}
    		case "yellow" : {
    			switch(card.getValue()) {
			    	case 1 : {
			    	
			    	}
			    	case 2 : {
			    	
			    	}
			    	case 3 : {
			    	
			    	}
			    	case 4 : {
			    	
			    	}
			    	case 5 : {
			    	
			    	}
    			}
    		}
    		case "blue" : {
    			switch(card.getValue()) {
			    	case 1 : {
			    	
			    	}
			    	case 2 : {
			    	
			    	}
			    	case 3 : {
			    	
			    	}
			    	case 4 : {
			    	
			    	}
			    	case 5 : {
			    	
			    	}
    			}
    		}
    		case "pink" : {
    			switch(card.getValue()) {
			    	case 1 : {
			    	
			    	}
			    	case 2 : {
			    	
			    	}
			    	case 3 : {
			    	
			    	}
			    	case 4 : {
			    	
			    	}
			    	case 5 : {
			    	
			    	}
    			}
    		}
    		case "white" : {
    			switch(card.getValue()) {
			    	case 1 : {
			    	
			    	}
			    	case 2 : {
			    	
			    	}
			    	case 3 : {
			    	
			    	}
			    	case 4 : {
			    	
			    	}
			    	case 5 : {
			    	
			    	}
    			}
    		}
    	}
    	
    }
    

}
