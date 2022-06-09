package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
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
    private Circle hintRed;
    @FXML
    private Circle hintBlue;
    @FXML
    private Circle hintYellow;
    @FXML
    private Circle hintWhite;
    @FXML
    private Circle hintPink;
    @FXML
    private Circle hint1;
    @FXML
    private Circle hint2;
    @FXML
    private Circle hint3;
    @FXML
    private Circle hint4;
    @FXML
    private Circle hint5;
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
    @FXML
    private Label numberBlueToken;
    @FXML
    private Label numberRedToken;
    @FXML
    private Button placedCard1;
    @FXML
    private Button placedCard2;
    @FXML
    private Button placedCard3;
    @FXML
    private Button placedCard4;
    @FXML
    private Button placedCard5;
    @FXML
    private Pane playerHinted;
    @FXML
    private Button labelHintedPlayer1;
    @FXML
    private Pane logs;
    @FXML
    private TextArea logsMessage;
    
    
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
			"-fx-background-image: url(file:../../resources/img/Cartes/transparent.png)"
	};
	private Image[] imageButtonList = {
			new Image("file:../../resources/img/Button/Button1.png"),
			new Image("file:../../resources/img/Button/Button2.png"),
			new Image("file:../../resources/img/Button/Button3.png"),
			new Image("file:../../resources/img/Button/Button4.png"),
			new Image("file:../../resources/img/Button/Button5.png")
	};
	private int CurrentPlayer;
	private boolean playOrDiscard; // true = play, false = discard
	private Button[] placedCardList;
	private int playerHintSelect;
	private String[] log;
	private int lastTurn = 0;

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
    	if (playerTurn.isVisible()) {
    		playerTurn.setVisible(false);
    	}
    	escapeMenu.setVisible(false);

    }
    
    @FXML
    protected void enteredNames(ActionEvent e) throws IOException {
    	listeCardPlayers = new Button[][] {
			{card10, card11, card12, card13, card14},
			{card20, card21, card22, card23, card24},
    	};
    	placedCardList = new Button[] {
    			placedCard1, placedCard2, placedCard3, placedCard4, placedCard5
    	};
    	for (int i = 0 ; i < listeCardPlayers[0].length; i++) {
    		listeCardPlayers[0][i].setDisable(true);
    		listeCardPlayers[1][i].setDisable(true);
    	}
    	if (!player1.getText().isBlank() && !player2.getText().isBlank()) {
    		partyConstruct();
    		playerName.setVisible(false);
    	}
    }
    
    @FXML
    private void partyConstruct() throws IOException {
    	
    	hint1.setFill(new ImagePattern(imageButtonList[0]));
    	hint2.setFill(new ImagePattern(imageButtonList[1]));
    	hint3.setFill(new ImagePattern(imageButtonList[2]));
    	hint4.setFill(new ImagePattern(imageButtonList[3]));
    	hint5.setFill(new ImagePattern(imageButtonList[4]));
    	
    	/* Crï¿½ation des outils nï¿½cessaire au bon dï¿½roulement d'une partie */
		//Crï¿½ation du deck
		deck = new Deck();
		players = new PlayerHand[2];

		//Crï¿½ation des joueurs
        players[0] = new PlayerHand(player1.getText(), 2, deck);
        players[1] = new PlayerHand(player2.getText(), 2, deck);
        
        //Crï¿½ation du plateau de jeu
        placedCard = new PlacedCard();
        
        // Crï¿½ation des jetons
        redToken = new Token(0);
        blueToken = new Token(8);
        
        // Crï¿½ation de la dï¿½fausse
        discard = new Discard();
        
        // Création des logs
        log = new String[players.length];
        
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
    private void closeLogs(ActionEvent e) throws IOException {
    	logs.setVisible(false);
    	//TODO Corriger bug (affiche de selectedPlayOption, alors que le joueurs n'a pas encore clique
    	//sur fermé les logs 
    }
    
    @FXML
    protected void whoPlayOk(ActionEvent e) throws IOException {
    	playerTurn.setVisible(false);
    	logs.setVisible(true);
    	for (int i = 0; i < 5; i++) {
            for (int j = 0; j < players.length; j++) {
        	if (j != CurrentPlayer) {
        	    setCardTheme(players[j].getHand()[i], listeCardPlayers[j][i]);
        	}
            }
        }
    	
    	//System.out.println("Log : "); TODO
    	// TODO Créer la défausse
    	
    	selectedPlayOption();
    	
    }
    
    @FXML
    private void selectedPlayOption() {
    	for (int i = 0 ; i < listeCardPlayers[0].length; i++) {
    		listeCardPlayers[0][i].setDisable(true);
    		listeCardPlayers[1][i].setDisable(true);
    	}
    	playOptionHint.setVisible(false);
    	playerHinted.setVisible(false);
    	returnButton.setVisible(false);
    	playOption.setVisible(true);
    	
    }
    
    @FXML
    protected void optionPlay(ActionEvent e) throws IOException {
    	for (int i = 0 ; i < listeCardPlayers[0].length; i++) {
    		listeCardPlayers[CurrentPlayer][i].setDisable(false);
    	}
    	playOption.setVisible(false);
    	returnButton.setVisible(true);
    	playOrDiscard = true;
    	
    }
    
    @FXML
    protected void optionDraw(ActionEvent e) throws IOException {
    	for (int i = 0 ; i < listeCardPlayers[0].length; i++) {
    		listeCardPlayers[CurrentPlayer][i].setDisable(false);
    	}
    	playOption.setVisible(false);
    	returnButton.setVisible(true);
    	playOrDiscard = false;
    }
    
    @FXML
    protected void optionHint(ActionEvent e) throws IOException {
    	playOption.setVisible(false);
    	playerHinted.setVisible(true);
    	for (int i = 0; i < players.length; i++) {
    		if (i != CurrentPlayer) {
    			//TODO Refaire cette partie pour pouvoir l'adapter pour des parties avec plus de joueurs
    			labelHintedPlayer1.setText(players[i].getName());
    			playerHintSelect = i;
    			break;
    		}
    	}
    }
    
    @FXML
    protected void giveHint1(ActionEvent e) throws IOException {
    	playerHinted.setVisible(false);
    	for (int i = 0; i < players.length; i++) {
    	    if (i != CurrentPlayer) {
    	        for (int j = 0 ; j < listeCardPlayers[i].length; j++) {
    	    	    listeCardPlayers[i][j].setDisable(false);
    	    	}
    	    }
    	}
    	playOptionHint.setVisible(true);
    	
    }
    
    @FXML
    protected void card10Pressed(ActionEvent e) throws IOException { playAndDiscard(0); }
    @FXML
    protected void card11Pressed(ActionEvent e) throws IOException { playAndDiscard(1); }
    @FXML
    protected void card12Pressed(ActionEvent e) throws IOException { playAndDiscard(2); }
    @FXML
    protected void card13Pressed(ActionEvent e) throws IOException { playAndDiscard(3); }
    @FXML
    protected void card14Pressed(ActionEvent e) throws IOException { playAndDiscard(4); }
    @FXML
    protected void card20Pressed(ActionEvent e) throws IOException { playAndDiscard(0); }
    @FXML
    protected void card21Pressed(ActionEvent e) throws IOException { playAndDiscard(1); }
    @FXML
    protected void card22Pressed(ActionEvent e) throws IOException { playAndDiscard(2); }
    @FXML
    protected void card23Pressed(ActionEvent e) throws IOException { playAndDiscard(3); }
    @FXML
    protected void card24Pressed(ActionEvent e) throws IOException { playAndDiscard(4); }
    
    private void playAndDiscard(int position) {
    	if (playOrDiscard) {
    		log[log.length - 1] = players[CurrentPlayer].getName() + ", A joué la carte : "
                    + players[CurrentPlayer].playACard(position, deck, redToken, blueToken, placedCard, discard);
    		endTurn();
    	} else {
    		log[log.length - 1] = players[CurrentPlayer].getName() + ", A défaussé la carte : "
                    + players[CurrentPlayer].discardACard(position, deck, blueToken, discard);
    		endTurn();
    	}
    }
    
    @FXML
    protected void hintRedPressed(MouseEvent e) throws IOException { giveHint("red"); }
    @FXML
    protected void hintBluePressed(MouseEvent e) throws IOException { giveHint("blue"); }
    @FXML
    protected void hintYellowPressed(MouseEvent e) throws IOException { giveHint("yellow"); }
    @FXML
    protected void hintWhitePressed(MouseEvent e) throws IOException { giveHint("white"); }
    @FXML
    protected void hintPinkPressed(MouseEvent e) throws IOException { giveHint("pink"); }
    @FXML
    protected void hint1Pressed(MouseEvent e) throws IOException { giveHint(1); }
    @FXML
    protected void hint2Pressed(MouseEvent e) throws IOException { giveHint(2); }
    @FXML
    protected void hint3Pressed(MouseEvent e) throws IOException { giveHint(3); }
    @FXML
    protected void hint4Pressed(MouseEvent e) throws IOException { giveHint(4); }
    @FXML
    protected void hint5Pressed(MouseEvent e) throws IOException { giveHint(5); }
    
    private void giveHint(String colorHint) {
    	playOptionHint.setVisible(false);
    	System.arraycopy(log, 1, log, 0, log.length - 1);
        log[log.length - 1] = players[playerHintSelect].getName() + ", Cartes en position : "
                + players[CurrentPlayer].giveAHint(players[playerHintSelect], blueToken, colorHint);
    	endTurn();
    }
    private void giveHint(int valueHint) {
    	playOptionHint.setVisible(false);
    	System.arraycopy(log, 1, log, 0, log.length - 1);
        log[log.length - 1] = players[playerHintSelect].getName() + ", Cartes en position : "
                + players[CurrentPlayer].giveAHint(players[playerHintSelect], blueToken, valueHint);
    	endTurn();
    }
    
    private void endTurn() {

    	Card[] temp = placedCard.getCardList();
    	logsMessage.setText(log[1]);
    	//TODO Actualiser l'affichage de la défausse
    	numberBlueToken.setText(blueToken.toString());
    	numberRedToken.setText(redToken.toString());
    	for (int i = 0; i < temp.length; i++) {
    		setCardTheme(temp[i], placedCardList[i]);
    	}
    	
    	for (int i = 0; i < players.length; i++) {
    	    for (int j = 0 ; j < listeCardPlayers[i].length; j++) {
        	listeCardPlayers[i][j].setDisable(true);
        	if (players[i].getHand()[j].getColor() != "") {
                    listeCardPlayers[i][j].setStyle("-fx-background-image: url(file:../../resources/img/DosCarte.png)");
                } else {
                    listeCardPlayers[i][j].setStyle("-fx-background-image: url(file:../../resources/img/Cartes/transparent.png)");
                }
    	    }
    	}
    	CurrentPlayer++;
    	if (CurrentPlayer == players.length) {
    		CurrentPlayer = 0;
    	}
    	
    	//Condition de fin de partie 
    	if (redToken.getValue() == 3) {
            System.out.println("C'est la fin");
        }
    	if (deck.getNbCards() == 0) {
            lastTurn++;
            if (lastTurn == players.length + 1) {
           	System.out.println("C'est la fin");
            }
        }
    	whoPlay();
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
    		default -> {
    		    button.setStyle(imageList[25]);
    		}
    	}
    }
    

}