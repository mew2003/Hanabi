/**
 * @author nous
 *
 */
module Hanabi {
	requires javafx.controls;
	requires org.junit.jupiter.api;
	requires javafx.graphics;
	requires javafx.fxml;
	
	opens application to javafx.graphics, javafx.fxml;
}
