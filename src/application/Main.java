package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


/** 
 * TODO Commenter la responsabilit� de cette class
 * @author
 *
 */
public class Main extends Application {
    
	/**
	 * TODO Commenter le r�le (SRP) de cette m�thode
	 * @param primaryStage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/** 
	 * TODO Commenter le r�le (SRP) de cette m�thode
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
