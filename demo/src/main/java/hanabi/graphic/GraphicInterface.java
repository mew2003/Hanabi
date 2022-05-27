package graphic;

public class GraphicInterface {

    //create a scene with javafx
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //create a stage
        Stage stage = new Stage();
        //create a scene
        Scene scene = new Scene(new Group(), 1920, 1080);
        //set the scene to the stage
        stage.setScene(scene);
        //show the stage
        stage.show();
    }
    //create a pane
    private Pane pane = new Pane();

    //create a button
    private Button button = new Button("Click me!");

    //custom the pane with a background image
    private void customPane() {
        pane.setStyle("-fx-background-image: url('/images/background.jpg'); "
                + "-fx-background-size: 1920 1080; "
                + "-fx-background-repeat: stretch;");
    }

    //custom the button with a background image and a border style
    private void customButton() {
        button.setStyle("-fx-background-image: url('/images/buttonColor.jpg'); "
                + "-fx-background-size: cover cover; "
                + "-fx-background-repeat: stretch; "
                + "-fx-border-color: black; "
                + "-fx-border-width: 2; "
                + "-fx-border-radius: 15; "
                + "-fx-border-style: solid;");
    }

    //the button contain a text "Jouer" with a font style Quintessential and an outer shadow 2px black
    private void customButtonText() {
        button.setText("Jouer");
        button.setStyle("-fx-font-family: Quintessential; "
                + "-fx-font-size: 96; "
                + "-fx-text-fill: white; "
                + "-fx-effect: dropshadow(gaussian, black, 2, 0, 0, 0);");
    }

    //add the button to the pane
    private void addButtonToPane() {
        pane.getChildren().add(button);
    }

    //set the button position center of the pane
    private void setButtonPosition() {
        button.setLayoutX(pane.getWidth() / 2 - button.getWidth() / 2);
        button.setLayoutY(pane.getHeight() / 2 - button.getHeight() / 2);
    }

    //set the button action change the scene to the game
    private void setButtonAction() {
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // TODO Auto-generated method stub
                //create a new scene
                Scene scene = new Scene(new Group(), 1920, 1080);
                //create a new stage
                Stage stage = new Stage();
                //set the scene to the stage
                stage.setScene(scene);
                //show the stage
                stage.show();
            }
        });
    }

    //create a new graphic interface
    public GraphicInterface() {
        // TODO Auto-generated constructor stub
        //custom the pane
        customPane();
        //custom the button
        customButton();
        //custom the button text
        customButtonText();
        //add the button to the pane
        addButtonToPane();
        //set the button position
        setButtonPosition();
        //set the button action
        setButtonAction();
    }

    //get the pane
    public Pane getPane() {
        return pane;
    }

    //get the button
    public Button getButton() {
        return button;
    }










}
