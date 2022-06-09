package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller2 {
	
	@FXML
    private Label scoreMessage1;
	@FXML
    private Label scoreMessage2;
	@FXML
    private Label scoreMessage3;
	
	public void displayScore(int score) {
		scoreMessage1.setText("Votre score est de " + score + " :");
		switch (score) {
			case 0, 1, 2, 3, 4, 5 -> {
				scoreMessage2.setText("Sur un cerisier mort, on ne trouve pas de fleurs.");
				scoreMessage3.setText("(枯れた桜には花がありません。)");
			}
			case 6, 7, 8, 9, 10 -> {
				scoreMessage2.setText("Ceux que l'on ne dit pas sont les fleurs du silence.");
				scoreMessage3.setText("(言わぬが花)");
			}
			case 11, 12, 13, 14, 15 -> {
				scoreMessage2.setText("On ne peut admirer en même temps la lune, la neige et les fleurs.");
				scoreMessage3.setText("(月、雪、花同時に見れいません)");
			}
			case 16, 17, 18, 19, 20 -> {
				scoreMessage2.setText("Même la pensée d'une fourmi peut toucher le ciel.");
				scoreMessage3.setText("(蟻の思いも天に昇る)");
			}
			case 21, 22, 23, 24 -> {
				scoreMessage2.setText("La fleur d'hier est le rêve d'aujourd'hui.");
				scoreMessage3.setText("(昨日の花は今日の夢)");
			}
			case 25 -> {
				scoreMessage2.setText("Il y a les êtres humains, et il y a vous.");
				scoreMessage3.setText("(人間とあなたがいます)");
			}
		}
	}
}
