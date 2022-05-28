module Hanabi {
	requires javafx.controls;
	requires org.junit.jupiter.api;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
