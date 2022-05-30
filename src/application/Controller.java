package application;

import java.io.IOException;
import java.time.Duration;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
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
    @FXML
    private Button card10;
    @FXML
    private Button card11;
    @FXML
    private Button card12;
    @FXML
    private Button card13;
    @FXML
    private Button card14;
    @FXML
    private Button card20;
    @FXML
    private Button card21;
    @FXML
    private Button card22;
    @FXML
    private Button card23;
    @FXML
    private Button card24;
    @FXML
    private Label player1Name;
    @FXML
    private Label player2Name;
    @FXML
    private Pane playOption;
    @FXML
    private Button returnButton;
    @FXML
    private Pane playOptionHint;
    
	private Deck deck;
	private PlayerHand[] players;
	private PlacedCard placedCard;
	private Token redToken;
	private Token blueToken;
	private Discard discard;
	private Button[][] listeCardPlayers;
	private String[] imageList = {
			"-fx-background-image: url(file:../../resources/img/Cartes/red1.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/red2.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/red3.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/red4.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/red5.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/yellow1.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/yellow2.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/yellow3.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/yellow4.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/yellow5.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/blue1.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/blue2.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/blue3.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/blue4.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/blue5.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/pink1.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/pink2.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/pink3.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/pink4.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/pink5.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/white1.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/white2.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/white3.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/white4.png)",
			"-fx-background-image: url(file:../../resources/img/Cartes/white5.png)",
	};
	private int CurrentPlayer;

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
    
    @FXML
    private void partyConstruct() throws IOException {
    	
    	listeCardPlayers = new Button[][] {
    			{card10, card11, card12, card13, card14},
    			{card20, card21, card22, card23, card24},
    	};
    	
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
        
        CurrentPlayer = 0;
        player1Name.setText(players[0].getName());
        player2Name.setText(players[1].getName());
        
        whoPlay();
        
    }
    
    private void whoPlay() {
    	labelPlayerTurn.setText("Au tour de " + players[CurrentPlayer].getName());
        playerTurn.setVisible(true);
        
    }
    
    @FXML
    protected void whoPlayOk(ActionEvent e) throws IOException {
    	playerTurn.setVisible(false);
    	for (int i = 0; i < 5; i++) {
        	for (int j = 0; j < players.length; j++) {
        		if (j != CurrentPlayer) {
        			setCardTheme(players[j].getHand()[i], listeCardPlayers[j][i]);
        		}
        	}
        }
    	
    	//System.out.println("Log : "); TODO
    	// TODO Permettre de check la défausse
    	
    	selectedPlayOption();
    	
    }
    
    @FXML
    private void selectedPlayOption() {
    	
    	playOptionHint.setVisible(false);
    	returnButton.setVisible(false);
    	playOption.setVisible(true);
    	
    }
    
    @FXML
    protected void optionPlay(ActionEvent e) throws IOException {
    	
    	playOption.setVisible(false);
    	returnButton.setVisible(true);
    	
    }
    
    @FXML
    protected void optionDraw(ActionEvent e) throws IOException {
    	
    	playOption.setVisible(false);
    	returnButton.setVisible(true);
    	
    }
    
    @FXML
    protected void optionHint(ActionEvent e) throws IOException {
    	
    	playOption.setVisible(false);
    	playOptionHint.setVisible(true);
    	
    }
    
    
    
    private void setCardTheme(Card card, Button button) {
    	
    	switch(card.getColor()) {
    		case "red" -> {
    			switch(card.getValue()) {
    			    case 1 -> {
    			    	button.setStyle(imageList[0]);
    			    }
    			    case 2 -> {
    			    	button.setStyle(imageList[1]);
    			    }
    			    case 3 -> {
    			    	button.setStyle(imageList[2]);
    			    }
    			    case 4 -> {
    			    	button.setStyle(imageList[3]);
    			    }
    			    case 5 -> {
    			    	button.setStyle(imageList[4]);
    			    }
    			}
    		}
    		case "yellow" -> {
    			switch(card.getValue()) {
			    	case 1 -> {
			    		button.setStyle(imageList[5]);
			    	}
			    	case 2 -> {
			    		button.setStyle(imageList[6]);
			    	}
			    	case 3 -> {
			    		button.setStyle(imageList[7]);
			    	}
			    	case 4 -> {
			    		button.setStyle(imageList[8]);
			    	}
			    	case 5 -> {
			    		button.setStyle(imageList[9]);
			    	}
    			}
    		}
    		case "blue" -> {
    			switch(card.getValue()) {
			    	case 1 -> {
			    		button.setStyle(imageList[10]);
			    	}
			    	case 2 -> {
			    		button.setStyle(imageList[11]);
			    	}
			    	case 3 -> {
			    		button.setStyle(imageList[12]);
			    	}
			    	case 4 -> {
			    		button.setStyle(imageList[13]);
			    	}
			    	case 5 -> {
			    		button.setStyle(imageList[14]);
			    	}
    			}
    		}
    		case "pink" -> {
    			switch(card.getValue()) {
			    	case 1 -> {
			    		button.setStyle(imageList[15]);
			    	}
			    	case 2 -> {
			    		button.setStyle(imageList[16]);
			    	}
			    	case 3 -> {
			    		button.setStyle(imageList[17]);
			    	}
			    	case 4 -> {
			    		button.setStyle(imageList[18]);
			    	}
			    	case 5 -> {
			    		button.setStyle(imageList[19]);
			    	}
    			}
    		}
    		case "white" -> {
    			switch(card.getValue()) {
			    	case 1 -> {
			    		button.setStyle(imageList[20]);
			    	}
			    	case 2 -> {
			    		button.setStyle(imageList[21]);
			    	}
			    	case 3 -> {
			    		button.setStyle(imageList[22]);
			    	}
			    	case 4 -> {
			    		button.setStyle(imageList[23]);
			    	}
			    	case 5 -> {
			    		button.setStyle(imageList[24]);
			    	}
    			}
    		}
    	}
    }
    

}